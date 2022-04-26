package main.java.weapon;

import main.java.character.Character;
import main.java.character.ConcreteCharacter;

public class Wand extends Weapon {
    static final int STARTING_DAMAGE = 5;

    /**
     * Constructor for Wand class. Sets starting damage.
     * @param character
     */
    public Wand(Character character) {
        super(character);
        this.setDamage(STARTING_DAMAGE);
    }

    @Override
    public void construct() {
        // TODO Auto-generated method stub

    }

    @Override
    public int strike(ConcreteCharacter character) {
        return character.getStrength();
    }
    
    @Override
    public String toString() {
        return "Wand";
    }

    @Override
    public int addEffects(Character character) {
        // TODO Auto-generated method stub
        return 0;
    }
}

