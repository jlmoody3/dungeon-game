package main.java;

import java.util.Random;

import main.java.character.CharacterFactory;
import main.java.character.CharacterType;
import main.java.character.ConcreteCharacter;
import main.java.dungeon.Dungeon;
import main.java.item.Item;
import main.java.item.PermanentItem;
import main.java.item.TemporaryItem;
import main.java.weapon.Bow;
import main.java.weapon.Club;
import main.java.weapon.Sceptre;
import main.java.weapon.Sword;
import main.java.weapon.Wand;
import main.java.weapon.Weapon;

/**
 * Main class for Dungeon Warrior
 * @author Jessica Moody
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
        //int characterSelection = 5;
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
        default:
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
            newWeapon = new Sceptre(char1);
            break;
        case 5:
            newWeapon = new Wand(char1);
            break;
        default:
            break;
        }
        
        char1.setWeapons(newWeapon);

        char1.printStats();

        Dungeon dungeon = new Dungeon();
        int floor = 0;

        while (floor <= dungeon.getNumFloors()) {
            floor = dungeon.getFloor();
            System.out.println("You have entered the " + dungeon.getRealm().toString() + ".");

            for (int i = 0; i < dungeon.getNumFloors() / dungeon.getNumRealms()
                    && floor <= dungeon.getNumFloors(); i++) {
                System.out.println("You are on floor " + floor + ".");
                System.out.println("You have " + char1.getHealthPoints() + " HP.");
                System.out.println("You have " + char1.getExpPoints() + " XP.");
                // set enemy health points
                int totalEnemyHP = dungeon.getRealm().calculateTotalHP(floor);
                dungeon.getRealm().chooseEnemy();
                dungeon.getRealm().setEnemyHP(totalEnemyHP);
                System.out.println("It has " + totalEnemyHP + " HP.");

                // battle sequence
                boolean first = char1.strikeFirst();
                while (dungeon.getRealm().getEnemyHP() > 0 && char1.getHealthPoints() > 0) {
                    boolean fail = char1.strikeFail();
                    if (first) {
                        if (char1.getHealthPoints() > 0) {
                            char1.specialSkill();
                            Weapon weapon = newWeapon.whichWeapon(char1);
                            if (weapon.getClass() == Sword.class) {
                                newWeapon = new Sword(newWeapon);
                                System.out.println("You swing your sword!");
                            } else if (weapon.getClass() == Bow.class) {
                                newWeapon = new Bow(newWeapon);
                                System.out.println("You fire your bow!");
                            } else if (weapon.getClass() == Club.class) {
                                newWeapon = new Club(newWeapon);
                                System.out.println("You swing your club!");
                            } else if (weapon.getClass() == Wand.class) {
                                newWeapon = new Wand(newWeapon);
                                System.out.println("You wave your wand!");
                            } else if (weapon.getClass() == Sceptre.class) {
                                newWeapon = new Sceptre(newWeapon);
                                System.out.println("You use your sceptre!");
                            }
                            int damageToEnemy = newWeapon.strike(char1);
                            //System.out.println("You strike!");
                            if (!fail) {
                                if(char1.criticalStrike()) {
                                    damageToEnemy = damageToEnemy + newWeapon.strike(char1);
                                    System.out.println("Critical strike!");
                                }
                                dungeon.getRealm().setEnemyHP(dungeon.getRealm().getEnemyHP() - damageToEnemy);
                                System.out.println("You dealt " + damageToEnemy + " damage.");
                                System.out.println("It has " + dungeon.getRealm().getEnemyHP() + " HP left.");
                            } else {
                                System.out.println("You missed!");
                            }
                            first = false;
                        }
                    } else {
                        System.out.println("It strikes!");
                        int damage = dungeon.getRealm().calculateDamage(floor);
                        System.out.println("It dealt " + damage + " damage.");
                        damage = char1.takeDamage(damage);
                        System.out.println("You took " + damage + " damage.");
                        System.out.println("You have " + char1.getHealthPoints() + " HP left.");
                        first = true;
                    }
                }

                if (dungeon.getRealm().getEnemyHP() <= 0 && floor != dungeon.getNumFloors()) {
                    int level1;
                    int level2;
                    level1 = char1.getLevel();
                    char1.setExpPoints(char1.getExpPoints() + totalEnemyHP);
                    level2 = char1.getLevel();
                    if (level2 > level1) {
                        char1.levelUp();
                        System.out.println("You leveled up!");
                        System.out.println("You are now at level " + level2 + ".");
                        System.out.println("You have " + char1.getHealthPoints() + " HP!");
                        char1.printStats();
                    }
                }

                if (char1.getHealthPoints() > 0) {
                    if (char1.findTreasure() && floor != dungeon.getNumFloors()) {
                        System.out.println("You found a treasure chest!");
                        PermanentItem item = new PermanentItem(char1);
                        TemporaryItem potion = new TemporaryItem(char1);
                        char1.getTreasure(newWeapon, item, potion);
                    }
                    floor++;
                    dungeon.setFloor(floor);
                } else {
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
