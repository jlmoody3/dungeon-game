package main.java.item;

import main.java.character.Character;

public class Glasses extends PermanentItem {

    static final int EFFECT_INCREASE = 6;

    public Glasses(Character character) {
        super(character);
    }

    public int addEffects(Character character) {
        return character.addEffects(character) + EFFECT_INCREASE;
    }
    
    public int getEffectIncrease() {
        return EFFECT_INCREASE;
    }
}
