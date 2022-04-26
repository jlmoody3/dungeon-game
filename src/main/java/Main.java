package main.java;

import java.util.ArrayList;
import java.util.Random;

import main.java.character.CharacterFactory;
import main.java.character.CharacterType;
import main.java.character.ConcreteCharacter;
import main.java.dungeon.Dungeon;
import main.java.item.HealingPotion;
import main.java.item.ObscuringPotion;
import main.java.item.ParalyzingPotion;
import main.java.item.PermanentItem;
import main.java.item.SleepingPotion;
import main.java.item.TemporaryItem;
import main.java.item.WeakeningPotion;
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
        System.out.println("You have entered the dungeon.");
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
                Random rand = new Random();
                int chance = 0;
                int turns = 0;
                int damageToEnemy = 0;
                ArrayList<TemporaryItem> tempItems;
                int potionChoice = 0;
                // choose who strikes first
                boolean first = char1.strikeFirst();
                while (dungeon.getRealm().getEnemyHP() > 0 && char1.getHealthPoints() > 0) {
                    // check to see if you will miss
                    boolean fail = char1.strikeFail();
                    if (first) {
                        if (char1.getHealthPoints() > 0) {
                            if (char1.getTemporaryItems().size() == 0) {
                                chance = rand.nextInt(5) + 1;
                            } else {
                                chance = rand.nextInt(7) + 1;
                            }
                            if (chance == 1) {
                                char1.specialSkill();
                                if (characterSelection == 2) {
                                    System.out.println("You used swift!");
                                    Random r = new Random();
                                    if (r.nextInt(2) == 0) {
                                        System.out.println("You shot 2 arrows!");
                                        damageToEnemy = newWeapon.strike(char1) * 2;
                                    } else {
                                        System.out.println("You shot 3 arrows!");
                                        damageToEnemy = newWeapon.strike(char1) * 3;
                                    }
                                    dungeon.getRealm().setEnemyHP(dungeon.getRealm().getEnemyHP() - damageToEnemy);
                                    System.out.println("You dealt " + damageToEnemy + " damage.");
                                    System.out.println("It has " + dungeon.getRealm().getEnemyHP() + " HP left.");
                                } else if (characterSelection == 1) {
                                    System.out.println("You used pound!");
                                    damageToEnemy = newWeapon.strike(char1) + char1.getLevel() * 5;
                                    dungeon.getRealm().setEnemyHP(dungeon.getRealm().getEnemyHP() - damageToEnemy);
                                    System.out.println("You dealt " + damageToEnemy + " damage.");
                                    System.out.println("It has " + dungeon.getRealm().getEnemyHP() + " HP left.");
                                }
                                first = false;
                            } else if (chance <= 5) {
                                // choose weapon
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
                                damageToEnemy = newWeapon.strike(char1);
                                if (!fail) {
                                    if (char1.criticalStrike()) {
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
                            } else {
                                tempItems = char1.getTemporaryItems();
                                if (tempItems.get(0).getClass() == HealingPotion.class) {
                                    potionChoice = 1;
                                    System.out.println("You use your Healing Potion!");
                                    if (char1.getHealthPoints() == char1.getTotalHP()) {
                                        System.out.println("You're already at full health!");
                                    } else {
                                        char1.heal();
                                    }
                                } else if (tempItems.get(0).getClass() == SleepingPotion.class) {
                                    potionChoice = 2;
                                    System.out.println("You use your Sleeping Potion!");
                                    turns = 1;
                                } else if (tempItems.get(0).getClass() == ObscuringPotion.class) {
                                    potionChoice = 3;
                                    System.out.println("You use your Obscuring Potion!");
                                } else if (tempItems.get(0).getClass() == ParalyzingPotion.class) {
                                    potionChoice = 4;
                                    System.out.println("You use your Paralyzing Potion!");
                                    turns = 3;
                                } else if (tempItems.get(0).getClass() == WeakeningPotion.class) {
                                    potionChoice = 5;
                                    System.out.println("You use your Weakening Potion!");
                                }
                                tempItems.remove(0);
                            }
                            first = false;
                        }
                    } else {
                        if (potionChoice <= 1) {
                            System.out.println("It strikes!");
                            int damage = dungeon.getRealm().calculateDamage(floor);
                            System.out.println("It dealt " + damage + " damage.");
                            damage = char1.takeDamage(damage);
                            System.out.println("You took " + damage + " damage.");
                            System.out.println("You have " + char1.getHealthPoints() + " HP left.");
                        }
                        if (potionChoice == 2) {
                            if (turns == 2) {
                                System.out.println("It fell asleep!");
                            }
                            if (turns < 1) {
                                System.out.println("It woke up!");
                                potionChoice = 0;
                            }
                            turns--;
                        }
                        if (potionChoice == 3) {
                            System.out.println("It strikes!");
                            System.out.println("It missed!");
                            potionChoice = 0;
                        }
                        if (potionChoice == 4) {
                            System.out.println("It's paralyzed! It can't move!");
                            if (turns < 1) {
                                potionChoice = 0;
                            }
                            turns--;
                        }
                        if (potionChoice == 5) {
                            System.out.println("It's weakened!");
                            System.out.println("It strikes!");
                            int damage = dungeon.getRealm().calculateDamage(floor) / 2;
                            System.out.println("It dealt " + damage + " damage.");
                            damage = char1.takeDamage(damage);
                            System.out.println("You took " + damage + " damage.");
                            System.out.println("You have " + char1.getHealthPoints() + " HP left.");
                            potionChoice = 0;
                        }
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

                if (char1.getHealthPoints() > 15) {
                    if (char1.findTreasure() && floor != dungeon.getNumFloors()) {
                        System.out.println("You found a treasure chest!");
                        PermanentItem item = new PermanentItem(char1);
                        TemporaryItem potion = new TemporaryItem(char1);
                        char1.getTreasure(newWeapon, item, potion);
                    }
                    floor++;
                    dungeon.setFloor(floor);
                } else {
                    break;
                }
            }
            if (char1.getHealthPoints() <= 15 && floor != dungeon.getNumFloors()) {
                floor = 0;
                dungeon = new Dungeon();
                char1.setHealthPoints(char1.getTotalHP());
                System.out.println("Your health points are low. You will be sent back to floor 1.");
            } else if (char1.getHealthPoints() <= 0) {
                System.out.println("You lose.");
                floor = dungeon.getNumFloors() + 1;
            } else {
                dungeon.getRealm().changeRealm(dungeon);
            }
        }
    }
}
