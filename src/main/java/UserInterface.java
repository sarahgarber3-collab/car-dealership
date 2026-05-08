import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    public UserInterface() {

    }

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
    public void display() {
        init();
        Scanner scanner = new Scanner(System.in);
        int command;

        do {
            System.out.println("---Dealership Menu---");
            System.out.println("1. Find vehicles by price.");
            System.out.println("2. Find vehicles by make/model.");
            System.out.println("3. Find vehicle by year range.");
            System.out.println("4. Find vehicle by color.");
            System.out.println("5. Find vehicle by  mileage.");
            System.out.println("6. Find vehicle by type.");
            System.out.println("7. List all vehicle.");
            System.out.println("8. Add a vehicle.");
            System.out.println("9. Remove a vehicle.");

            command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processGetAllVehiclesRequest();
                case 8 -> processAddVehicleRequest();
                case 9 -> processRemoveVehicleRequest();
                case 99 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid option.");
            }
        }while (command != 99);

    }
    private void processGetAllVehiclesRequest() {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }
    private void processGetByPriceRequest(){

    }
    private void processGetByMakeModelRequest(){

    }
    private void processGetByYearRequest(){

    }
    private void processGetByColorRequest(){

    }
    private void processGetByMileageRequest(){

    }
    private void processGetByVehicleTypeRequest(){

    }
    private void processAddVehicleRequest() {

    }
    private void processRemoveVehicleRequest(){

    }
}
