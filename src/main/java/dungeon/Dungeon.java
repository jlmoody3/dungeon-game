package main.java.dungeon;

public class Dungeon {

    final int NUMFLOORS = 12;
    final int NUMREALMS = 6;
    private State currentRealm;
    private State mudRealm;
    private State candyRealm;
    private State slimeRealm;
    private State iceRealm;
    private State fireRealm;
    private State goldRealm;
    private int floor;
    
    public Dungeon() {
        this.mudRealm = new MudRealm(this);
        this.candyRealm = new CandyRealm(this);
        this.slimeRealm = new SlimeRealm(this);
        this.iceRealm = new IceRealm(this);
        this.fireRealm = new FireRealm(this);
        this.goldRealm = new GoldRealm(this);
        this.currentRealm = mudRealm;
        this.floor = 1;
        System.out.println("You have entered the dungeon.");
    }
    
    public void updateRealm() {
        currentRealm.changeRealm(this);
    }
    
    public void setRealm(State realm) {
        currentRealm = realm;
    }
    
    public State getRealm() {
        return currentRealm;
    }
    
    public void setMudRealm(State realm) {
        mudRealm = realm;
    }
    
    public State getMudRealm() {
        return mudRealm;
    }
    
    public void setCandyRealm(State realm) {
        candyRealm = realm;
    }
    
    public State getCandyRealm() {
        return candyRealm;
    }
    
    public void setSlimeRealm(State realm) {
        slimeRealm = realm;
    }
    
    public State getSlimeRealm() {
        return slimeRealm;
    }
    
    public void setIceRealm(State realm) {
        iceRealm = realm;
    }
    
    public State getIceRealm() {
        return iceRealm;
    }
    
    public void setFireRealm(State realm) {
        fireRealm = realm;
    }
    
    public State getFireRealm() {
        return fireRealm;
    }
    
    public void setGoldRealm(State realm) {
        goldRealm = realm;
    }
    
    public State getGoldRealm() {
        return goldRealm;
    }
    
    public void setFloor(int floor) {
        this.floor = floor;
    }
    
    public int getFloor() {
        return floor;
    }
    
    public int getNumFloors() {
        return NUMFLOORS;
    }
    
    public int getNumRealms() {
        return NUMREALMS;
    }
}
