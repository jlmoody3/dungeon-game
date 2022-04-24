package main.java.dungeon;

import java.util.Random;

public class FireRealm implements State{

    Dungeon dungeon;
    int enemyHP;
    
    public FireRealm(Dungeon dungeon) {
        this.dungeon = dungeon;
    }
    
    @Override
    public void changeRealm(Dungeon dungeon) {
        dungeon.setRealm(dungeon.getGoldRealm());
        
    }

    @Override
    public int calculateDamage(int floor) {
        Random random = new Random();
        if (floor % 10 == 0) {
            return random.nextInt(floor) + 20;
        }
        else if (floor % 5 == 0) {
            return random.nextInt(floor) + 15;
        }
        else {
            return random.nextInt(floor) + 10;
        }
    }
    
    @Override
    public String toString() {
        return "Fire Realm";
    }

    @Override
    public void chooseEnemy() {
        Random random = new Random();
        int enemy = 0;
        enemy = random.nextInt(3) + 1;
        
        switch(enemy) {
        case 1:
            System.out.println("A fire blob appeared!");
            break;
        case 2:
            System.out.println("A lava monster appeared!");
            break;
        case 3:
            System.out.println("A flaming skull appeared!");
            break;
        }
        
    }
    
    public int calculateTotalHP(int floor) {
        int totalHP = floor * 3 + 10;
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
