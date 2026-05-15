import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ContractFileManager {
    public static ArrayList<Contract> getContracts(){
        ArrayList<Contract> contracts = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/contracts.csv"));

            String contractData;
            reader.readLine(); //deals with header row
            while ((contractData = reader.readLine()) != null) {
                String[] split = contractData.split("\\|");

                String type = split[0];
                String date  = split[1];
                String customerName = split[2];
                String customerEmail = split[3];
                int vin = Integer.parseInt(split[4]);
                int year = Integer.parseInt(split[5]);
                String make = split[6];
                String model = split[7];
                String vehicleType = split[8];
                String color = split[9];
                int odometer = Integer.parseInt(split[10]);
                double price = Double.parseDouble(split[11]);

                Vehicle vehicle = new Vehicle(vin, year, odometer, make, model, vehicleType, color, price);
                dealership.addVehicle(vehicle);
            }

            buffReader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return dealership;
    }
    }
}
