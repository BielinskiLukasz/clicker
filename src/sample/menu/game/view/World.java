package sample.menu.game.view;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class World implements Initializable {

    //TODO REBUILD PROJECTT LIKE PROCEK69

    @FXML
    private TabPane listOfCities;

    private Task progressTask;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("city.fxml"));
            City city = new City();
            loader.setController(city);

            Tab tab = new Tab();
            tab.setContent(loader.load());
            tab.setText(cityName);
            tab.setClosable(false);

            listOfCities.getTabs().add(tab);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
