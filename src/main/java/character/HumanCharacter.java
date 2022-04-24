package main.java.character;

public class HumanCharacter extends ConcreteCharacter {
    public HumanCharacter() {
        super(CharacterType.HUMAN);
        this.setStrength(13);
        this.setDefense(10);
        this.setSpeed(15);
        this.setAccuracy(11);
        this.setLuck(0.07);
        this.setHealthPoints(100);
        
        construct();
    }
    
    public void construct() {
        System.out.println("Congratulations! You are a human.");
    }

    @Override
    public int strike(int level) {
        return level * 10;
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
