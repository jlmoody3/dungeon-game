package main.java;

public class FaerieCharacter extends Character {
    public FaerieCharacter() {
        super(CharacterType.FAERIE);
            this.setStrength(13);
            this.setDefense(10);
            this.setSpeed(15);
            this.setAccuracy(11);
            this.setLuck(0.07);
        
        construct();
    }
    
    protected void construct() {
        System.out.println("Congratulations! You are a faerie.");
    }
}
