package main.java.weapon;

import main.java.character.Character;
import main.java.character.ConcreteCharacter;

public class Bow extends Weapon {
    static final double STARTING_DAMAGE = 7.5;

    /**
     * Constructor for Bow class. Sets starting damage.
     * @param character
     */
    public Bow(Character character) {
        super(character);
        this.setDamage((int) STARTING_DAMAGE);
    }

    @Override
    public void construct() {
        // TODO Auto-generated method stub

    }

    @Override
    public int strike(ConcreteCharacter character) {
        return (int)(character.getLevel() * STARTING_DAMAGE);
    }
    
    @Override
    public String toString() {
        return "Bow";
    }

    @Override
    public int addEffects(Character character) {
        // TODO Auto-generated method stub
        return 0;
    }
}
