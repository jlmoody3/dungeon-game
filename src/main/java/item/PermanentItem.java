package main.java.item;

import java.util.Random;

import main.java.character.Character;
import main.java.character.ConcreteCharacter;

/**
 * Superclass PermanentItem, subclass of Item. It and subclasses
 * implement Decorator pattern.
 * @author Jessica Moody
 *
 */
public class PermanentItem extends Item {

    static final int NUM_ITEMS = 6;
    private Character character;

    public PermanentItem(Character character) {
        this.character = character;
    }

    public void getItem(ConcreteCharacter character, Item item) {
        Random random = new Random();
        int choice = random.nextInt(NUM_ITEMS);
        switch (choice) {
        case 0:
            item = new Helmet(character);
            System.out.println("You found a helmet!");
            character.setCriticalStrike(character.getCriticalStrike() + item.addEffects(character));
            System.out.println("Your critical strike has increased!");
            break;
        case 1:
            item = new Shield(character);
            System.out.println("You found a shield!");
            character.setDefense(character.getDefense() + item.addEffects(character));
            System.out.println("Your defense has increased!");
            break;
        case 2:
            item = new Boots(character);
            System.out.println("You found boots!");
            character.setSpeed(character.getSpeed() + item.addEffects(character));
            System.out.println("Your speed has increased!");
            break;
        case 3:
            item = new Armor(character);
            System.out.println("You found armor!");
            character.setStrength(character.getStrength() + item.addEffects(character));
            System.out.println("Your strength has increased!");
            break;
        case 4:
            item = new Charm(character);
            System.out.println("You found a charm!");
            character.setLuck(character.getLuck() + item.addEffects(character));
            System.out.println("Your luck has increased!");
            break;
        case 5:
            item = new Glasses(character);
            System.out.println("You found glasses!");
            character.setAccuracy(character.getAccuracy() + item.addEffects(character));
            System.out.println("Your accuracy has increased!");
            break;
        default:
            break;
        }
        character.printStats();
    }

    @Override
    public void construct() {

    }

    @Override
    public int strike(ConcreteCharacter character) {

        return 0;
    }

    @Override
    public int addEffects(Character character) {

        return 0;
    }

    public Character getCharacter() {
        return character;
    }

}
