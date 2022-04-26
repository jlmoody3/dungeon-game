package main.java.weapon;

import main.java.character.Character;
import main.java.character.ConcreteCharacter;

public class Sword extends Weapon {
    static final int STARTING_DAMAGE = 10;

    /**
     * Constructor for Sword class. Sets starting damage.
     * @param character
     */
    public Sword(Character character) {
        super(character);
        this.setDamage(STARTING_DAMAGE);
    }

    @Override
    public void construct() {
        // TODO Auto-generated method stub

    }

    @Override
    public int strike(ConcreteCharacter character) {
        return character.getLevel() * STARTING_DAMAGE;
    }
    
    @Override
    public String toString() {
        return "Sword";
    }

    @Override
    public int addEffects(Character character) {
        // TODO Auto-generated method stub
        return 0;
    }
}
