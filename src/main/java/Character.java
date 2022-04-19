package main.java;

import java.util.Random;

public abstract class Character {
    protected String name;
    private int strength;
    private int defense;
    private int speed;
    private int accuracy;
    private double luck;
    
    private CharacterType character = null;
    
    public Character(CharacterType character) {
        this.character = character;
    }
    
    protected abstract void construct();
    
    public int attackEnemy() {
        Random random = new Random();

        int damageDealt = 0;
        
        return damageDealt;
    }

    public int takeHit() {
        Random random = new Random();

        int damageDealt = random.nextInt(15);
        int damageTaken = 0;
      
        return damageTaken;
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
}
