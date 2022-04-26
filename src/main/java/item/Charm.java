package main.java.item;

import main.java.character.Character;

public class Charm extends PermanentItem {

    static final int EFFECT_INCREASE = 2;

    public Charm(Character character) {
        super(character);
    }

    public int addEffects(Character character) {
        return character.addEffects(character) + EFFECT_INCREASE;
    }

    public int getEffectIncrease() {
        return EFFECT_INCREASE;
    }
}
