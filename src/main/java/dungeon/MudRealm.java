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
    public void chooseEnemy() {
        if (dungeon.getFloor() % 5 == 0) {
            System.out.println("The Mega Blob appeared!");
        } else {
            Random random = new Random();
            int enemy = 0;
            enemy = random.nextInt(3) + 1;

            switch(enemy) {
            case 1:
                System.out.println("A mud blob appeared!");
                break;
            case 2:
                System.out.println("A cave spider appeared!");
                break;
            case 3:
                System.out.println("A sewer rat appeared!");
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
