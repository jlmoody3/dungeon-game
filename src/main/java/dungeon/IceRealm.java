package main.java.dungeon;

import java.util.Random;

public class IceRealm implements State{

    Dungeon dungeon;
    
    public IceRealm(Dungeon dungeon) {
        this.dungeon = dungeon;
    }
    
    @Override
    public void changeRealm(Dungeon dungeon) {
        dungeon.setRealm(dungeon.getFireRealm());
        
    }

    @Override
    public int calculateDamage(int floor) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String toString() {
        return "Ice Realm";
    }

    @Override
    public void chooseEnemy() {
        // TODO Auto-generated method stub
        
    }
}

