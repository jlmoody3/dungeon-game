package main.java.dungeon;

import java.util.Random;

public class SlimeRealm implements State{

    Dungeon dungeon;
    
    public SlimeRealm(Dungeon dungeon) {
        this.dungeon = dungeon;
    }
    
    @Override
    public void changeRealm(Dungeon dungeon) {
        dungeon.setRealm(dungeon.getIceRealm());
        
    }

    @Override
    public int calculateDamage(int floor) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String toString() {
        return "Slime Realm";
    }

    @Override
    public void chooseEnemy() {
        // TODO Auto-generated method stub
        
    }
}
