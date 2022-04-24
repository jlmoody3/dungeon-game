package main.java.dungeon;

import java.util.Random;

public class CandyRealm implements State{

    Dungeon dungeon;
    int enemyHP;
    
    public CandyRealm(Dungeon dungeon) {
        this.dungeon = dungeon;
    }
    
    @Override
    public void changeRealm(Dungeon dungeon) {
        dungeon.setRealm(dungeon.getSlimeRealm());
        
    }

    @Override
    public int calculateDamage(int floor) {
        Random random = new Random();
        if (floor % 10 == 0) {
            return random.nextInt(floor) + 10;
        }
        else {
            return random.nextInt(floor) + 5;
        }

    }

    @Override
    public String toString() {
        return "Candy Realm";
    }

    @Override
    public void chooseEnemy() {
        Random random = new Random();
        int enemy = 0;
        enemy = random.nextInt(3) + 1;
        
        switch(enemy) {
        case 1:
            System.out.println("A candy blob appeared!");
            break;
        case 2:
            System.out.println("A candy goblin appeared!");
            break;
        case 3:
            System.out.println("A candy robot appeared!");
            break;
        }
        
    }
    
    public int calculateTotalHP(int floor) {
        int totalHP = floor * 2 + 10;
        return totalHP;
    }
    
    public void setEnemyHP(int hp) {
        if (hp <= 0) {
            enemyHP = 0;
        }
        else {
            enemyHP = hp;
        }
    }
    
    public int getEnemyHP() {
        return enemyHP;
    }
}
