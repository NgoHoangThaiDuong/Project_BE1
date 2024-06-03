
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
    
}
