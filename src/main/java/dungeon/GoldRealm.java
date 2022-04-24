package main.java.dungeon;

import java.util.Random;

public class GoldRealm implements State{

    Dungeon dungeon;
    
    public GoldRealm(Dungeon dungeon) {
        this.dungeon = dungeon;
    }
    
    @Override
    public void changeRealm(Dungeon dungeon) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int calculateDamage(int floor) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String toString() {
        return "Gold Realm";
    }

    @Override
    public void chooseEnemy() {
        // TODO Auto-generated method stub
        
    }
}
