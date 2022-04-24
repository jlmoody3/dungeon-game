package main.java.character;

import java.util.Random;

public class FaerieCharacter extends ConcreteCharacter {
    public FaerieCharacter() {
        super(CharacterType.FAERIE);
        this.setStrength(13);
        this.setDefense(10);
        this.setSpeed(15);
        this.setAccuracy(11);
        this.setLuck(0.07);
        this.setHealthPoints(100);
        
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
        Random random = new Random();
        int chance = random.nextInt(5);
        int hp;
        if (chance == 1 && getHealthPoints() < getTotalHP()) {
            hp = getHealthPoints() + (int)(getTotalHP() * 0.2);
            if (hp < getTotalHP()) {
                setHealthPoints(hp);
            }
            else {
                setHealthPoints(getTotalHP());
            }
            System.out.println("You healed yourself! You now have " + getHealthPoints() + " HP!");
        }
        return level * 5;
    }

    @Override
    public void takeDamage(int damage) {
        int hp = getHealthPoints();
        hp = hp - damage;
        setHealthPoints(hp); 
    }
}
