# Keep Inventory Penalty

Lightweight keepInventory enforcement with configurable death penalties.

When a player dies, the mod can keep their inventory, remove part of their vanilla experience, and damage equipped items. The default settings provide a simple, repair-friendly penalty curve:

- Enable vanilla `keepInventory` on server start.
- Keep one third of total vanilla experience and remove two thirds.
- Apply 80 durability damage to armor, main hand, off hand, Curios slots, and Accessories slots.
- Allow the damage to reach max durability damage, so it pairs well with no-break mods such as Keep My Sword.

## Configuration

Config file: `config/keep_inventory_penalty-common.toml`

Important options:

- `death.enforceKeepInventory`
- `death.experienceKeepRatio`
- `durability.durabilityLoss`
- `durability.damageArmor`
- `durability.damageMainHand`
- `durability.damageOffHand`
- `durability.damageCurios`
- `durability.damageAccessories`

## Requirements

- Minecraft 1.21.1
- NeoForge

Curios and Accessories are optional. If installed, their equipped item slots can be included in the durability penalty.
