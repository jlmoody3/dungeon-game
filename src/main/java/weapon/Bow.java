package main.java.weapon;

import main.java.character.Character;

public class Bow extends Weapon {
    static final int STARTING_DAMAGE = 7;
    
    public Bow(Character character) {
        super(character);
        this.setDamage(STARTING_DAMAGE);
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
    
    @Override
    public String toString() {
        return "Bow";
    }

}