package sample.menu.game.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import sample.menu.game.model.CityModel;
import sample.menu.game.model.RoomModel;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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

    private World world;
    private CityModel cityModel;
    private List<RoomModel> roomModelList;

    public City(World world) {
        this.world = world;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        world =;
//        cityModel =;
        roomModelList = new ArrayList<>();

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
