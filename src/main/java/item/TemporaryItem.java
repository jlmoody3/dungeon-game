package main.java.item;

import java.util.Random;

import main.java.character.Character;
import main.java.character.ConcreteCharacter;
import main.java.weapon.Bow;
import main.java.weapon.Club;
import main.java.weapon.Sceptre;
import main.java.weapon.Sword;
import main.java.weapon.Wand;
import main.java.weapon.Weapon;

public class TemporaryItem extends Item {

    static final int NUM_ITEMS = 5;
    private Character character;
    
    public TemporaryItem(Character character) {
        this.character = character;
    }
    
    @Override
    public void construct() {

    }

    @Override
    public int strike(ConcreteCharacter character) {
        return 0;
    }

    @Override
    public void getItem(ConcreteCharacter character, Item item) {
        Random random = new Random();
        int chance = random.nextInt(NUM_ITEMS) + 1;

        switch(chance) {
        case 1:
            item = new HealingPotion(character);
            System.out.println("You found Healing Potion!");
            break;
        case 2:
            item = new SleepingPotion(character);
            System.out.println("You found Sleeping Potion!");
            break;
        case 3:
            item = new ObscuringPotion(character);
            System.out.println("You found Obscuring Potion!");
            break;
        case 4:
            item = new ParalyzingPotion(character);
            System.out.println("You found Paralyzing Potion!");
            break;
        case 5:
            item = new WeakeningPotion(character);
            System.out.println("You found Weakening Potion!");
            break;
        default:
            break;
        }
        character.getTemporaryItems().add((TemporaryItem) item);
    }

    @Override
    public int addEffects(Character character) {
        return 0;
    }

}
