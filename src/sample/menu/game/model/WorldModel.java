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

    public void actualizeTime() {
        timeSec++;
    }

    public void actualizeFounds() {
        founds += worldIncomePerSec;
    }

    public void actualizeIncome(double employeeIncomePerSec) {
        worldIncomePerSec += employeeIncomePerSec;
    }

    public double getFounds() {
        return founds;
    }

    public void setFounds(double founds) {
        this.founds = founds;
    }

    public double getWorldIncomePerSec() {
        return worldIncomePerSec;
    }
}
