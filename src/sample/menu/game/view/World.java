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

    private static int SECONDS_IN_DAY = 24 * 60 * 60;
    private static int SECONDS_IN_HOUR = 24 * 60 * 60;
    private static int SECONDS_IN_MINUTE = 24 * 60 * 60;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        worldModel = new WorldModel(10240);
        cityList = new ArrayList<>();

        worldIncome.setText("World income:\t" + worldModel.getWorldIncomePerSec() + " $/s");

        addCities();

        timeMeasurement = createTimer();

        createBinds();

        Thread thread = new Thread(timeMeasurement);
        //thread.setDaemon(true);
        thread.start();
    }

    private void addCities() {
        addCity("Chernobyl", 1);
        addCity("Delhi", 2);
        addCity("Warsaw", 4);
        addCity("London", 8);
        addCity("New York", 16);
    }

    private void addCity(String cityName, int cityLifeCostLvl) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("city.fxml"));
            City city = new City(cityName, cityLifeCostLvl, this);
            loader.setController(city);

            Tab tab = createCityTab(cityName, loader);

            citiesViewList.getTabs().add(tab);

            cityList.add(city);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Tab createCityTab(String cityName, FXMLLoader loader) throws IOException {
        Tab tab = new Tab();
        tab.setContent(loader.load());
        tab.setText(cityName);
        tab.setClosable(false);
        return tab;
    }

    private Task<Integer> createTimer() {
        return new Task<Integer>() {
            @Override
            protected Integer call() throws Exception {
                int value = 0;
                while (value < SECONDS_IN_DAY) {
                    value++;
                    updateData();
                    updateBinds(value);
                    Thread.sleep(1000); //one second
                }
                return value;
            }

            private void updateData() {
                worldModel.actualizeTime();
                worldModel.actualizeFounds();
            }

            private void updateBinds(int value) {
                updateTitle("Founds:\t" + worldModel.getFounds() + " $");
                updateMessage("day " + showTime(value));
            }
        };
    }

    private String showTime(int value) {
        return (countDays(value) > 0 ? countDays(value) : 0) +
                " - " +
                (countHours(value) >= 10 ? countHours(value) : "0" + countHours(value)) +
                ":" +
                (countMinutes(value) >= 10 ? countMinutes(value) : "0" + countMinutes(value)) +
                ":" +
                (countMinuteModulo(value) >= 10 ? countMinuteModulo(value) : "0" + countMinuteModulo(value));
    }

    private int countDays(int value) {
        return value / (SECONDS_IN_DAY);
    }

    private int countDayModulo(int value) {
        return value % (SECONDS_IN_DAY);
    }

    private int countHours(int value) {
        return countDayModulo(value) / (SECONDS_IN_HOUR);
    }

    private int countHourModulo(int value) {
        return (countDayModulo(value)) % (SECONDS_IN_HOUR);
    }

    private int countMinutes(int value) {
        return countHourModulo(value) / SECONDS_IN_MINUTE;
    }

    private int countMinuteModulo(int value) {
        return countHourModulo(value) % SECONDS_IN_MINUTE;
    }

    private void createBinds() {
        founds.textProperty().bind(timeMeasurement.titleProperty());
        timer.textProperty().bind(timeMeasurement.messageProperty());
    }

    double getFounds() {
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
