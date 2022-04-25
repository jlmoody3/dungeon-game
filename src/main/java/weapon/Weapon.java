package main.java.weapon;

import main.java.character.Character;

public abstract class Weapon implements Character {
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

    public abstract int strike(int level);

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
