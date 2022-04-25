package main.java.weapon;

import main.java.character.Character;

public class Sword extends Weapon {
    static final int STARTING_DAMAGE = 10;

    /**
     * Constructor for Sword class. Sets starting damage.
     * @param character
     */
    public Sword(Character character) {
        super(character);
        this.setDamage(STARTING_DAMAGE);
        System.out.println("You have a sword.");
    }

    @Override
    public void construct() {
        // TODO Auto-generated method stub

    }

    @Override
    public int strike(int level) {
        // TODO Auto-generated method stub
        return 0;
    }
}
