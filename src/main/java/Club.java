package main.java;

public class Club extends Weapon {
    static final int STARTING_DAMAGE = 15;
    
    public Club(Character character) {
        super(character);
        this.setDamage(STARTING_DAMAGE);
        System.out.println("You have a club.");
    }

    @Override
    public void construct() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int strike(int level) {
        // TODO Auto-generated method stub
        return 0;
    }

}