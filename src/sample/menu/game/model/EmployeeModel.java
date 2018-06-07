package sample.menu.game.model;

public class EmployeeModel {

    private double employeeIncomePerSec;
    private int employeeHireCost;

    public EmployeeModel(int empNo, int floor, int cityLifeCostLvl) {
        employeeIncomePerSec = 0;
        employeeHireCost = (floor + empNo < 6 ? 2000 * cityLifeCostLvl : empNo * 500 * (1 + floor)) * cityLifeCostLvl;
        employeeIncomePerSec = Math.round(((double)
                (employeeHireCost / 100 / 4 * 3 + (int) (Math.random() * employeeHireCost / 200))) * 100) / 100;
    }

    public int getEmployeeHireCost() {
        return employeeHireCost;
    }

    public double getEmployeeIncomePerSec() {
        return employeeIncomePerSec;
    }
}
