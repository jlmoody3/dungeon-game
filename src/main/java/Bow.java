package main.java;

public class Bow extends Weapon {
    static final int STARTING_DAMAGE = 7;
    
    public Bow() {
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