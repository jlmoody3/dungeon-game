package main.java.item;

import main.java.character.Character;

public class Armor extends PermanentItem {

    static final int EFFECT_INCREASE = 5;

    public Armor(Character character) {
        super(character);
    }

    public int addEffects(Character character) {
        return character.addEffects(character) + EFFECT_INCREASE;
    }

    public int getEffectIncrease() {
        return EFFECT_INCREASE;
    }
}
