package sample.menu.game.model;

public class RoomModel {

    private double roomIncomePerSec;
    private int floor;
    private int roomBuyCost;

    public RoomModel(int floor, int cityLifeCostLvl) {
        roomIncomePerSec = 0;
        this.floor = floor;
        this.roomBuyCost = 1000 * (1 + 2 * floor) * (2 + cityLifeCostLvl * cityLifeCostLvl / 2);
    }

    public int getRoomBuyCost() {
        return roomBuyCost;
    }

    public double getRoomIncomePerSec() {
        return roomIncomePerSec;
    }

    public int getFloor() {
        return floor;
    }

    public void actualizeIncome(double employeeIncomePerSec) {
        roomIncomePerSec += employeeIncomePerSec;
    }
}
