package main.java.character;

import java.util.Random;

public abstract class ConcreteCharacter implements Character {
    static final int MAX_ACCURACY = 50;
    static final int MAX_SPEED = 50;
    static final int MAX_LUCK = 100;
    static final int MAX_CRITICAL_STRIKE = 100;

    private double strength;
    private int defense;
    private int speed;
    private int accuracy;
    private int luck;
    private int level;
    private int healthPoints;
    private int expPoints;
    private int totalHP;
    private double initialStrength;
    private int criticalStrike;

    private CharacterType character = null;

    /**
     * ConcreteCharacter constructor
     * @param character - the character to be created
     */
    public ConcreteCharacter(CharacterType character) {
        this.character = character;
        level = 1;
        expPoints = 0;
        totalHP = 100;
        criticalStrike = 5;
    }

    public abstract void construct();

    public abstract int strike(int level);

    public abstract void getWeapon();

    /**
     * Method that specifies how much damage the character will take
     * @param damage - damage inflicted by enemy
     * @return
     */
    public int takeDamage(int damage) {
        int hp = getHealthPoints();
        damage = damage - (int) (damage * getDefense() * 0.01);
        hp = hp - damage;
        setHealthPoints(hp);
        return damage;
    }

    /**
     * Method that increases stats when the character levels up
     */
    public void levelUp() {
        setTotalHP((int) (getTotalHP() * 1.20));
        setHealthPoints(getTotalHP());
        setDefense(getDefense() + 2);
        setSpeed(getSpeed() + 2);
        setAccuracy(getAccuracy() + 2);
        setLuck(getLuck() + 2);
        setCriticalStrike(getCriticalStrike() + 1);
    }

    /**
     * Method that determines whether the character will strike first
     * @return true if the character strikes first
     */
    public boolean strikeFirst() {
        Random random = new Random();
        int chance = random.nextInt(MAX_SPEED);
        if (chance <= speed) {
            return true;
        }
        return false;
    }

    /**
     * Method that determines whether the character will miss
     * @return true if the character misses
     */
    public boolean strikeFail() {
        Random random = new Random();
        int chance = random.nextInt(MAX_ACCURACY);
        if (chance <= accuracy) {
            return false;
        }
        return true;
    }

    /**
     * Method that determines if the character will find treasure.
     * @return true if the character finds treasure.
     */
    public boolean findTreasure() {
        Random random = new Random();
        int chance = random.nextInt(MAX_LUCK);
        if (chance <= luck) {
            return true;
        }
        return false;
    }

    public void specialSkill() {

    }

    /**
     * Method that determines if the character will critically strike
     * @return true if the character will critically strike
     */
    public boolean criticalStrike() {
        Random random = new Random();
        int chance = random.nextInt(MAX_CRITICAL_STRIKE);
        if (chance <= criticalStrike) {
            return true;
        }
        return false;
    }

    public int getStrength() {
        strength = level * initialStrength;
        return (int) strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel() {
        int exp = getExpPoints();
        if (exp >= 1050) {
            level = 7;
        } else if (exp >= 750) {
            level = 6;
        } else if (exp >= 500) {
            level = 5;
        } else if (exp >= 300) {
            level = 4;
        } else if (exp >= 150) {
            level = 3;
        } else if (exp >= 50) {
            level = 2;
        } else {
            level = 1;
        }
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        if (healthPoints <= 0) {
            this.healthPoints = 0;
        } else {
            this.healthPoints = healthPoints;
        }
    }

    public int getExpPoints() {
        return expPoints;
    }

    public void setExpPoints(int expPoints) {
        this.expPoints = expPoints;
        setLevel();
    }

    public int getTotalHP() {
        return totalHP;
    }

    public void setTotalHP(int totalHP) {
        this.totalHP = totalHP;
    }

    public double getInitialStrength() {
        return initialStrength;
    }

    public void setInitialStrength(double initialStrength) {
        this.initialStrength = initialStrength;
    }

    public int getCriticalStrike() {
        return criticalStrike;
    }

    public void setCriticalStrike(int criticalStrike) {
        this.criticalStrike = criticalStrike;
    }

    /**
     * Method that prints out the character's stats.
     */
    public void printStats() {
        System.out.println("Stats:");
        System.out.println("Strength: " + getStrength());
        System.out.println("Defense: " + getDefense());
        System.out.println("Speed: " + getSpeed());
        System.out.println("Accuracy: " + getAccuracy());
        System.out.println("Luck: " + getLuck());
    }
}
