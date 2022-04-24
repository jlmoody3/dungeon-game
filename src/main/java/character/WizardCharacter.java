package main.java.character;

public class WizardCharacter extends ConcreteCharacter {
    public WizardCharacter() {
        super(CharacterType.WIZARD);
        this.setStrength(13);
        this.setDefense(10);
        this.setSpeed(15);
        this.setAccuracy(11);
        this.setLuck(0.07);
        this.setLevel(1);
        this.setHealthPoints(100);
        
        construct();
    }
    
    public void construct() {
        System.out.println("Congratulations! You are a wizard.");
    }

    @Override
    public int strike(int level) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void getWeapon() {
        // TODO Auto-generated method stub
        
    }
}
