package main.java.character;

import java.util.Random;

public abstract class ConcreteCharacter implements Character {
    protected String name;
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
    
    private CharacterType character = null;
    
    public ConcreteCharacter(CharacterType character) {
        this.character = character;
        level = 1;
        expPoints = 0;
        totalHP = 100;
    }
    
    public abstract void construct();
    
    public abstract int strike(int level);
    
    public abstract void getWeapon();
    
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
    
    public void printStats() {
        System.out.println("Stats:");
        System.out.println("Strength: " + getStrength());
        System.out.println("Defense: " + getDefense());
        System.out.println("Speed: " + getSpeed());
        System.out.println("Accuracy: " + getAccuracy());
        System.out.println("Luck: " + getLuck());
    }
}
