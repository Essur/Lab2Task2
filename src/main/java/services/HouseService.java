package services;

import factory.HouseFactory;
import houses.HighRiseHouse;
import houses.House;
import houses.HouseType;
import houses.PrivateHouse;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class HouseService {
    private final String SPLIT = "\n-----------------------------------------------\n";
    private List<PrivateHouse> privateHouses;
    private List<HighRiseHouse> highRiseHouses;
    private HouseFactory houseFactory;

    public HouseService() {
        this.privateHouses = new ArrayList<>();
        this.highRiseHouses = new ArrayList<>();
        this.houseFactory = new HouseFactory();
    }

    public void createHouse(int x){
        House house = null;
        if (x == 1) {
            house = houseFactory.crateHouse(HouseType.PRIVATE);
        } else if (x == 2) {
            house = houseFactory.crateHouse(HouseType.HIGHRISE);
        }
        addHouse(house);
    }

    public void addHouse(House house) {
        if (house instanceof PrivateHouse) {
            privateHouses.add((PrivateHouse) house);
        } else if (house instanceof HighRiseHouse) {
            highRiseHouses.add((HighRiseHouse) house);
        }
    }

    public void delete(){
        privateHouses.removeIf(privateHouse -> privateHouse.getSizeOfTerrain() < 6);
    }

    public int countOfResidents(String location){
        return privateHouses.stream().filter(privateHouse -> location.equals(privateHouse.getLocation())).mapToInt(PrivateHouse::getCountOfResidents).sum();
    }

    public int countOfRooms(String location){
        return highRiseHouses.stream().filter(highRiseHouse -> location.equals(highRiseHouse.getLocation()))
                .mapToInt(highRiseHouses -> highRiseHouses.getCountOfRoomsAtFloor() * highRiseHouses.getCountOfFloors()).sum();
    }

    public void printAll(){
            System.out.println("Private houses:");
            privateHouses.forEach(privateHouse -> System.out.println("Location: " + privateHouse.getLocation() + '\n' +
                    "Count of rooms: " + privateHouse.getCountOfRooms() + '\n' +
                    "Count of residents: " + privateHouse.getCountOfResidents() + '\n' +
                    "Size of terrain: " + privateHouse.getSizeOfTerrain() + SPLIT));
            System.out.println("High-Rise houses:");
            highRiseHouses.forEach(highRiseHouse -> System.out.println("Location: " + highRiseHouse.getLocation() + '\n' +
                    "Count of floors: " + highRiseHouse.getCountOfFloors() + '\n' +
                    "Count of rooms at floor: " + highRiseHouse.getCountOfRoomsAtFloor() + '\n' +
                    "Count of outbuildings: " + highRiseHouse.getOutbuildings() + SPLIT));
    }
}
