package main.java.item;

import main.java.character.Character;
import main.java.character.ConcreteCharacter;

public class TemporaryItem extends Item {

    static final int NUM_ITEMS = 6;
    private Character character;
    
    public TemporaryItem(Character character) {
        this.character = character;
    }
    
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
