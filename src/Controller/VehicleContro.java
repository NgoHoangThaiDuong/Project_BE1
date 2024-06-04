
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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class VehicleContro {
    private ArrayList<Vehicle> vehicleList;
    private VehicleView view;
    private final String dataFile = "src\\Data\\Vehicle.txt";
    Scanner scanner = new Scanner(System.in);

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
        for(Vehicle vehicle : vehicleList){
            if(vehicle.getId().equals(newVehicle.getId())){
                System.out.println("Vehicle ID already exists");
                return;
            }
        }
        vehicleList.add(newVehicle);
        System.out.println("Vehicle added successfully");
        saveToFile();
    }
    public void updateVehicle() {
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
                System.out.println("Price cannot be empty");
        }
    }
        System.out.println("Vehicle update succesfully");
        saveToFile();
}
    public void deleteVehicle(){
        System.out.println("Enter vehicle ID to delete:");
        String idToDelete = scanner.nextLine();
        Vehicle vehicleToDelete = null;
        
        for (Vehicle vehicle : vehicleList) {
            if(vehicle.getId().equals(idToDelete)){
                vehicleToDelete = vehicle;
                break;
            }
        }
        if (vehicleToDelete == null) {
            System.out.println("Vehicle not found with this ID");
            return;
        }
        
        System.out.println("Are you sure you want to delete this vehicle? (yes/no):");
        String confirm = scanner.nextLine();
        if(confirm.equalsIgnoreCase("yes")) {
            vehicleList.remove(vehicleToDelete);
            System.out.println("Vehicle deleted successfully");
            saveToFile();
        } else {
            System.out.println("Cancelled");
        }
    }
    public void searchVehicle(){
        System.out.println("Select way to search:");
        System.out.println("1.By name");
        System.out.println("2.By ID");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            if(choice == 1){
                searchByName();
            } else if (choice == 2) {
                searchById();
            } else {
                System.out.println("Invalid choice");
            }
        } catch (Exception e) {
            System.out.println("Please enter correct choice");
        }
    }
        private void searchByName() {
            System.out.println("Enter vehicle name to search");
            String nameToSearch = scanner.nextLine().toLowerCase();
            List<Vehicle> foundVehicles = new ArrayList<>();
            for (Vehicle vehicle : vehicleList){
                if(vehicle.getName().toLowerCase().contains(nameToSearch)){
                    foundVehicles.add(vehicle);
                }
            }
            if(foundVehicles.isEmpty()){
                System.out.println("No vehicle found");
            } else {
                foundVehicles.sort(Comparator.comparing(Vehicle::getPrice).reversed());
                view.displayVehicleList(foundVehicles);
            }
        }
        private void searchById() {
            System.out.println("Enter vehicle ID to search");
            String idToSearch = scanner.nextLine();
            List<Vehicle> foundVehicles = new ArrayList<>();
            
            for (Vehicle vehicle : vehicleList) {
                if(vehicle.getId().equals(idToSearch)){
                    foundVehicles.add(vehicle);
                    view.displayVehicleList(foundVehicles);
                    return;
                }
            }
            System.out.println("Vehicle not found");
        }
        public void displayVehicleList(){
            System.out.println("Select way to show");
            System.out.println("1.Show all");
            System.out.println("2.Show by descending price");
             
            try{
                int choice = Integer.parseInt(scanner.nextLine());
                if(choice == 1){
                    displayAll();
                } else if (choice == 2){
                    displayByDescendingPrice();
                } else {
                    System.out.println("Invalid choice");
                }
            } catch (Exception e){
                System.out.println("Please enter correct choice");
            }
    
}
        private void displayAll(){
            view.displayVehicleList(vehicleList);
        }
        private void displayByDescendingPrice(){
            List<Vehicle> sortedVehicles = new ArrayList<>(vehicleList);
            sortedVehicles.sort(Comparator.comparing(Vehicle::getPrice).reversed());
            view.displayVehicleList(sortedVehicles);
        }
        
    }



