package main.java.item;

import main.java.character.Character;

public class Helmet extends PermanentItem {

    static final int EFFECT_INCREASE = 3;

    public Helmet(Character character) {
        super(character);
    }

    public int addEffects(Character character) {
        return character.addEffects(character) + EFFECT_INCREASE;
    }

    public int getEffectIncrease() {
        return EFFECT_INCREASE;
    }
}
