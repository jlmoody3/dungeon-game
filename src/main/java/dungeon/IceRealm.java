package main.java.dungeon;

import java.util.Random;

public class IceRealm implements State {

    private Dungeon dungeon;
    private int enemyhp;

    public IceRealm(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    @Override
    public void changeRealm(Dungeon dungeon) {
        dungeon.setRealm(dungeon.getFireRealm());
    }

    @Override
    public int calculateDamage(int floor) {
        Random random = new Random();
        if (floor % 10 == 0) {
            return random.nextInt(20) + (int) (floor * 3);
        } else if (floor % 5 == 0) {
            return random.nextInt(15) + (int) (floor * 2);
        } else {
            return random.nextInt(10) + (int) (floor * 1.5);
        }
    }

    @Override
    public String toString() {
        return "Ice Realm";
    }

    @Override
    public void chooseEnemy() {
        if (dungeon.getFloor() % 5 == 0) {
            System.out.println("The Ice Queen appeared!");
        } else {
            Random random = new Random();
            int enemy = 0;
            enemy = random.nextInt(3) + 1;

            switch(enemy) {
            case 1:
                System.out.println("An ice blob appeared!");
                break;
            case 2:
                System.out.println("A ghost appeared!");
                break;
            case 3:
                System.out.println("An angry yeti appeared!");
                break;
            default:
                break;
            }
        }
    }

    /**
     * Method that calculates the total HP of the enemies.
     */
    public int calculateTotalHP(int floor) {
        int totalHP = floor * 3 + 10;
        return totalHP;
    }

    public void setEnemyHP(int hp) {
        if (hp <= 0) {
            enemyhp = 0;
        } else {
            enemyhp = hp;
        }
    }

    public int getEnemyHP() {
        return enemyhp;
    }

    public void setDungeon(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    public Dungeon getDungeon() {
        return dungeon;
    }
}
