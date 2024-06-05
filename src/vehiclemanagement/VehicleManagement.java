
package vehiclemanagement;
import Model.Vehicle;
import View.VehicleView;
import Controller.VehicleContro;
import java.util.ArrayList;
import java.util.Scanner;


public class VehicleManagement { 
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        VehicleView view = new VehicleView();
        VehicleContro controller = new VehicleContro(vehicleList, view);
        Scanner scanner = new Scanner(System.in);
        int choice;
        controller.loadToFile();
        while (true) {            
            System.out.println("Vehicle Showroom Management");
            System.out.println("1.Add Vehicle");
            System.out.println("2.Update Vehicle");
            System.out.println("3.Delete Vehicle");
            System.out.println("4.Search Vehicle");
            System.out.println("5.Display Vehicle");
            System.out.println("6.Exit");
            System.out.println("Enter your choice:");
            
            try{
                choice = Integer.parseInt(scanner.nextLine());
                switch(choice){
                    case 1:
                        controller.addVehicle();
                        break;
                    case 2:
                        controller.updateVehicle();
                        break;
                    case 3:
                        controller.deleteVehicle();
                        break;
                    case 4:
                        controller.searchVehicle();
                        break;
                    case 5:
                        controller.displayVehicle();
                        break;
                    case 6:
                        System.out.println("Exit...");
                        controller.saveToFile();
                        break;
                    default:
                        System.out.println("Invalid choice. Try again");
                }
            } catch(Exception e){
                System.out.println("Invalid input. Please enter correct input");
            }
        }
    }
    
}
