package main.java.dungeon;

public class CandyRealm implements State{

    Dungeon dungeon;
    
    public CandyRealm(Dungeon dungeon) {
        this.dungeon = dungeon;
    }
    
    @Override
    public void changeRealm(Dungeon dungeon) {
        dungeon.setRealm(dungeon.getSlimeRealm());
        
    }

    @Override
    public int calculateDamage(int floor) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String toString() {
        return "Candy Realm";
    }
}