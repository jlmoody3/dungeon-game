package main.java;

public class OrcCharacter extends Character{
    public OrcCharacter() {
        super(CharacterType.ORC);
        this.setStrength(13);
        this.setDefense(10);
        this.setSpeed(15);
        this.setAccuracy(11);
        this.setLuck(0.07);
        
        construct();
    }
    
    protected void construct() {
        System.out.println("Congratulations! You are an orc.");
    }
}
