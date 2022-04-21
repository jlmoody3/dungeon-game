package main.java;

public class Sword extends Weapon {
    static final int STARTING_DAMAGE = 10;
    
    public Sword() {
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
