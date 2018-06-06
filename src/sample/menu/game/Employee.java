package sample.menu.game;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Employee implements Initializable {

    @FXML
    private Button hireButton;
    @FXML
    private Button employeeButton;

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
