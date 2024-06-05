
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
    public String getFormatInfo(){
        return String.format("%d cc", engineCapacity);
    }
}
