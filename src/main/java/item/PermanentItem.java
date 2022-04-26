package main.java.item;

import main.java.character.ConcreteCharacter;

import java.util.Random;

import main.java.character.Character;

public class PermanentItem extends Item {

    Character character;
    
    public PermanentItem(Character character) {
        this.character = character;
    }
    
    public void getItem(ConcreteCharacter character, Item item) {
        Random random = new Random();
        item = new Helmet(character);
        character.setCriticalStrike(character.getCriticalStrike() + item.addEffects(item));
    }

    @Override
    public void construct() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int strike(ConcreteCharacter character) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int addEffects(Character character) {
        // TODO Auto-generated method stub
        return 0;
    }

}
