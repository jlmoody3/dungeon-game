package main.java.character;

public interface Character {

    void construct();
    int strike(ConcreteCharacter character);
    int addEffects(Character character);
}
