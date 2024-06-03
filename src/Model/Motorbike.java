
package Model;


public class Motorbike extends Vehicle{
    private int engineCapacity;
    public Motorbike(String id, String name, String color, String brand, String type, int productYear, double price, int engineCapacity) {
        super(id, name, color, brand, type, productYear, price);
        this.engineCapacity = engineCapacity;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }
    @Override
    public void displayInfo() {
        System.out.println("Motorbike ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Color: " + getColor());
        System.out.println("Price: " + getPrice());
        System.out.println("Brand: " + getBrand());
        System.out.println("Type: " + getType());
        System.out.println("Product Year: " + getProductYear());
        System.out.println("Engine Capacity: " + engineCapacity + "cc");
        
    }    
}
