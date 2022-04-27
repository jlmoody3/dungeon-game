package main.java.dungeon;

import java.util.Random;

public class MudRealm implements State {

    private Dungeon dungeon;
    private int enemyhp;

    public MudRealm(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    @Override
    public void changeRealm(Dungeon dungeon) {
        dungeon.setRealm(dungeon.getCandyRealm());
    }

    @Override
    public int calculateDamage(int floor) {
        Random random = new Random();
        if (floor % 10 == 0) {
            return random.nextInt(10) + floor;
        } else {
            return random.nextInt(5) + floor;
        }
    }

    @Override
    public String toString() {
        return "Mud Realm";
    }

    @Override
    public String chooseEnemy(int enemy) {
        if (dungeon.getFloor() % 5 == 0) {
            return ("The Mega Blob appeared!");
        } else {
            switch(enemy) {
            case 0:
                return ("A mud blob appeared!");
            case 1:
                return ("A cave spider appeared!");
            case 2:
                return ("A sewer rat appeared!");
            default:
                return "";
            }
        }
    }

    /**
     * Method that calculates the total HP of the enemies.
     */
    public int calculateTotalHP(int floor) {
        int totalHP = floor * 2 + 10;
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
