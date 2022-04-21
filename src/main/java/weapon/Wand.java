package main.java.weapon;

import main.java.character.Character;

public class Wand extends Weapon {
    static final int STARTING_DAMAGE = 5;
    
    public Wand(Character character) {
        super(character);
        this.setDamage(STARTING_DAMAGE);
        System.out.println("You have a wand.");
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