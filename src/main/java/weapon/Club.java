package main.java.weapon;

import main.java.character.Character;
import main.java.character.ConcreteCharacter;

public class Club extends Weapon {
    static final int STARTING_DAMAGE = 15;

    /**
     * Constructor for Club class. Sets starting damage.
     * @param character
     */
    public Club(Character character) {
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
        return "Club";
    }

    @Override
    public int addEffects(Character character) {
        // TODO Auto-generated method stub
        return 0;
    }
}

