package main.java;

import java.util.Random;

public abstract class ConcreteCharacter implements Character {
    protected String name;
    private int strength;
    private int defense;
    private int speed;
    private int accuracy;
    private double luck;
    private int level;
    
    private CharacterType character = null;
    
    public ConcreteCharacter(CharacterType character) {
        this.character = character;
    }
    
    public abstract void construct();
    
    public abstract int strike();
    
    public abstract void getWeapon();

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

    public void setLevel(int level) {
        this.level = level;
    }
}
