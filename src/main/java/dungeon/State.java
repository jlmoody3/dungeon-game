package main.java.dungeon;

public interface State {

    void changeRealm(Dungeon dungeon);
    int calculateDamage(int floor);
    String chooseEnemy(int enemy);
    public int calculateTotalHP(int floor);
    public void setEnemyHP(int hp);
    public int getEnemyHP();
}
