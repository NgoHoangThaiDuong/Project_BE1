
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
        String id;
        String name;
        String color;
        String brand;
        String type;
        int numberOfSeats;
        int productYear;
        double price;
        int engineCapacity;
        int vehicleType;
        
        while (true) {           
        try {
        System.out.println("Enter Vehicle Type (1.Car, 2.Motorbike):");
        vehicleType = Integer.parseInt(scanner.nextLine());
        if (vehicleType == 1 || vehicleType == 2){
            break;
        }else{
            System.out.println("Please enter 1 for Car or 2 for Motorbike");
        }
        } catch (Exception e){
            System.out.println("Please enter a number");
        }
        }
        while (true) {           
        System.out.println("Enter Vehicle ID:");
        id = scanner.nextLine();
        if(!id.isEmpty()){
            break;
        } else {
            System.out.println("ID can't be empty");
        }
        }
        while (true) {            
        System.out.println("Enter Vehicle Name:");
        name = scanner.nextLine();
        if(!name.isEmpty()){
            break;
        } else {
            System.out.println("Name can't be empty");
        }
        }
        while (true) {            
        System.out.println("Enter Vehicle Color:");
        color = scanner.nextLine();
        if(!color.isEmpty()){
            break;
        } else {
            System.out.println("Color can't be empty");
        }
        }
        while (true) {            
        System.out.println("Enter Vehicle Brand:");
        brand = scanner.nextLine();
        if(!brand.isEmpty()){
            break;
        } else {
            System.out.println("Brand can't be empty");
        }
        }
        while (true) {            
        System.out.println("Enter Vehicle Type:");
        type = scanner.nextLine();
        if(!type.isEmpty()){
            break;
        } else {
            System.out.println("Type can't be empty");
        }
        }
        while(true) {
            try {
                System.out.println("Enter Vehicle Price:");
                price = Double.parseDouble(scanner.nextLine());
                break;
            } catch (Exception e){
                System.out.println("Please enter a valid double for price");
            }
        }
               
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
}
