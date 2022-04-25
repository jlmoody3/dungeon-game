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

    @Override
    public int calculateDamage(int floor) {
        Random random = new Random();
        if (floor % 10 == 0) {
            return random.nextInt(20) + (int) (floor * 1.5);
        } else if (floor % 5 == 0) {
            return random.nextInt(15) + (int) (floor * 1.5);
        } else {
            return random.nextInt(10) + (int) (floor * 1.5);
        }
    }

    @Override
    public String toString() {
        return "Gold Realm";
    }

    @Override
    public void chooseEnemy() {
        Random random = new Random();
        int enemy = 0;
        enemy = random.nextInt(3) + 1;

        switch(enemy) {
        case 1:
            System.out.println("A gold blob appeared!");
            break;
        case 2:
            System.out.println("A gold serpent appeared!");
            break;
        case 3:
            System.out.println("A gold dragon appeared!");
            break;
        default:
            break;
        }
    }

    /**
     * Method that calculates the total HP of the enemies.
     */
    public int calculateTotalHP(int floor) {
        int totalHP = floor * 4 + 10;
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
