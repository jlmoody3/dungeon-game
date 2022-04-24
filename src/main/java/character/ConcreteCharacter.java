package main.java.character;

import java.util.Random;

public abstract class ConcreteCharacter implements Character {
    protected String name;
    private int strength;
    private int defense;
    private int speed;
    private int accuracy;
    private double luck;
    private int level;
    private int healthPoints;
    private int expPoints;
    private int totalHP;
    
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
    
    public abstract void takeDamage(int damage);

    public void levelUp() {
        setTotalHP((int)(getTotalHP() * 1.20));
        setHealthPoints(getTotalHP());
    }
    
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
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
    
    public double getLuck() {
        return luck;
    }

    public void setLuck(double luck) {
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
}
