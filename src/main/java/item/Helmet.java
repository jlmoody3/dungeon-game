package main.java.item;

import main.java.character.Character;

public class Helmet extends PermanentItem {

    public Helmet(Character character) {
        super(character);
    }
    
    public int addEffects(Character character) {
        return character.addEffects(character) + 5;
    }
}
