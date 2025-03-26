package co.edu.poli.models;

/**
 * Product class
 * This class represents a product
 *
 * @version 1.0 22 Mar 2024
 */
public class Product {
    private long id;
    private String name;
    private double price;

    /**
     * Constructor
     * @param id Product id
     * @param name Product name
     * @param price Product price
     */
    public Product(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return Long.toString(id) + ';' + name + ';' + price;
    }
}
