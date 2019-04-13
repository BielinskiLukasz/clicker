package menu.game.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import menu.game.model.EmployeeModel;

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
        hireButton.setText("employment\ncost:\n" + employeeModel.getEmployeeHireCost() + " $");

        setEmployeeHiredVisible(false);
    }

    private void setEmployeeHiredVisible(boolean hired) {
        hireButton.setVisible(!hired);
        employeeButton.setVisible(hired);
    }

    @FXML
    public void hireEmployee() {
        if (world.getFounds() >= employeeModel.getEmployeeHireCost()) {
            world.charge(employeeModel.getEmployeeHireCost());
            setEmployeeHiredVisible(true);
            employeeButton.setText("Employee\n+" + employeeModel.getEmployeeIncomePerSec());

            room.actualizeIncome(employeeModel.getEmployeeIncomePerSec());
        } else {
            showMessage("EMPLOYEE - YOU NEED MORE MONEY"); //TODO UPGRADE
        }
    }

    private void showMessage(String message) {
        System.out.println(message);
    }

    @FXML
    public void showEmployeeInfo() {
        showMessage("I'm working!!!");   //TODO UPGRADE
    }
}
