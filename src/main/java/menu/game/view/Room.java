package menu.game.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import menu.game.model.RoomModel;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Room implements Initializable {

    @FXML
    private Label roomIncome;
    @FXML
    private HBox employeesViewList;
    @FXML
    private Button buyButton;

    private World world;
    private City city;
    private RoomModel roomModel;
    private List<Employee> employeeList;

    Room(World world, City city, int floor, int cityLifeCostLvl) {
        this.world = world;
        this.city = city;
        roomModel = new RoomModel(floor, cityLifeCostLvl);
        employeeList = new ArrayList<>();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buyButton.setText("Cost of purchase: " + roomModel.getRoomBuyCost() + " $");
        roomIncome.setText("" + roomModel.getRoomIncomePerSec() + " $/s");
        setRoomVisible(false);
    }

    private void setRoomVisible(boolean b) {
        buyButton.setVisible(false);
        roomIncome.setVisible(b);
    }

    @FXML
    public void buyRoom() {
        if (world.getFounds() >= roomModel.getRoomBuyCost()) {
            world.charge(roomModel.getRoomBuyCost());
            setRoomVisible(true);
            addEmployeesToRoom();
            city.shareNextRoom();
        } else {
            showMessage("ROOM - YOU NEED MORE MONEY"); //TODO UPGRADE
        }
    }

    private void addEmployeesToRoom() {
        for (int i = 0; i < 6; i++) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("employee.fxml"));
                Employee employee = new Employee(world, this, i, city.getCityLifeCostLvl());
                loader.setController(employee);
                Pane pane = loader.load();

                employeesViewList.getChildren().add(pane);

                employeeList.add(employee);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showMessage(String message) {
        System.out.println(message);
    }

    int getFloor() {
        return roomModel.getFloor();
    }

    void setAvailable() {
        buyButton.setVisible(true);
    }

    void actualizeIncome(double employeeIncomePerSec) {
        roomModel.actualizeIncome(employeeIncomePerSec);
        roomIncome.setText("" + roomModel.getRoomIncomePerSec() + " $/s");
        city.actualizeIncome(employeeIncomePerSec);
    }
}