
package Model;


public class Car extends Vehicle {
    private int numberOfSeats; 
    
    public Car(String id,String name, String color, String brand, String type, int productYear, double price, int numberOfSeats) {
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
    public String getFormatInfo(){
        return String.format("%d", numberOfSeats);
    }
    }   

