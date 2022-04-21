package main.java;

public class Club extends Weapon {
    static final int STARTING_DAMAGE = 15;
    
    public Club() {
        super();
        this.setDamage(STARTING_DAMAGE);
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