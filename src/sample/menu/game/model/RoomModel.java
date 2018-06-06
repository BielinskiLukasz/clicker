package sample.menu.game.model;

public class RoomModel {

    private double roomIncomePerSec;
    private int roomBuyCost;

    public RoomModel(int floor) {
        roomIncomePerSec = 0;
        this.roomBuyCost = 1000 * (1 + 2 * floor);
    }

    public int getRoomBuyCost() {
        return roomBuyCost;
    }
}
