package services;

import java.util.Scanner;

public class MainService {
    private HouseService houseService = new HouseService();
    private Scanner in = new Scanner(System.in);

    public void mainMenu(){
        int x = 0;
        do {
            printMenu();
            x = in.nextInt();
            switch (x){
                case 1 -> creatingHouse();
                case 2 -> searchResidentsInArea();
                case 3 -> searchRoomsInHighRise();
                case 4 -> houseService.delete();
                case 5 -> showAll();
                case 0 -> System.out.println("Exiting, thx for using!");
                default -> System.err.println("Wrong choose");
            }
        } while (x!=0);
    }

    private void showAll() {
        houseService.printAll();
    }

    private void searchRoomsInHighRise() {
        if(!houseService.getHighRiseHouses().isEmpty()) {
            System.out.println("Enter the area of high-rise houses:");
            String location = in.next();
            System.out.println("Count of rooms in " + location + " area = " + houseService.countOfRooms(location));
        } else {
            System.err.println("No one high-rise house");
        }
    }

    private void searchResidentsInArea() {
        if(!houseService.getPrivateHouses().isEmpty()) {
            System.out.println("Enter the area of private houses:");
            String location = in.next();
            System.out.println("Count of residents in " + location + " area = " + houseService.countOfResidents(location));
        } else {
            System.err.println("No one private house");
        }
    }

    private void creatingHouse(){
        System.out.print("""
                Choose type of house:
                1 - Private house
                2 - High-rise house
                """);
        int x = in.nextInt();
        if (x > 0 && x <= 2) {
            houseService.createHouse(x);
        } else {
            System.err.println("Wrong choose!");
        }
    }

    private void printMenu(){
        System.out.print("""
                    Main menu:
                    1 - Create house
                    2 - Search count of residents in the area (Private house)
                    3 - Search count of rooms in the area (High-rise house)
                    4 - Delete houses which size of terrain less than 6
                    5 - Show all houses
                    0 - Exit
                    """);
    }
}
