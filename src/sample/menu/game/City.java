package sample.menu.game;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class City implements Initializable {

    @FXML
    private Label cityIncome;
    @FXML
    private VBox listOfRooms;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < 5; i++) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Room.fxml"));
            Room controller = new Room();
            loader.setController(controller);

            Pane pane;
            try {
                pane = loader.load();
                listOfRooms.getChildren().add(pane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
