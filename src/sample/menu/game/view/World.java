package sample.menu.game.view;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import sample.menu.game.model.WorldModel;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class World implements Initializable {

    public Label timer;
    public Label founds;
    public Label worldIncome;
    @FXML
    private TabPane citiesViewList;

    private Task timeMeasurement;
    private WorldModel worldModel;
    private List<City> cityList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        worldModel = new WorldModel(10240);
        cityList = new ArrayList<>();

        worldIncome.setText("World income:\t" + worldModel.getWorldIncomePerSec() + " $/s");

        addCity("Chernobyl", 1);
        addCity("Delhi", 2);
        addCity("Warsaw", 4);
        addCity("London", 8);
        addCity("New York", 16);

        timeMeasurement = new Task<Integer>() {
            @Override
            protected Integer call() throws Exception {
                int value = 0;
                while (true) {
                    value++;
                    worldModel.actualizeTime();
                    worldModel.actualizeFounds();
                    updateTitle("Founds:\t" + worldModel.getFounds() + " $");
                    updateMessage("day " + showTime(value));
                    Thread.sleep(1000); //one second
                } //TODO ADD LOOP END
//                return value;
            }
        };

        founds.textProperty().bind(timeMeasurement.titleProperty());
        timer.textProperty().bind(timeMeasurement.messageProperty());

        Thread thread = new Thread(timeMeasurement);
        thread.setDaemon(true);
        thread.start();
    }

    private String showTime(int value) {
        return (value / (24 * 60 * 60) > 0 ? value / (24 * 60 * 60) : 0)
                + " - "
                + ((value % (24 * 60 * 60)) / (60 * 60) >= 10
                ? (value % (24 * 60 * 60)) / (60 * 60) : "0" + (value % (24 * 60 * 60)) / (60 * 60))
                + ":"
                + ((value % (24 * 60 * 60)) % (60 * 60) / 60 >= 10
                ? (value % (24 * 60 * 60)) % (60 * 60) / 60 : "0" + (value % (24 * 60 * 60)) % (60 * 60) / 60)
                + ":"
                + ((value % (24 * 60 * 60)) % (60 * 60) % 60 >= 10
                ? (value % (24 * 60 * 60)) % (60 * 60) % 60 : "0" + (value % (24 * 60 * 60)) % (60 * 60) % 60);
    }

    private void
    addCity(String cityName, int cityLifeCostLvl) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("city.fxml"));
            City city = new City(cityName, cityLifeCostLvl, this);
            loader.setController(city);

            Tab tab = new Tab();
            tab.setContent(loader.load());
            tab.setText(cityName);
            tab.setClosable(false);

            citiesViewList.getTabs().add(tab);

            cityList.add(city);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    double outFounds() {
        return worldModel.getFounds();
    }

    void charge(int charge) {
        worldModel.setFounds(worldModel.getFounds() - charge);
    }

    void actualizeIncome(double employeeIncomePerSec) {
        worldModel.actualizeIncome(employeeIncomePerSec);
        worldIncome.setText("World income:\t" + worldModel.getWorldIncomePerSec() + " $/s");
    }
}
