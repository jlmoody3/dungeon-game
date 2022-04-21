package main.java;

public class Power extends Weapon {
    static final int STARTING_DAMAGE = 10;
    
    public Power() {
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
