package sample.menu.game.view;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import sample.menu.game.model.WorldModel;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class World implements Initializable {

    @FXML
    private TabPane listOfCities;

    private WorldModel worldModel;
    private List<City> cityList;
    private Task progressTask;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        worldModel = new WorldModel();
        cityList = new ArrayList<>();

        addCity("Chernobyl", 1);
        addCity("Delhi", 2);
        addCity("Warsaw", 4);
        addCity("London", 8);
        addCity("New York", 16);

        progressTask = new Task<Integer>() {
            @Override
            protected Integer call() throws Exception {
                int value = 0;
                while (!isCancelled()) {
                    value++;
                    worldModel.actualizeTime();
                    worldModel.actualizeFounds();
                    updateMessage("day " + value / (24 * 60 * 60) + " - "
                            + (value % (24 * 60 * 60)) / (60 * 60) + ":"
                            + (value % (24 * 60 * 60)) % (60 * 60) / 60 + ":"
                            + (value % (24 * 60 * 60)) % (60 * 60) % 60);
                    Thread.sleep(1000); //one second
                }
                return value;
            }
        };
    }

    private void addCity(String cityName, int cityLifeCostLvl) {
//        CityModel cityModel = new CityModel(cityName, cityLifeCostLvl);
//        cityList.add(cityModel); //TODO Jak to połączyć? World z City???
        City city = new City(this);
        cityList.add(city);

        try {
            Tab tab = new Tab();
            tab.setText(cityName);
            tab.setClosable(false);
            tab.setContent(FXMLLoader.load(this.getClass().getResource("city.fxml")));
            listOfCities.getTabs().add(tab);
            city = tab.;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
