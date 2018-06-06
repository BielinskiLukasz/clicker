package sample.menu.game;

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
        try {
            Tab tab = new Tab();
            tab.setText("city 1");
            tab.setClosable(false);
            listOfCities.getTabs().add(tab);
            tab.setContent(FXMLLoader.load(this.getClass().getResource("city.fxml")));

            Tab tab2 = new Tab();
            tab2.setText("city 2");
            listOfCities.getTabs().add(tab2);
            tab2.setContent(FXMLLoader.load(this.getClass().getResource("city.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
