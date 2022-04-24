package main.java.character;

public class OrcCharacter extends ConcreteCharacter{
    public OrcCharacter() {
        super(CharacterType.ORC);
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
        System.out.println("Congratulations! You are an orc.");
    }

    @Override
    public int strike(int level) {
        return level * 15;
    }

    @Override
    public void getWeapon() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void takeDamage(int damage) {
        int hp = getHealthPoints();
        hp = hp - damage;
        setHealthPoints(hp); 
    }
}
