package main.java.weapon;

import main.java.item.Item;

import java.util.ArrayList;
import java.util.Random;

import main.java.character.Character;
import main.java.character.ConcreteCharacter;

public abstract class Weapon implements Character, Item {
    private Character character;
    private int damage;
    
    public Weapon(Character character) {
        this.character = character;
    }
    
    public abstract void construct();
    
    public abstract int strike(ConcreteCharacter character);
    
    public void addWeapon(Character character) {
        
    }
    
    public Weapon whichWeapon(ConcreteCharacter c) {
        ArrayList<Weapon> weapons = c.getWeapons();
        Random random = new Random();
        int chance = 0;
        if (weapons.size() == 1) {
            return weapons.get(0);
        } else if (weapons.size() == 2) {
            chance = random.nextInt(2);
            switch (chance) {
            case 0:
                return weapons.get(0);
            case 1:
                return weapons.get(1);
            default:
                break;
            }
        } else if (weapons.size() == 3) {
            chance = random.nextInt(3);
            switch (chance) {
            case 0:
                return weapons.get(0);
            case 1:
                return weapons.get(1);
            case 2:
                return weapons.get(2);
            default:
                break;
            }
        } else if (weapons.size() == 4) {
            chance = random.nextInt(4);
            switch (chance) {
            case 0:
                return weapons.get(0);
            case 1:
                return weapons.get(1);
            case 2:
                return weapons.get(2);
            case 3:
                return weapons.get(3);
            default:
                break;
            }
        } else if (weapons.size() == 5) {
            chance = random.nextInt(4);
            switch (chance) {
            case 0:
                return weapons.get(0);
            case 1:
                return weapons.get(1);
            case 2:
                return weapons.get(2);
            case 3:
                return weapons.get(3);
            case 4:
                return weapons.get(4);
            default:
                break;
            }
        }
        return weapons.get(0);
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
