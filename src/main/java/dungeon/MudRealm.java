package main.java.dungeon;

import java.util.Random;

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
        return "Mud Realm";
    }

    @Override
    public void chooseEnemy() {
        Random random = new Random();
        int enemy = 0;
        enemy = random.nextInt(3) + 1;
        
        switch(enemy) {
        case 1:
            System.out.println("A mud blob attacked!");
        case 2:
            System.out.println("A cave spider attacked!");
        case 3:
            System.out.println("A sewer rat attacked!");
          
        }
            
        
        
    }
}
