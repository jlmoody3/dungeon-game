package main.java.character;

import java.util.ArrayList;
import java.util.Random;

import main.java.item.PermanentItem;
import main.java.item.TemporaryItem;
import main.java.weapon.Bow;
import main.java.weapon.Club;
import main.java.weapon.Sceptre;
import main.java.weapon.Sword;
import main.java.weapon.Wand;
import main.java.weapon.Weapon;

public abstract class ConcreteCharacter implements Character {
    final int MAX_ACCURACY = 50;
    final int MAX_SPEED = 50;
    final int MAX_LUCK = 100;
    final int MAX_CRITICAL_STRIKE = 100;
    
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
    private ArrayList<PermanentItem> permanentItems;
    private ArrayList<TemporaryItem> temporaryItems;

    private CharacterType character = null;
    
    public ConcreteCharacter(CharacterType character) {
        this.character = character;
        level = 1;
        expPoints = 0;
        totalHP = 100;
        criticalStrike = 5;
    }
    
    public abstract void construct();
    
    public abstract int strike(int level);
    
    public void getWeapon() {
        Random random = new Random();
        int chance = random.nextInt(5) + 1;
        Weapon newWeapon = null;

        switch(chance) {
        case 1:
            newWeapon = new Sword(this);
            System.out.println("You found a Sword!");
            break;
        case 2:
            newWeapon = new Bow(this);
            System.out.println("You found a Bow!");
            break;
        case 3:
            newWeapon = new Club(this);
            System.out.println("You found a Club!");
            break;
        case 4:
            newWeapon = new Wand(this);
            System.out.println("You found a Wand!");
            break;
        case 5:
            newWeapon = new Sceptre(this);
            System.out.println("You found a Sceptre!");
            break;
        default:
            break;
        }
        boolean hasWeapon = false;
        boolean dropWeapon = false;
        for (int i = 0; i < getWeapons().size(); i++) {
            if(weapons.get(i).equals(newWeapon)) {
                System.out.println("You already have a " + newWeapon.toString() + ".");
                hasWeapon = true;
            } else if (newWeapon.getDamage() < weapons.get(i).getDamage()) {
                System.out.println("You decide not to take the" + newWeapon.toString() + ".");
                dropWeapon = true;
            }
        }
        if (!hasWeapon && !dropWeapon) {
            weapons.add(newWeapon);
        }
    }
    
    public int takeDamage(int damage) {
        int hp = getHealthPoints();
        damage = damage - (int)(damage * getDefense() * 0.01);
        hp = hp - damage;
        setHealthPoints(hp);
        return damage;
    }

    public void levelUp() {
        setTotalHP((int)(getTotalHP() * 1.20));
        setHealthPoints(getTotalHP());
        setDefense(getDefense() + 2);
        setSpeed(getSpeed() + 2);
        setAccuracy(getAccuracy() + 2);
        setLuck(getLuck() + 2);
        setCriticalStrike(getCriticalStrike() + 1);
    }
    
    public boolean strikeFirst() {
        Random random = new Random();
        int chance = random.nextInt(MAX_SPEED);
        if (chance <= speed) {
            return true;
        }
        return false;
    }
    
    public boolean strikeFail() {
        Random random = new Random();
        int chance = random.nextInt(MAX_ACCURACY);
        if (chance <= accuracy) {
            return false;
        }
        return true;
    }
    
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
    
    public boolean criticalStrike() {
        Random random = new Random();
        int chance = random.nextInt(MAX_CRITICAL_STRIKE);
        if (chance <= criticalStrike) {
            return true;
        }
        return false;
    }
    
    public void getTreasure() {
        Random random = new Random();
        int chance = random.nextInt(5);
        if (chance == 4) {
            getWeapon();
        } else if (chance == 3) {
            getItem(this);
        } else {
            getPotion();
        }
            
    }
    
    public int getStrength() {
        return (int)(level * initialStrength);
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
        }
        else if (exp >= 750) {
            level = 6;
        }
        else if (exp >= 500) {
            level = 5; 
        }
        else if (exp >= 300) {
            level = 4;
        }
        else if (exp >= 150) {
            level = 3;
        }
        else if (exp >= 50) {
            level = 2;
        }
        else {
            level = 1;
        }
    }
    
    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        if (healthPoints <= 0) {
            this.healthPoints = 0;
        }
        else {
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
    
    public void printStats() {
        System.out.println("Stats:");
        System.out.println("Strength: " + getStrength());
        System.out.println("Defense: " + getDefense());
        System.out.println("Speed: " + getSpeed());
        System.out.println("Accuracy: " + getAccuracy());
        System.out.println("Luck: " + getLuck());
    }
}
