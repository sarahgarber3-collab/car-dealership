import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
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
            System.out.println(("10. Sell/Lease a vehicle."));
            System.out.print("Enter a command number: ");

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
                case 10 ->processSellLeaseVehicle();
                case 99 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid option.");
            }
        } while (command != 99);

    }
    private void processSellLeaseVehicle()

    private void processGetAllVehiclesRequest() {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    private void processGetByPriceRequest() {
        System.out.print("Enter minimum price: ");
        double min = scanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double max = scanner.nextDouble();
        scanner.nextLine();

        ArrayList<Vehicle> results = dealership.getVehicleByPrice(min, max);
        displayVehicles(results);

    }

    private void processGetByMakeModelRequest() {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        ArrayList<Vehicle> results = dealership.getVehicleByMakeModel(make, model);
        displayVehicles(results);

    }

    private void processGetByYearRequest() {
        System.out.print("Enter minimum year: ");
        int min = scanner.nextInt();
        System.out.print("Enter maximum year: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Vehicle> results = dealership.getVehiclesByYear(min, max);
        displayVehicles(results);
    }

    private void processGetByColorRequest() {
        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        ArrayList<Vehicle> results = dealership.getVehiclesByColor(color);
        displayVehicles(results);

    }

    private void processGetByMileageRequest() {
        System.out.print("Enter minimum mileage: ");
        int min = scanner.nextInt();
        System.out.print("Enter maximum mileage: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Vehicle> results = dealership.getVehiclesByMileage(min, max);
        displayVehicles(results);

    }

    private void processGetByVehicleTypeRequest() {
        System.out.print("Enter vehicle type: ");
        String type = scanner.nextLine();

        ArrayList<Vehicle> results = dealership.getVehiclesByType(type);
        displayVehicles(results);

    }

    private void processAddVehicleRequest() {
        System.out.print("VIN: ");
        int vin = scanner.nextInt();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Type: ");
        String type = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();

        System.out.print("Odometer: ");
        int odometer = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Vehicle v = new Vehicle(vin, year, odometer, make, model, type, color, price);
        dealership.addVehicle(v);

        DealershipFileManager.saveDealership(dealership);

        System.out.println("Vehicle added.");

    }

    private void processRemoveVehicleRequest() {
        System.out.print("Enter VIN of vehicle to remove: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        Vehicle vehicleToRemove = null;
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getVin() == vin) {
                vehicleToRemove = v;
                break;
            }
        }

        if (vehicleToRemove != null) {
            dealership.removeVehicle(vehicleToRemove);
            DealershipFileManager.saveDealership(dealership);
            System.out.println("Vehicle removed.");
        } else {
            System.out.println("Vehicle not found.");
        }
    }
}
