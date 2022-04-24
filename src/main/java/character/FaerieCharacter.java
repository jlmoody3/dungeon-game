package main.java.character;

import java.util.Random;

public class FaerieCharacter extends ConcreteCharacter {
    public FaerieCharacter() {
        super(CharacterType.FAERIE);
        this.setStrength(13);
        this.setDefense(10);
        this.setSpeed(15);
        this.setAccuracy(11);
        this.setLuck(0.07);
        this.setHealthPoints(100);
        
        construct();
    }
    
    public void construct() {
        System.out.println("Congratulations! You are a faerie.");
    }

    @Override
    public void getWeapon() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int strike(int level) {
        return level * 5;
    }

    @Override
    public void takeDamage(int damage) {
        int hp = getHealthPoints();
        hp = hp - damage;
        setHealthPoints(hp); 
    }
}
