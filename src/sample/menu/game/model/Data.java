package sample.menu.game.model;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private WorldModel worldModel;
    private List<CityModel> cityModelList;
    private List<RoomModel> roomModelList;
    private List<EmployeeModel> employeeModelList;

    public Data() {
        worldModel = new WorldModel();
        cityModelList = new ArrayList<>();
        roomModelList = new ArrayList<>();
        employeeModelList = new ArrayList<>();


    }
}
