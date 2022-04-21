package main.java;

public class FaerieCharacter extends ConcreteCharacter {
    public FaerieCharacter() {
        super(CharacterType.FAERIE);
            this.setStrength(13);
            this.setDefense(10);
            this.setSpeed(15);
            this.setAccuracy(11);
            this.setLuck(0.07);
            this.setLevel(1);
        
        construct();
    }
    
    public void construct() {
        System.out.println("Congratulations! You are a faerie.");
    }

    @Override
    public void getWeapon() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int strike(int level) {
        // TODO Auto-generated method stub
        return 0;
    }
}