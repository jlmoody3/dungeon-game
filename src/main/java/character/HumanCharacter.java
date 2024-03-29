package main.java.character;

public class HumanCharacter extends ConcreteCharacter {

    /**
     * Constructor for HumanCharacter class. Sets initial stats.
     */
    public HumanCharacter() {
        super(CharacterType.HUMAN);
        this.setInitialStrength(10);
        this.setStrength(getInitialStrength());
        this.setDefense(10);
        this.setSpeed(30);
        this.setAccuracy(20);
        this.setLuck(15);
        this.setHealthPoints(100);

        construct();
    }

    public void construct() {
        System.out.println("Congratulations! You are a human.");
    }

    @Override
    public int strike(ConcreteCharacter character) {
        return getStrength();
    }

    @Override
    public int addEffects(Character character) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void specialSkill() {
        System.out.println("You used learn!");
        int expPoints = 10 * getLevel();
        setExpPoints(getExpPoints() + expPoints);
        System.out.println("Your XP increased by " + expPoints + " points!");
    }
}
