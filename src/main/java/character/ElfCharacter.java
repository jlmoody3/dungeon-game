package main.java.character;

public class ElfCharacter extends ConcreteCharacter {

    /**
     * Constructor for ElfCharacter class. Sets initial stats.
     */
    public ElfCharacter() {
        super(CharacterType.ELF);
        this.setInitialStrength(7.5);
        this.setStrength(getInitialStrength());
        this.setDefense(10);
        this.setSpeed(40);
        this.setAccuracy(30);
        this.setLuck(7);
        this.setHealthPoints(100);

        construct();
    }

    public void construct() {
        System.out.println("Congratulations! You are an elf.");
    }

    @Override
    public int strike(ConcreteCharacter character) {
        return (int) (getStrength());
    }

    @Override
    public int addEffects(Character character) {
        return 0;
    }

    @Override
    public void specialSkill() {
        // see main
    }


}
