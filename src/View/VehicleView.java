
package View;

import Model.Car;
import Model.Motorbike;
import Model.Vehicle;
import java.util.ArrayList;
import java.util.Scanner;


public class VehicleView {
    private Scanner scanner;
    
    public VehicleView(){
        scanner = new Scanner(System.in);
    }
    public Vehicle getVehicleDetails(){
        int numberOfSeats;
        int productYear;
        double price;
        int engineCapacity ;
        
        System.out.println("Enter Vehicle Type (1.Car, 2.Motorbike):");
        int vehicleType = scanner.nextInt();
        
        System.out.println("Enter Vehicle ID:");
        String id = scanner.nextLine();
                
        System.out.println("Enter Vehicle Name:");
        String name = scanner.nextLine();
        
        System.out.println("Enter Vehicle Color:");
        String color = scanner.nextLine();
        
        while(true) {
            try {
                System.out.println("Enter Vehicle Price:");
                price = Double.parseDouble(scanner.nextLine());
                break;
            } catch (Exception e){
                System.out.println("Please enter a valid double for price");
            }
        }
        System.out.println("Enter Vehicle Brand:");
        String brand = scanner.nextLine();
        
        System.out.println("Enter Vehicle Type:");
        String type = scanner.nextLine();
        
        while(true) {
            try {
                System.out.println("Enter Vehicle Product Year:");
                productYear = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e){
                System.out.println("Please enter a valid int for product year");
            }
        }
        if (vehicleType == 1) {
            while(true) {
                try {
                System.out.println("Enter Number Of Seats");
                numberOfSeats = Integer.parseInt(scanner.nextLine());
                break;
                } catch (Exception e) {
                    System.out.println("Please enter a valid int for number of seats");
                }                
            }
            return new Car(id, name, color, brand, type, productYear, price, numberOfSeats);
            
        } else if (vehicleType == 2) {
            while(true) {
                try {
                    System.out.println("Enter Engine Capacity");
                    engineCapacity = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Please enter a valid int for engine capacity");
                }
            }
            return new Motorbike(id, name, color, brand, type, productYear, price, engineCapacity);
        } else {
            System.out.println("Invalid vehicle type");
            return getVehicleDetails();
        }
    }
        public void displayVehicleList(ArrayList<Vehicle> vehicleList){
            for(Vehicle vehicle : vehicleList){
                vehicle.displayInfo();
            }
        }
        public int getVehicleId() {
        System.out.println("Enter Vehicle ID:");
        return scanner.nextInt();
    }

    
}
