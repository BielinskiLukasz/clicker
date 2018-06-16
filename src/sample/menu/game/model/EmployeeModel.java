package sample.menu.game.model;

public class EmployeeModel {

    private double employeeIncomePerSec;
    private int employeeHireCost;

    public EmployeeModel(int empNo, int floor, int cityLifeCostLvl) {
        employeeHireCost = (floor + empNo < 5) ? 1024 * cityLifeCostLvl : empNo * 512 * (1 + floor) * cityLifeCostLvl;
        employeeIncomePerSec = employeeHireCost * 3 / 5 / 100 + (int) (Math.random() * employeeHireCost * 4 / 5 / 100);
    }

    public int getEmployeeHireCost() {
        return employeeHireCost;
    }

    public double getEmployeeIncomePerSec() {
        return employeeIncomePerSec;
    }
}
