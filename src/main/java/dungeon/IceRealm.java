package main.java.dungeon;

import java.util.Random;

public class IceRealm implements State{

    Dungeon dungeon;
    int enemyHP;
    
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
            return random.nextInt(floor) + 10;
        }
        else if (floor % 5 == 0) {
            return random.nextInt(floor) + 5;
        }
        return floor;
    }

    @Override
    public String toString() {
        return "Ice Realm";
    }

    @Override
    public void chooseEnemy() {
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
        }
        
    }
    
    public int calculateTotalHP(int floor) {
        int totalHP = floor * 2 + 10;
        return totalHP;
    }
    
    public void setEnemyHP(int hp) {
        enemyHP = hp;
    }
    
    public int getEnemyHP() {
        return enemyHP;
    }
}

