```mermaid
graph TD
    Dirt([Dirt])
    Gravel{{Gravel}}
    Stone{{Stone}}
    Coal{{Coal}}
    Iron{{Iron}}
    Magma
    Netherrack
    Quartz
    Sand

    Copper
    Gold
    Diamond
    Emerald
    Lapis
    Amethyst
    Redstone
    
    Dirt --> Gravel
    
    Gravel -- gravel block --> Stone

    Stone --> Coal

    Coal --> Iron
    Stone --> Iron

    Stone -- lava block --> Magma

    Magma --> Netherrack
    Stone --> Netherrack
    
    Sand --> Quartz
    Magma --> Quartz
    
    Gravel -- water block --> Sand
    
    Magma --> Diamond
    Coal --> Diamond
    
    Quartz --> Amethyst
    Magma --> Amethyst
```

