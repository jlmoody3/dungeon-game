package main.java.weapon;

import main.java.item.Item;
import main.java.character.Character;

public abstract class Weapon implements Character, Item {
    private Character character;
    private int damage;
    
    public Weapon(Character character) {
        this.character = character;
    }
    
    public abstract void construct();
    
    public abstract int strike(int level);
    
    public void addWeapon(Character character) {
        
    }
    
    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    public int getDamage() {
        return damage;
    }
    
    public void setCharacter(Character character) {
        this.character = character;
    }
    
    public Character getCharacter() {
        return character;
    }
}
