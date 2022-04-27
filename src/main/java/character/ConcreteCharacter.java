package main.java.character;

import java.util.ArrayList;
import java.util.Random;

import main.java.item.PermanentItem;
import main.java.item.TemporaryItem;
import main.java.weapon.Weapon;

/**
 * ConcreteCharacter class. Concrete class for Factory Design Pattern.
 * @author jessm
 *
 */
public abstract class ConcreteCharacter implements Character {
    static final int MAX_ACCURACY = 50;
    static final int MAX_SPEED = 50;
    static final int MAX_LUCK = 100;
    static final int MAX_CRITICAL_STRIKE = 100;

    // Fulfills requirement that character should have stats.
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

    private ArrayList<Weapon> weapons;
    //private ArrayList<PermanentItem> permanentItems;
    private ArrayList<TemporaryItem> temporaryItems;

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
        weapons = new ArrayList<Weapon>();
        temporaryItems = new ArrayList<TemporaryItem>();
    }

    public abstract void construct();

    public abstract int strike(ConcreteCharacter character);

    public abstract void specialSkill();

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
        setStrength(level * initialStrength);
    }

    /**
     * Method that determines whether the character will strike first
     * @return true if the character strikes first
     */
    public boolean strikeFirst(int chance) {
        if (chance <= speed) {
            return true;
        }
        return false;
    }

    /**
     * Method that determines whether the character will miss
     * @return true if the character misses
     */
    public boolean strikeFail(int chance) {
        if (chance <= accuracy) {
            return false;
        }
        return true;
    }

    /**
     * Method that determines if the character will find treasure.
     * @return true if the character finds treasure.
     */
    public boolean findTreasure(int chance) {
        if (chance <= luck) {
            return true;
        }
        return false;
    }

    /**
     * Method that determines if the character will critically strike
     * @return true if the character will critically strike
     */
    public boolean criticalStrike(int chance) {
        if (chance <= criticalStrike) {
            return true;
        }
        return false;
    }

    /**
     * Method that determines what type of treasure you will find.
     * @param newWeapon
     * @param item
     * @param potion
     */
    public void getTreasure(int chance, Weapon newWeapon, PermanentItem item, TemporaryItem potion) {
        int r;
        if (chance == 4) {
            r = findRandom(newWeapon.getNumWeapons());
            newWeapon.getWeapon(r, this);
        } else if (chance == 3) {
            r = findRandom(item.getNumItems());
            item.getItem(r, this, item);
        } else {
            r = findRandom(potion.getNumItems());
            potion.getItem(r, this, potion);
        }
    }

    /**
     * Method that allows characters to heal themselves by increasing HP by 20%
     * of their total health.
     */
    public void heal() {
        int hp;
        if (getHealthPoints() < getTotalHP()) {
            hp = getHealthPoints() + (int) (getTotalHP() * 0.2);
            if (hp < getTotalHP()) {
                setHealthPoints(hp);
            } else {
                setHealthPoints(getTotalHP());
            }
            System.out.println("You healed yourself! You now have " + getHealthPoints() + " HP!");
        }
    }

    /**
     * Method that generates a random number between 0 and a max value.
     * @param max
     * @return random number
     */
    public int findRandom(int max) {
        Random random = new Random();
        int chance = random.nextInt(max);
        return chance;
    }

    public int getStrength() {
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
        if (exp >= 5250) {
            level = 15;
        } else if (exp >= 4550) {
            level = 14;
        } else if (exp >= 3900) {
            level = 13;
        } else if (exp >= 3300) {
            level = 12;
        } else if (exp >= 2750) {
            level = 11;
        } else if (exp >= 2250) {
            level = 10;
        } else if (exp >= 1800) {
            level = 9;
        } else if (exp >= 1400) {
            level = 8;
        } else if (exp >= 1050) {
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

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapon weapon) {
        weapons.add(weapon);
    }

    public ArrayList<TemporaryItem> getTemporaryItems() {
        return temporaryItems;
    }

    public void setTemporaryItems(TemporaryItem temporaryItem) {
        temporaryItems.add(temporaryItem);
    }

    public CharacterType getCharacterType() {
        return character;
    }

    public int getMaxAccuracy() {
        return MAX_ACCURACY;
    }

    public int getMaxSpeed() {
        return MAX_SPEED;
    }

    public int getMaxLuck() {
        return MAX_LUCK;
    }

    public int getMaxCriticalStrike() {
        return MAX_CRITICAL_STRIKE;
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
        System.out.println("Critical Strike: " + getCriticalStrike());
    }
}
