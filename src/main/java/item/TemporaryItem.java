package main.java.item;

import main.java.character.Character;
import main.java.character.ConcreteCharacter;

public class TemporaryItem extends Item {

    @Override
    public void construct() {

    }

    @Override
    public int strike(ConcreteCharacter character) {
        return 0;
    }

    @Override
    public void getItem(ConcreteCharacter character, Item item) {
   
    }

    @Override
    public int addEffects(Character character) {
        return 0;
    }

}