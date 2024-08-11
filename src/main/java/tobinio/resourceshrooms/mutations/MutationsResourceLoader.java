package tobinio.resourceshrooms.mutations;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import tobinio.resourceshrooms.ResourceShrooms;
import tobinio.resourceshrooms.mushrooms.Mushroom;
import tobinio.resourceshrooms.mushrooms.Mushrooms;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static tobinio.resourceshrooms.ResourceShrooms.id;

public class MutationsResourceLoader implements SimpleSynchronousResourceReloadListener {
    @Override
    public Identifier getFabricId() {
        return id("mutations_resources");
    }

    @Override
    public void reload(ResourceManager manager) {
        Mutations.clear();

        for (Map.Entry<Identifier, Resource> resource : manager.findResources("resource_mushrooms/mutations", path -> path.getPath()
                .endsWith(".json")).entrySet()) {

            ResourceShrooms.LOGGER.info("parsing %s".formatted(resource.getKey()));

            try (InputStream stream = resource.getValue().getInputStream()) {
                String fileContent = new String(stream.readAllBytes());
                JsonArray data = JsonHelper.deserializeArray(fileContent);

                String[] nameSplit = resource.getKey().toString().split("/");
                String name = nameSplit[nameSplit.length - 1].split("\\.")[0];

                Optional<Mushroom> result = Mushrooms.getFromString(name);

                if (result.isPresent()) {

                    List<Mutation> mutations = parseMutations(result.get(), data);

                    for (Mutation mutation : mutations) {
                        Mutations.addMutation(mutation);
                    }

                } else {
                    ResourceShrooms.LOGGER.error("No mushroom found with name %s".formatted(name));
                }

            } catch (Exception e) {
                ResourceShrooms.LOGGER.error("Error occurred while loading resource json %s".formatted(resource.getKey()
                        .toString()), e);
            }
        }
    }

    private List<Mutation> parseMutations(Mushroom result, JsonElement jsonElement) {
        List<Mutation> mutations = new ArrayList<>();

        for (JsonElement element : jsonElement.getAsJsonArray()) {

            JsonObject base = element.getAsJsonObject();

            List<Block> blockRequirements = new ArrayList<>();
            List<TagKey<Block>> tagRequirements = new ArrayList<>();

            for (JsonElement rawBlock : base.get("requirements").getAsJsonArray()) {
                String string = rawBlock.getAsString();

                if (string.startsWith("#")) {
                    Identifier id = Identifier.tryParse(string.substring(1));

                    if (id == null) {
                        ResourceShrooms.LOGGER.error("invalid id %s".formatted(string));
                        continue;
                    }

                    var key = TagKey.of(RegistryKeys.BLOCK, id);
                    tagRequirements.add(key);
                } else {
                    Optional<Block> block = stringToBlock(string);

                    if (block.isPresent()) {
                        blockRequirements.add(block.get());
                    } else {
                        ResourceShrooms.LOGGER.error("No block found with name %s".formatted(string));
                    }
                }
            }

            int chance = base.get("chance").getAsInt();

            mutations.add(new Mutation(blockRequirements, tagRequirements, result, chance));
        }

        return mutations;
    }

    private Optional<Block> stringToBlock(String string) {
        return Registries.BLOCK.getOrEmpty(Identifier.tryParse(string));
    }
}
