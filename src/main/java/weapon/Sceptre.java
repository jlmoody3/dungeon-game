package main.java.weapon;

import java.util.Random;

import main.java.character.Character;
import main.java.character.ConcreteCharacter;

public class Sceptre extends Weapon {
    static final int STARTING_DAMAGE = 15;
    static final int LOW_STRENGTH = 5;
    static final int HIGH_STRENGTH = 20;
    
    public Sceptre(Character character) {
        super(character);
        this.setDamage(STARTING_DAMAGE);
    }

    @Override
    public void construct() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int strike(ConcreteCharacter character) {
        Random random = new Random();
        return random.nextInt(character.getLevel() * HIGH_STRENGTH) + character.getLevel() * LOW_STRENGTH;
    }
    
    @Override
    public String toString() {
        return "Sceptre";
    }

    @Override
    public int addEffects(Character character) {
        // TODO Auto-generated method stub
        return 0;
    }


}
