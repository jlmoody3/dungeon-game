package main.java.dungeon;

public interface State {

    void changeRealm(Dungeon dungeon);
    int calculateDamage(int floor);
}
