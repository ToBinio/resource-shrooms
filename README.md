```mermaid
graph TD
    Dirt([Dirt])
    Gravel{{Gravel}}
    Stone{{Stone}}
    Coal{{Coal}}
    Iron{{Iron}}
    Magma{{Magma}}
    Netherrack{{Netherrack}}
    Quartz{{Quartz}}
    Sand{{Sand}}
    Moss{{Moss}}
    Copper{{Copper}}
    Amethyst{{Amethyst}}
    Diamond
    Calcite
    Gold
    Emerald
    Lapis
    Redstone

    MossBlock[[MossBlock]]
    GravelBlock[[GravelBlock]]
    LavaBlock[[LavaBlock]]
    WaterBlock[[WaterBlock]]
    
    Dirt --> Gravel
    GravelBlock --> Gravel
    
    Dirt --> Moss
    MossBlock --> Moss
    
    Gravel --> Stone
    GravelBlock --> Stone
    
    Gravel --> Calcite
    Stone --> Calcite

    Stone --> Coal

    Coal --> Iron
    Stone --> Iron
    
    Calcite --> Lapis
    Iron --> Lapis
    
    Moss --> Copper
    Iron --> Copper

    Stone --> Netherrack
    LavaBlock --> Netherrack
    
    Sand --> Quartz
    Magma --> Quartz
    
    Gravel --> Sand
    WaterBlock --> Sand
    
    Magma --> Diamond
    Coal --> Diamond
    
    Netherrack --> Magma
    LavaBlock --> Magma
    
    Quartz --> Amethyst
    Magma --> Amethyst
    
    Magma --> Emerald
    Amethyst --> Emerald
    Moss --> Emerald
    
    Amethyst --> Gold
    Magma --> Gold
    Iron --> Gold
    
    Lapis --> Redstone
    Copper --> Redstone
```

