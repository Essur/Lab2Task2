package factory;

import houses.HighRiseHouse;
import houses.House;
import houses.HouseType;
import houses.PrivateHouse;

import java.util.Scanner;

public class HouseFactory {
    private final Scanner in = new Scanner(System.in);
    public House crateHouse(HouseType type){
        return switch (type) {
            case PRIVATE -> addInfo(new PrivateHouse());
            case HIGHRISE -> addInfo(new HighRiseHouse());
        };
    }
    private House addInfo(House house){
        if(house instanceof  PrivateHouse){
            System.out.println("Enter the area of private house:");
            house.setLocation(in.next());
            System.out.println("Enter count of rooms:");
            ((PrivateHouse) house).setCountOfRooms(in.nextInt());
            System.out.println("Enter count of residents:");
            ((PrivateHouse) house).setCountOfResidents(in.nextInt());
            System.out.println("Enter size of terrain");
            ((PrivateHouse) house).setSizeOfTerrain(in.nextDouble());
        } else if (house instanceof HighRiseHouse){
            System.out.println("Enter the area of high-rise house:");
            house.setLocation(in.next());
            System.out.println("Enter count of floors:");
            ((HighRiseHouse) house).setCountOfFloors(in.nextInt());
            System.out.println("Enter count of rooms at floor:");
            ((HighRiseHouse) house).setCountOfRoomsAtFloor(in.nextInt());
            System.out.println("Enter count of outbuildings");
            ((HighRiseHouse) house).setOutbuildings(in.nextInt());
        }
        return house;
    }
}
