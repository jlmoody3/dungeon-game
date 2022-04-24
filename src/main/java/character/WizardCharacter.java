package main.java.character;

import java.util.Random;

public class WizardCharacter extends ConcreteCharacter {
    public WizardCharacter() {
        super(CharacterType.WIZARD);
        this.setStrength(13);
        this.setDefense(10);
        this.setSpeed(15);
        this.setAccuracy(11);
        this.setLuck(0.07);
        this.setHealthPoints(100);
        
        construct();
    }
    
    public void construct() {
        System.out.println("Congratulations! You are a wizard.");
    }

    @Override
    public int strike(int level) {
        Random random = new Random();
        
        return random.nextInt(level * 20) + level * 5;
    }

    @Override
    public void getWeapon() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void takeDamage(int damage) {
        int hp = getHealthPoints();
        hp = hp - damage;
        setHealthPoints(hp); 
    }
}
