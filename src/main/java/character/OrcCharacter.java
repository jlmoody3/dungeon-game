package main.java.character;

public class OrcCharacter extends ConcreteCharacter{
    public OrcCharacter() {
        super(CharacterType.ORC);
        this.setInitialStrength(15);
        this.setStrength(getInitialStrength());
        this.setDefense(0);
        this.setSpeed(15);
        this.setAccuracy(35);
        this.setLuck(10);
        this.setHealthPoints(100);
        
        construct();
    }
    
    public void construct() {
        System.out.println("Congratulations! You are an orc.");
    }

    @Override
    public int strike(int level) {
        return level * getStrength();
    }

    @Override
    public void getWeapon() {
        // TODO Auto-generated method stub
        
    }

}
