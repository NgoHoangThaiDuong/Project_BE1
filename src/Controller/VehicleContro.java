
package Controller;
import Model.Vehicle;
import View.VehicleView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class VehicleContro {
    private ArrayList<Vehicle> vehicleList;
    private VehicleView view;
    private final String dataFile = "src\\Data\\Vehicle.txt";

    public VehicleContro(ArrayList<Vehicle> vehicleList, VehicleView view) {
        this.vehicleList = vehicleList;
        this.view = view;
    }        
    public void saveToFile(){
        try(FileOutputStream fileOutput = new FileOutputStream(dataFile);
                ObjectOutputStream write = new ObjectOutputStream(fileOutput)){
            write.writeObject(vehicleList);
            System.out.println("Success");
        } catch(Exception e) {
            System.out.println("Failed");
        }
    }
    public void loadToFile(){
        try(FileInputStream fileInput = new FileInputStream(dataFile);
                ObjectInputStream read = new ObjectInputStream(fileInput)){
            vehicleList = (ArrayList<Vehicle>) read.readObject();
        } catch(FileNotFoundException e){
            System.out.println("File not found");
        } catch(IOException | ClassNotFoundException e){
            System.out.println("Error loading vehicles");
        }
    }
    public void addVehicle(){
        Vehicle newVehicle = view.getVehicleDetails();
        if (newVehicle == null){
            System.out.println("Failed to add vehicle");
            return;
        }
        for(Vehicle v : vehicleList){
            if(v.getId() == newVehicle.getId()){
                System.out.println("Vehicle ID already exists");
                return;
            }
        }
        vehicleList.add(newVehicle);
        System.out.println("Vehicle added successfully");
        saveToFile();
    }
    public void updateVehicle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Vehicle ID to update:");
        String id = new Scanner(System.in).nextLine();

        Vehicle foundVehicle = null;
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getId().equals(id)) {
                foundVehicle = vehicle;
                break;
            }
        }

        if (foundVehicle == null) {
            System.out.println("Vehicle not found");
            return;
        }
        System.out.println("Enter new details(leave empty to keep current value)");
                          
        System.out.println("Enter new vehicle ID:");
        String newId = scanner.nextLine();
        if(!newId.isEmpty()){
        foundVehicle.setId(newId);
        } else{
            System.out.println("Keeping current ID");
        }

        System.out.println("Enter new vehicle name:");
        String newName = scanner.nextLine();
        if(!newName.isEmpty()){
        foundVehicle.setName(newName);
        } else {
            System.out.println("Keeping current name");
        }
                   
        System.out.println("Enter new vehicle color:");
        String newColor = scanner.nextLine();
        if(!newColor.isEmpty()){
        foundVehicle.setColor(newColor);
        }else {
            System.out.println("Keeping current color");
        }
                
        System.out.println("Enter new vehicle brand:");
        String newBrand = scanner.nextLine();
        if(!newBrand.isEmpty()){
        foundVehicle.setBrand(newBrand);
        } else {
            System.out.println("Keeping current brand");
        }
                       
        System.out.println("Enter new vehicle type:");
        String newType = scanner.nextLine();
        if(!newType.isEmpty()){
        foundVehicle.setType(newType);
        } else {
            System.out.println("Keeping current type");
        }
        while(true) { 
        System.out.println("Enter new vehicle product year");
        String input = scanner.nextLine();
        if (!input.isEmpty()) {
        try {
        int productYear = Integer.parseInt(input);
        foundVehicle.setProductYear(productYear);
        break;
        } catch (Exception e){
        System.out.println("Invalid input for product year");
        }
        } else {
        System.out.println("Keeping current product year");
        break;
        }
    }
        while(true){
            System.out.println("Enter new vehicle price");
            String input = scanner.nextLine();
            if (!input.isEmpty()) {
            try {
                double price = Double.parseDouble(input);
                foundVehicle.setPrice(price);
                break;
            } catch (Exception e){
                System.out.println("Invalid input for price");
            }
            } else {
                System.out.println("price cannot be empty");
        }
    }
        System.out.println("Vehicle update succesfully");
        saveToFile();
}
}

