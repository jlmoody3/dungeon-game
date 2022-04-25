package main.java.character;

import java.util.Random;

public class WizardCharacter extends ConcreteCharacter {
    final int LOW_STRENGTH = 5;
    final int HIGH_STRENGTH = 20;
    
    private int lowStrength;
    private int highStrength;
    
    public WizardCharacter() {
        super(CharacterType.WIZARD);
        this.setInitialStrength(13);
        this.setStrength(getInitialStrength());
        this.setDefense(20);
        this.setSpeed(10);
        this.setAccuracy(40);
        this.setLuck(11);
        this.setHealthPoints(100);
        
        construct();
    }
    
    public void construct() {
        System.out.println("Congratulations! You are a wizard.");
    }

    @Override
    public int strike(int level) {
        Random random = new Random();
        
        return random.nextInt(level * HIGH_STRENGTH) + level * LOW_STRENGTH;
    }

    @Override
    public void getWeapon() {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void printStats() {
        System.out.println("Stats:");
        System.out.println("Strength: " + getLowStrength() + " - " + getHighStrength());
        System.out.println("Defense: " + getDefense());
        System.out.println("Speed: " + getSpeed());
        System.out.println("Accuracy: " + getAccuracy());
        System.out.println("Luck: " + getLuck());
    }
    
    public int getLowStrength() {
        return getLevel() * LOW_STRENGTH;
    }
    
    public int getHighStrength() {
        return getLevel() * HIGH_STRENGTH;
    }
}
