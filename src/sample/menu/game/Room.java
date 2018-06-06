package sample.menu.game;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Room implements Initializable {

    @FXML
    private Label roomIncome;
    @FXML
    private HBox listOfEmployees;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < 6; i++) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Employee.fxml"));
            Employee controller = new Employee();
            loader.setController(controller);

            Pane pane;
            try {
                pane = loader.load();
                listOfEmployees.getChildren().add(pane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
