package sample.menu.game.model;

public class CityModel {

    private String cityName;
    private int cityLifeCostLvl;
    private double cityIncomePerSec;
    private int viewCosts;
    private int visibleRooms;

    public CityModel(String cityName, int cityLifeCostLvl) {
        this.cityName = cityName;
        cityIncomePerSec = 0;
        this.cityLifeCostLvl = cityLifeCostLvl;
        viewCosts = cityLifeCostLvl * 1024;
        visibleRooms = 1;
    }

    public void actualizeIncome(double employeeIncomePerSec) {
        cityIncomePerSec += employeeIncomePerSec;
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

    public int getVisibleRooms() {
        return visibleRooms;
    }

    public void setVisibleRooms(int visibleRooms) {
        this.visibleRooms = visibleRooms;
    }
}
