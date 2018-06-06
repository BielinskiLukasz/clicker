package sample.menu.game.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import sample.menu.game.model.EmployeeModel;

import java.net.URL;
import java.util.ResourceBundle;

public class Employee implements Initializable {

    @FXML
    private Button hireButton;
    @FXML
    private Button employeeButton;

    private Room room;
    private EmployeeModel employeeModel;

    Employee(Room room, int empNo) {
        this.room = room;
        employeeModel = new EmployeeModel(empNo);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hireButton.setVisible(true);
        employeeButton.setVisible(false);
    }

    @FXML
    public void hireEmployee() {
        hireButton.setVisible(false);
        employeeButton.setVisible(true);
    }

    @FXML
    public void showEmployeeInfo() {
        System.out.println("I'm working!!!");   //TODO only tests :)
    }
}
