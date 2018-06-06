package sample.menu.game.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Room implements Initializable {

    @FXML
    private Label roomIncome;
    @FXML
    private HBox listOfEmployees;
    @FXML
    private Button buyButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buyButton.setVisible(true);
        roomIncome.setVisible(false);
    }

    @FXML
    public void buyRoom() {
        buyButton.setVisible(false);
        roomIncome.setVisible(true);
        for (int i = 0; i < 6; i++) {
            try {
                GridPane employee = new GridPane();
                employee.add(FXMLLoader.load(this.getClass().getResource("employee.fxml")), 0, 0);
                listOfEmployees.getChildren().add(employee);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
