package sample.menu.game.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
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
    private Label cityIncome;
    @FXML
    private GridPane head;
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
        visitButton.setText("Cost of the visit: " + cityModel.getViewCosts() + " $");

        head.setVisible(false);

        cityIncome.setText("City income:\t" + cityModel.getCityIncomePerSec() + " $/s");
    }

    @FXML
    public void visitCity() {
        if (world.getFounds() >= cityModel.getViewCosts()) {
            world.charge(cityModel.getViewCosts());

            visitButton.setVisible(false);
            head.setVisible(true);

            for (int i = 0; i < 5; i++) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("room.fxml"));
                    Room room = new Room(world, this, 4 - i, cityModel.getCityLifeCostLvl());
                    loader.setController(room);
                    Pane pane = loader.load();

                    roomsViewList.getChildren().add(pane);

                    roomList.add(room);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            roomList.get(roomList.size() - 1).setAvailable();
        } else {
            System.out.println("CITY - YOU NEED MORE MONEY"); //TODO UPGRADE
        }
    }

    void actualizeIncome(double employeeIncomePerSec) {
        cityModel.actualizeIncome(employeeIncomePerSec);
        cityIncome.setText("City income:\t" + cityModel.getCityIncomePerSec() + " $/s");
        world.actualizeIncome(employeeIncomePerSec);
    }

    int getCityLifeCostLvl() {
        return cityModel.getCityLifeCostLvl();
    }

    void setNextRoomAvailable() {
        if (roomList.size() > cityModel.getVisibleRooms()) {
            roomList.get(roomList.size() - cityModel.getVisibleRooms() - 1).setAvailable();
            cityModel.setVisibleRooms(cityModel.getVisibleRooms() + 1);
        }
    }
}
