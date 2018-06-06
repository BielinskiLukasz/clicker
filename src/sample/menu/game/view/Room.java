package sample.menu.game.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import sample.menu.game.model.RoomModel;

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

    private City city;
    private RoomModel roomModel;
    private List<Employee> employeeList;

    Room(City city, int floor) {
        this.city = city;
        roomModel = new RoomModel(floor);
        employeeList = new ArrayList<>();
    }

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
                FXMLLoader loader = new FXMLLoader(getClass().getResource("employee.fxml"));
                Employee employee = new Employee(this, i);
                loader.setController(employee);
                Pane pane = loader.load();

                employeesViewList.getChildren().add(pane);

                employeeList.add(employee);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
