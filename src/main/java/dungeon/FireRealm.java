package main.java.dungeon;

import java.util.Random;

public class FireRealm implements State {

    private Dungeon dungeon;
    private int enemyhp;

    public FireRealm(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    @Override
    public void changeRealm(Dungeon dungeon) {
        dungeon.setRealm(dungeon.getGoldRealm());
    }

    /**
     * Method that calculates the damage inflicted by enemies.
     * Fulfills requirement that enemies get harder with each level.
     */
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
        return "Fire Realm";
    }

    /**
     * Method that chooses which enemy will fight.
     */
    @Override
    public String chooseEnemy(int enemy) {
        // Appears on 25th floor
        if (dungeon.getFloor() % 5 == 0) {
            return ("The Hellhound appeared!");
        } else {
            switch(enemy) {
            case 0:
                return ("A fire blob appeared!");
            case 1:
                return ("A lava monster appeared!");
            case 2:
                return ("A flaming skull appeared!");
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
        int totalHP = floor * 4 + 10;
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
