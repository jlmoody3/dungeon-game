package main.java.weapon;

import main.java.character.Character;

public class Club extends Weapon {
    static final int STARTING_DAMAGE = 15;
    
    public Club(Character character) {
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
        return "Club";
    }


}