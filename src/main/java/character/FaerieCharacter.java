package main.java.character;

import java.util.Random;

public class FaerieCharacter extends ConcreteCharacter {

    /**
     * Constructor for FaerieCharacter class. Sets initial stats.
     */
    public FaerieCharacter() {
        super(CharacterType.FAERIE);
        this.setInitialStrength(5);
        this.setStrength(getInitialStrength());
        this.setDefense(40);
        this.setSpeed(20);
        this.setAccuracy(25);
        this.setLuck(13);
        this.setHealthPoints(100);

        construct();
    }

    public void construct() {
        System.out.println("Congratulations! You are a faerie.");
    }

    @Override
    public int strike(ConcreteCharacter character) {
        return getStrength();
    }

    @Override
    public void specialSkill() {
        Random random = new Random();
        int chance = random.nextInt(5);
        int hp;
        if (chance == 1 && getHealthPoints() < getTotalHP()) {
            hp = getHealthPoints() + (int) (getTotalHP() * 0.2);
            if (hp < getTotalHP()) {
                setHealthPoints(hp);
            } else {
                setHealthPoints(getTotalHP());
            }
            System.out.println("You healed yourself! You now have " + getHealthPoints() + " HP!");
        }
    }
}
