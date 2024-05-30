
package Model;


public class Vehicle {
    private String name;
    private String color;
    private String brand;
    private String type;
    private int id;
    private int productYear;
    private double price;

    public Vehicle(String name, String color, String brand, String type, int id, int productYear, double price) {
        this.name = name;
        this.color = color;
        this.brand = brand;
        this.type = type;
        this.id = id;
        this.productYear = productYear;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductYear() {
        return productYear;
    }

    public void setProductYear(int productYear) {
        this.productYear = productYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
