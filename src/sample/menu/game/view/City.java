package sample.menu.game.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class City implements Initializable {

    @FXML
    private Label worldIncome;
    @FXML
    private Label cityIncome;
    @FXML
    private Label timer;
    @FXML
    private VBox listOfRooms;
    @FXML
    private Button visitButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        visitButton.setVisible(true);
        cityIncome.setVisible(false);
        worldIncome.setVisible(false);
        timer.setVisible(false);
    }

    @FXML
    public void visitCity() {
        visitButton.setVisible(false);
        cityIncome.setVisible(true);
        worldIncome.setVisible(true);
        timer.setVisible(true);
        for (int i = 0; i < 5; i++) {
            try {
                GridPane room = new GridPane();
                room.add(FXMLLoader.load(this.getClass().getResource("room.fxml")), 0, 0);
                listOfRooms.getChildren().add(room);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
