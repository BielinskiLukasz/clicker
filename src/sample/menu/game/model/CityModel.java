package sample.menu.game.model;

public class CityModel {

    private String cityName;
    private double cityIncomePerSec;
    private int viewCosts;

    public CityModel(String cityName, int cityLifeCostLvl) {
        this.cityName = cityName;
        cityIncomePerSec = 0;
        viewCosts = cityLifeCostLvl * 1000;
    }

    public int getViewCosts() {
        return viewCosts;
    }
}
