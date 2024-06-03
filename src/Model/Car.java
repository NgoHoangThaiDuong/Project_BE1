
package Model;


public class Car extends Vehicle {
    private int numberOfSeats; 
    
    public Car(String id, String name, String color, String brand, String type, int productYear, double price, int numberOfSeats) {
        super(id, name, color, brand, type, productYear, price);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
    @Override
     public void displayInfo() {
        System.out.println("Car ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Color: " + getColor());
        System.out.println("Price: " + getPrice());
        System.out.println("Brand: " + getBrand());
        System.out.println("Type: " + getType());
        System.out.println("Product Year: " + getProductYear());
        System.out.println("Number of Seats: " + numberOfSeats);
    }
  
    

    
}
