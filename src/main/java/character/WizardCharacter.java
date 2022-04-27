package main.java.character;

import java.util.Random;

import main.java.item.PermanentItem;
import main.java.item.TemporaryItem;
import main.java.weapon.Weapon;

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
        System.out.println("Critical Strike: " + getCriticalStrike());
    }

    public int getLowStrength() {
        return getLevel() * LOW_STRENGTH;
    }

    public int getHighStrength() {
        return getLevel() * HIGH_STRENGTH;
    }

    @Override
    public int addEffects(Character character) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void specialSkill() {
        System.out.println("You used conjure!");
        System.out.println("You found treasure!");
        Weapon weapon = getWeapons().get(0);
        PermanentItem item = new PermanentItem(this);
        TemporaryItem potion = new TemporaryItem(this);
        int chance = findRandom(5);
        getTreasure(chance, weapon, item, potion);
    }
}
