package main.java.character;

public class CharacterFactory {

    /**
     * Method that builds the characters. Implements Factory pattern.
     * @param character
     * @return built character
     */
    public static ConcreteCharacter buildCharacter(CharacterType character) {
        ConcreteCharacter char1 = null;

        switch (character) {
        case ELF:
            char1 = new ElfCharacter();
            break;

        case ORC:
            char1 = new OrcCharacter();
            break;

        case HUMAN:
            char1 = new HumanCharacter();
            break;

        case WIZARD:
            char1 = new WizardCharacter();
            break;

        case FAERIE:
            char1 = new FaerieCharacter();
            break;

        default:
            break;
        }
        return char1;
    }
}
