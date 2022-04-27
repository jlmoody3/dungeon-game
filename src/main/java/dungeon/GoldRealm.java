package main.java.dungeon;

import java.util.Random;

public class GoldRealm implements State {

    private Dungeon dungeon;
    private int enemyHP;

    public GoldRealm(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    @Override
    public void changeRealm(Dungeon dungeon) {
        System.out.println("You win!");
    }

    /**
     * Method that calculates the damage inflicted by enemies.
     * Fulfills requirement that enemies get harder with each level.
     */
    @Override
    public int calculateDamage(int floor) {
        Random random = new Random();
        if (floor % 10 == 0) {
            return random.nextInt(20) + (int) (floor * 4);
        } else if (floor % 5 == 0) {
            return random.nextInt(15) + (int) (floor * 3);
        } else {
            return random.nextInt(10) + (int) (floor * 2);
        }
    }

    @Override
    public String toString() {
        return "Gold Realm";
    }

    /**
     * Method that chooses which enemy will fight.
     */
    @Override
    public String chooseEnemy(int enemy) {
        // Appears on 30th floor
        if (dungeon.getFloor() % 5 == 0) {
            return ("The Golden Gorgon appeared!");
        } else {
            switch(enemy) {
            case 0:
                return ("A gold blob appeared!");
            case 1:
                return ("A gold serpent appeared!");
            case 2:
                return ("A gold dragon appeared!");
            default:
                return "";
            }
        }
    }

    /**
     * Method that calculates the total HP of the enemies.
     * Fulfills requirement that enemies get harder with each level.
     */
    public int calculateTotalHP(int floor) {
        int totalHP = floor * 5 + 10;
        return totalHP;
    }

    public void setEnemyHP(int hp) {
        if (hp <= 0) {
            enemyHP = 0;
        } else {
            enemyHP = hp;
        }
    }

    public int getEnemyHP() {
        return enemyHP;
    }

    public void setDungeon(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    public Dungeon getDungeon() {
        return dungeon;
    }
}
