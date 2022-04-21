package main.java.dungeon;

public class FireRealm implements State{

    Dungeon dungeon;
    
    public FireRealm(Dungeon dungeon) {
        this.dungeon = dungeon;
    }
    
    @Override
    public void changeRealm(Dungeon dungeon) {
        dungeon.setRealm(dungeon.getGoldRealm());
        
    }

    @Override
    public int calculateDamage(int floor) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public String toString() {
        return "Fire Realm";
    }

}
