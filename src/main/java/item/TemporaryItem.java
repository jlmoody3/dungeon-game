package main.java.item;

import main.java.character.Character;
import main.java.character.ConcreteCharacter;

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

    /**
     * Method that chooses which temporary item you will find in the treasure chest.
     * Fulfills requirement that simulation must include at least 3 temporary
     * status effects.
     */
    @Override
    public void getItem(int chance, ConcreteCharacter character, Item item) {
        switch(chance) {
        case 0:
            item = new HealingPotion(character);
            System.out.println("You found Healing Potion!");
            break;
        case 1:
            item = new SleepingPotion(character);
            System.out.println("You found Sleeping Potion!");
            break;
        case 2:
            item = new ObscuringPotion(character);
            System.out.println("You found Obscuring Potion!");
            break;
        case 3:
            item = new ParalyzingPotion(character);
            System.out.println("You found Paralyzing Potion!");
            break;
        case 4:
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

    public Character getCharacter() {
        return character;
    }

    public int getNumItems() {
        return NUM_ITEMS;
    }

}
