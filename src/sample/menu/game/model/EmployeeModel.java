package sample.menu.game.model;

public class EmployeeModel {

    private double employeeIncomePerSec;
    private int employeeHireCost;

    public EmployeeModel(int empNo) {
        employeeIncomePerSec = 0;
        employeeHireCost = empNo < 3 ? 2000 : empNo * 1000;
    }

    public int getEmployeeHireCost() {
        return employeeHireCost;
    }
}
