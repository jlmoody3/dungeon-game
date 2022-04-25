package main.java.weapon;

import main.java.character.Character;

public class Bow extends Weapon {
    static final int STARTING_DAMAGE = 7;

    /**
     * Constructor for Bow class. Sets starting damage.
     * @param character
     */
    public Bow(Character character) {
        super(character);
        this.setDamage(STARTING_DAMAGE);
        System.out.println("You have a bow.");
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
