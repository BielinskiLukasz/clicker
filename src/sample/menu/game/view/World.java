package sample.menu.game.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class World implements Initializable {

    @FXML
    private TabPane listOfCities;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addCity("One");
        addCity("Two");
        addCity("Three");
        addCity("Four");
        addCity("Five");
    }

    private void addCity(String cityName) {
        try {
            Tab tab = new Tab();
            tab.setText(cityName);
            tab.setClosable(false);
            tab.setContent(FXMLLoader.load(this.getClass().getResource("city.fxml")));
            listOfCities.getTabs().add(tab);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
