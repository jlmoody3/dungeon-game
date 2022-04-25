package main.java.weapon;

import main.java.character.Character;

public class Power extends Weapon {
    static final int STARTING_DAMAGE = 10;

    /**
     * Constructor for Power class. Sets starting damage.
     * @param character
     */
    public Power(Character character) {
        super(character);
        this.setDamage(STARTING_DAMAGE);
        System.out.println("You have power.");
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
