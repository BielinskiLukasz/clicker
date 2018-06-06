package sample.menu.game.model;

public class WorldModel {

    private double founds;
    private double worldIncomePerSec;
    private int timeSec;

    public WorldModel() {
        founds = 1;
        worldIncomePerSec = 0;
        timeSec = 0;
    }

    public void actualizeTime() {
        timeSec++;
    }

    public void actualizeFounds() {
        founds += worldIncomePerSec;
    }
}
