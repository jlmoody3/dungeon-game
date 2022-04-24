package main.java;

import java.util.Random;

import main.java.character.CharacterFactory;
import main.java.character.CharacterType;
import main.java.character.ConcreteCharacter;
import main.java.dungeon.Dungeon;
import main.java.weapon.*;

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
            System.out.println("You have entered the " + dungeon.getRealm().toString() + ".");
            
            for (int i = 0; i < dungeon.getNumFloors()/dungeon.getNumRealms(); i++) {
                System.out.println("You are on floor " + floor +".");
                System.out.println("You have " + char1.getHealthPoints() + " HP.");
                System.out.println("You have " + char1.getExpPoints() + " XP.");
                // set enemy health points
                int totalEnemyHP = dungeon.getRealm().calculateTotalHP(floor);
                dungeon.getRealm().chooseEnemy();
                dungeon.getRealm().setEnemyHP(totalEnemyHP);
                System.out.println("It has " + totalEnemyHP + " HP.");
                
                // battle sequence
                while (dungeon.getRealm().getEnemyHP() > 0 && char1.getHealthPoints() > 0) {
                    System.out.println("It strikes!");
                    int damage = dungeon.getRealm().calculateDamage(floor);
                    char1.takeDamage(damage);
                    System.out.println("It dealt " + damage + " damage.");          
                    System.out.println("You have " + char1.getHealthPoints() + " HP left.");
                    if (char1.getHealthPoints() > 0) {
                        int damageToEnemy = char1.strike(char1.getLevel());
                        System.out.println("You strike!");
                        dungeon.getRealm().setEnemyHP(dungeon.getRealm().getEnemyHP() - damageToEnemy);
                        System.out.println("You dealt " + damageToEnemy + " damage.");          
                        System.out.println("It has " + dungeon.getRealm().getEnemyHP() + " HP left.");
                    }
                }
                if(dungeon.getRealm().getEnemyHP() <= 0) {
                    int level1, level2;
                    level1 = char1.getLevel();
                    char1.setExpPoints(char1.getExpPoints() + totalEnemyHP);
                    level2 = char1.getLevel();
                    if (level2 > level1) {
                        char1.levelUp();
                        System.out.println("You leveled up!");
                        System.out.println("You are now at level " + level2 + ".");
                        System.out.println("You have " + char1.getHealthPoints() + " HP!");
                    }
                }
                
                if (char1.getHealthPoints() > 0) {
                    floor++;
                    dungeon.setFloor(floor);
                }
                else {
                    System.out.println("You lose.");
                    floor = dungeon.getNumFloors() + 1;
                }
            }
            if (char1.getHealthPoints() > 0) {
                dungeon.getRealm().changeRealm(dungeon);
            }
        } 
    }
}
