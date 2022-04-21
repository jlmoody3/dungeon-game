package main.java;

public class ElfCharacter extends ConcreteCharacter {
    public ElfCharacter() {
        super(CharacterType.ELF);
        this.setStrength(13);
        this.setDefense(10);
        this.setSpeed(15);
        this.setAccuracy(11);
        this.setLuck(0.07);
        this.setLevel(1);
    
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
        return 0;
    }
}
