package sample.menu.game.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import sample.menu.game.model.CityModel;

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
    private VBox roomsViewList;
    @FXML
    private Button visitButton;

    private World world;
    private CityModel cityModel;
    private List<Room> roomList;

    public City(String cityName, int cityLifeCostLvl, World world) {
        this.world = world;
        cityModel = new CityModel(cityName, cityLifeCostLvl);
        roomList = new ArrayList<>();
    }

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
                Room room = new Room(this, 5 - i);
                loader.setController(room);
                Pane pane = loader.load();

                roomsViewList.getChildren().add(pane);

                roomList.add(room);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
