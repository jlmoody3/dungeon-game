package main.java.weapon;

import java.util.Random;

import main.java.character.CharacterFactory;
import main.java.character.CharacterType;
import main.java.character.ConcreteCharacter;
import main.java.dungeon.Dungeon;

/**
 * Main class for Dungeon Warrior
 * @author jessm
 * @version 1.0
 */
public class Main {

    /**
     * This main method starts Dungeon Warrior
     * @param args - no arguments
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Dungeon Warrior!");
        
        Random random = new Random();
        int characterSelection = random.nextInt(5) + 1;
        ConcreteCharacter char1 = null;
        
        switch(characterSelection) {
        case 1:
            char1 = CharacterFactory.buildCharacter(CharacterType.ORC);
            break;
        case 2:
            char1 = CharacterFactory.buildCharacter(CharacterType.ELF);
            break;
        case 3:
            char1 = CharacterFactory.buildCharacter(CharacterType.HUMAN);
            break;
        case 4:
            char1 = CharacterFactory.buildCharacter(CharacterType.WIZARD);
            break;
        case 5:
            char1 = CharacterFactory.buildCharacter(CharacterType.FAERIE);
            break;
        }
        
        Weapon newWeapon = null;
        
        switch(characterSelection) {
        case 1:
            newWeapon = new Club(char1);
            break;
        case 2:
            newWeapon = new Bow(char1);
            break;
        case 3:
            newWeapon = new Sword(char1);
            break;
        case 4:
            newWeapon = new Power(char1);
            break;
        case 5:
            newWeapon = new Wand(char1);
            break;
        }
        
        Dungeon dungeon = new Dungeon();
        int floor = 0;
        
        while(floor <= dungeon.getNumFloors()) {
            floor = dungeon.getFloor();
            System.out.println("You are on floor " + floor +".");
            System.out.println("You have entered the " + dungeon.getRealm().toString() + ".");
            dungeon.getRealm().chooseEnemy();
            int damage = dungeon.getRealm().calculateDamage(floor);
            System.out.println("It dealt " + damage + " damaage.");
            
            dungeon.getRealm().changeRealm(dungeon);
            floor++;
            dungeon.setFloor(floor);
        }
        
        
        
    }

}
