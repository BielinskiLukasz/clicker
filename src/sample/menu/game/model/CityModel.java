package sample.menu.game.model;

public class CityModel {

    private String cityName;
    private int cityLifeCostLvl;
    private double cityIncomePerSec;
    private int viewCosts;
    private int visableRooms;

    public CityModel(String cityName, int cityLifeCostLvl) {
        this.cityName = cityName;
        cityIncomePerSec = 0;
        this.cityLifeCostLvl = cityLifeCostLvl;
        viewCosts = cityLifeCostLvl * 1000;
        visableRooms = 1;
    }

    public int getViewCosts() {
        return viewCosts;
    }

    public int getCityLifeCostLvl() {
        return cityLifeCostLvl;
    }

    public double getCityIncomePerSec() {
        return cityIncomePerSec;
    }

    public int getVisableRooms() {
        return visableRooms;
    }

    public void setVisableRooms(int visableRooms) {
        this.visableRooms = visableRooms;
    }

    public void actualizeIncome(double employeeIncomePerSec) {
        cityIncomePerSec += employeeIncomePerSec;
    }
}
