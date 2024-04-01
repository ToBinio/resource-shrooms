```mermaid
graph TD
    Dirt(Dirt)
    Gravel
    Stone{{Stone}}
    Coal{{Coal}}
    Iron{{Iron}}
    Fire
    Lava
    Netherrack
    Quartz
    Sand

    Copper
    Gold
    Diamond
    Emerald
    Lapis
    
    Dirt --> Gravel
    
    Gravel -- gravel block --> Stone

    Stone --> Coal

    Stone --> Iron
    Coal --> Iron

    Coal -- fire block --> Fire

    Fire -- lava block --> Lava

    Lava --> Netherrack
    Stone --> Netherrack
    
    Sand --> Quartz
    Lava --> Quartz
    
    Stone -- water block --> Sand
    
    Coal --> Diamond
    Lava --> Diamond
    
    Quartz --> Emerald
    Lava --> Emerald
```

