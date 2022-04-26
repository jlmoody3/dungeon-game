package main.java.character;

import java.util.Random;

public class WizardCharacter extends ConcreteCharacter {
    static final int LOW_STRENGTH = 5;
    static final int HIGH_STRENGTH = 20;

    /**
     * Constructor for WizardCharacter class. Sets initial stats.
     */
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
    public int strike(ConcreteCharacter character) {
        Random random = new Random();
        
        return random.nextInt(getLevel() * HIGH_STRENGTH) + getLevel() * LOW_STRENGTH;
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
