package main.java.item;

import main.java.character.Character;
import main.java.character.ConcreteCharacter;

public abstract class Item implements Character {

    public abstract void getItem(ConcreteCharacter character, Item item);
    public abstract int addEffects(Character character);
}
