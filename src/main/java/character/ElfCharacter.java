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
    public void getWeapon() {
        // TODO Auto-generated method stub
    }

    @Override
    public int strike(int level) {
        // TODO Auto-generated method stub
        return (int) (getStrength());
    }


}
