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

    private World world;
    private Room room;
    private EmployeeModel employeeModel;

    Employee(World world, Room room, int empNo, int cityLifeCostLvl) {
        this.world = world;
        this.room = room;
        employeeModel = new EmployeeModel(empNo, room.getFloor(), cityLifeCostLvl);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hireButton.setVisible(true);
        hireButton.setText("employment\ncost:\n" + employeeModel.getEmployeeHireCost() + " $");

        employeeButton.setVisible(false);
    }

    @FXML
    public void hireEmployee() {
        if (world.getFounds() >= employeeModel.getEmployeeHireCost()) {
            world.charge(employeeModel.getEmployeeHireCost());
            hireButton.setVisible(false);

            employeeButton.setVisible(true);
            employeeButton.setText("Employee\n+" + employeeModel.getEmployeeIncomePerSec());

            room.actualizeIncome(employeeModel.getEmployeeIncomePerSec());
        } else {
            System.out.println("EMPLOYEE - YOU NEED MORE MONEY"); //TODO UPGRADE
        }
    }

    @FXML
    public void showEmployeeInfo() {
        System.out.println("I'm working!!!");   //TODO UPGRADE
    }
}
