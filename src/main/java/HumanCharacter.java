package main.java;

public class HumanCharacter extends ConcreteCharacter {
    public HumanCharacter() {
        super(CharacterType.HUMAN);
        this.setStrength(13);
        this.setDefense(10);
        this.setSpeed(15);
        this.setAccuracy(11);
        this.setLuck(0.07);
        this.setLevel(1);
        
        construct();
    }
    
    public void construct() {
        System.out.println("Congratulations! You are a human.");
    }

    @Override
    public int strike() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void getWeapon() {
        // TODO Auto-generated method stub
        
    }
}
