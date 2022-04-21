package main.java.dungeon;

public class MudRealm implements State{

    Dungeon dungeon;
    
    public MudRealm(Dungeon dungeon) {
        this.dungeon = dungeon;
    }
    
    @Override
    public void changeRealm(Dungeon dungeon) {
        dungeon.setRealm(dungeon.getCandyRealm());        
    }

    @Override
    public int calculateDamage(int floor) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String toString() {
        return "Mud Realm";
    }
}
