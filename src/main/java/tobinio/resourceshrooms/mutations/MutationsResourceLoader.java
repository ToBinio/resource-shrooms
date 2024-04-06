package tobinio.resourceshrooms.mutations;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
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

public class MutationsResourceLoader implements SimpleSynchronousResourceReloadListener {
    @Override
    public Identifier getFabricId() {
        return new Identifier(ResourceShrooms.MOD_ID, "mutations_resources");
    }

    @Override
    public void reload(ResourceManager manager) {
        Mutations.clear();

        for (Map.Entry<Identifier, Resource> resource : manager.findResources("resource_mushrooms/mutations", path -> path.getPath()
                .endsWith(".json")).entrySet()) {

            ResourceShrooms.LOGGER.info("parsing %s".formatted(resource.getKey()));

            try (InputStream stream = resource.getValue().getInputStream()) {
                String fileContent = new String(stream.readAllBytes());
                JsonObject data = JsonHelper.deserialize(fileContent);

                for (Map.Entry<String, JsonElement> rawMutations : data.asMap().entrySet()) {
                    Optional<Mushroom> result = Mushrooms.getFromString(rawMutations.getKey());

                    if (result.isPresent()) {

                        List<Mutation> mutations = parseMutations(result.get(), rawMutations.getValue());

                        for (Mutation mutation : mutations) {
                            Mutations.addMutation(mutation);
                        }

                    } else {
                        ResourceShrooms.LOGGER.error("No mushroom found with name %s".formatted(rawMutations.getKey()));
                    }
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

            List<Block> requirements = new ArrayList<>();

            for (JsonElement rawBlock : base.get("requirements").getAsJsonArray()) {
                Optional<Block> block = stringToBlock(rawBlock.getAsString());


                if (block.isPresent()) {
                    requirements.add(block.get());
                } else {
                    ResourceShrooms.LOGGER.error("No block found with name %s".formatted(rawBlock.getAsString()));
                }

            }

            int chance = base.get("chance").getAsInt();

            mutations.add(new Mutation(requirements, result, chance));
        }

        return mutations;
    }

    private Optional<Block> stringToBlock(String string) {
        return Registries.BLOCK.getOrEmpty(Identifier.tryParse(string));
    }
}
