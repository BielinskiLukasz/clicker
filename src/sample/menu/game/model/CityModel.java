package sample.menu.game.model;

public class CityModel {

    private String cityName;
    private int cityLifeCostLvl;
    private double cityIncomePerSec;
    private int viewCosts;

    public CityModel(String cityName, int cityLifeCostLvl) {
        this.cityName = cityName;
        cityIncomePerSec = 0;
        this.cityLifeCostLvl = cityLifeCostLvl;
        viewCosts = cityLifeCostLvl * 1000;
    }

    public int getViewCosts() {
        return viewCosts;
    }

    public int getCityLifeCostLvl() {
        return cityLifeCostLvl;
    }
}
