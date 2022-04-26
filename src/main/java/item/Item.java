package main.java.item;

import main.java.character.ConcreteCharacter;
import main.java.character.Character;

public abstract class Item implements Character {

    public abstract void getItem(ConcreteCharacter character, Item item);
    public abstract int addEffects(Character character);
}
