package sample.menu.game.model;

public class EmployeeModel {

    private double employeeIncomePerSec;
    private int employeeHireCost;

    public EmployeeModel(int empNo) {
        employeeIncomePerSec = 0;
        employeeHireCost = empNo < 3 ? 2000 : empNo * 1000;
        employeeIncomePerSec = Math.round(((double)
                (employeeHireCost / 100 / 4 * 3 + (int) (Math.random() * employeeHireCost / 50))) * 100) / 100;
    }

    public int getEmployeeHireCost() {
        return employeeHireCost;
    }

    public double getEmployeeIncomePerSec() {
        return employeeIncomePerSec;
    }
}
