package sample.menu.game.model;

public class RoomModel {

    private double roomIncomePerSec;
    private int roomBuyCost;

    public RoomModel(int floor) {
        roomIncomePerSec = 0;
        this.roomBuyCost = 10000 * (1 + 2 * floor);
    }

}
