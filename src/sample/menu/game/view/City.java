package sample.menu.game.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
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
                FXMLLoader loader = new FXMLLoader(getClass().getResource("room.fxml"));
                Room room = new Room();
                loader.setController(room);
                Pane pane = loader.load();
                listOfRooms.getChildren().add(pane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
