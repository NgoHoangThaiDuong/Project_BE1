
package Model;

import java.io.Serializable;


public abstract class Vehicle implements Serializable {
    private String name;
    private String color;
    private String brand;
    private String type;
    private String id;
    private int productYear;
    private double price;

    public Vehicle(String id, String name, String color, String brand, String type, int productYear, double price) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.brand = brand;
        this.type = type;
        this.productYear = productYear;
        this.price = price;
    }
    
     public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    public abstract String getFormatInfo();

    @Override
    public String toString() {
        return String.format("| %-8s | %-20s | %-10s | %-15s | %-10s | %-4d | %,10.2f | %-10s |", id, name, color, brand, type, productYear, price, getFormatInfo());
    }

       
}
