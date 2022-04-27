package main.java.dungeon;

import java.util.Random;

public class CandyRealm implements State {

    private Dungeon dungeon;
    private int enemyHP;

    public CandyRealm(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    @Override
    public void changeRealm(Dungeon dungeon) {
        dungeon.setRealm(dungeon.getSlimeRealm());
    }

    /**
     * Method that calculates the damage inflicted by enemies.
     * Fulfills requirement that enemies get harder with each level.
     */
    @Override
    public int calculateDamage(int floor) {
        Random random = new Random();
        if (floor % 10 == 0) {
            return random.nextInt(10) + floor + 10;
        } else {
            return random.nextInt(5) + floor + 5;
        }
    }

    @Override
    public String toString() {
        return "Candy Realm";
    }

    /**
     * Method that chooses which enemy will fight.
     */
    @Override
    public String chooseEnemy(int enemy) {
        // Appears on 10th floor
        if (dungeon.getFloor() % 5 == 0) {
            return ("The Psychic Gobstopper appeared!");
        } else {
            switch(enemy) {
            case 0:
                return ("A candy blob appeared!");
            case 1:
                return ("A candy goblin appeared!");
            case 2:
                return ("A candy robot appeared!");
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
        int totalHP = floor * 2 + 10;
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
