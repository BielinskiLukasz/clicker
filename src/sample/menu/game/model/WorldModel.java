package sample.menu.game.model;

public class WorldModel {

    private double founds;
    private double worldIncomePerSec;
    private int timeSec;

    public WorldModel(int startFounds) {
        founds = startFounds;
        worldIncomePerSec = 0;
        timeSec = 0;
    }

    public double getFounds() {
        return founds;
    }

    public int getTimeSec() {
        return timeSec;
    }

    public void actualizeTime() {
        timeSec++;
    }

    public void actualizeFounds() {
        founds += worldIncomePerSec;
    }
}
