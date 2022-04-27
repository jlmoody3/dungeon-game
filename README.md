# Dungeon Warrior

In this game, I plan to use the following 3 design patterns:

- Factory pattern for creating characters
- Decorator for abilities
- Observer for watching when health goes down to 15% or 0.

Using the Factory Pattern, I fulfilled the following requirement:
- "You should be able to choose a type for your character..."

Using the Decorator Pattern, I fulfilled the following requirements:
- "Your character should be able to equip items..."
- "Your simulation should include at least 3 temporary status effects and 1 permanent status effect..."

Using the State Pattern, I fulfilled the following requirements:
- "You should encounter a randomly generated 'small' enemy every floor..."
- "All enemies should get harder for each floor you travel to..."
- "The game should run on cycles..."

I also fulfilled the following requirements elsewhere in the game:
- "After each battle you should have a small chance to find a chest..."
- "Potions should never give more Health or Mana than you have as a maximum."
- "After each floor... you should go back to the top floor if your health is below 15%..."
- "Your character should have at a minimum: Stats..."
