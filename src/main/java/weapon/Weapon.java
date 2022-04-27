package main.java.weapon;

import java.util.ArrayList;
import java.util.Random;

import main.java.character.Character;
import main.java.character.ConcreteCharacter;

public abstract class Weapon implements Character {
    static final int NUM_WEAPONS = 5;
    private Character character;
    private int damage;

    /**
     * Constructor for the Weapon class.
     * @param character
     */
    public Weapon(Character character) {
        this.character = character;
    }

    public abstract void construct();

    public abstract int strike(ConcreteCharacter character);

    public void getWeapon(int chance, ConcreteCharacter c) {
        Weapon newWeapon = null;

        switch(chance) {
        case 0:
            newWeapon = new Sword(this);
            System.out.println("You found a Sword!");
            break;
        case 1:
            newWeapon = new Bow(this);
            System.out.println("You found a Bow!");
            break;
        case 2:
            newWeapon = new Club(this);
            System.out.println("You found a Club!");
            break;
        case 3:
            newWeapon = new Wand(this);
            System.out.println("You found a Wand!");
            break;
        case 4:
            newWeapon = new Sceptre(this);
            System.out.println("You found a Sceptre!");
            break;
        default:
            break;
        }
        boolean hasWeapon = false;
        boolean dropWeapon = false;
        for (int i = 0; i < c.getWeapons().size(); i++) {
            if (c.getWeapons().get(i).getClass().equals(newWeapon.getClass())) {
                System.out.println("You already have a " + newWeapon.toString() + ".");
                hasWeapon = true;
            } else if (newWeapon.getDamage() < c.getWeapons().get(i).getDamage()) {
                dropWeapon = true;
            }
        }
        if (dropWeapon) {
            System.out.println("You decide not to take the " + newWeapon.toString() + ".");
        }
        if (!hasWeapon && !dropWeapon) {
            c.getWeapons().add(newWeapon);
        }
    }

    /**
     * Method that decides which weapon you will use.
     * @param c - concrete character
     * @return weapon that will be used
     */
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
    
    public int getNumWeapons() {
        return NUM_WEAPONS;
    }
}
