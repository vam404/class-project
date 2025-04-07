package co.edu.poli.models;

/**
 * Product class
 * This class represents a product
 *
 * @version 1.0 22 Mar 2024
 */
public class Product {
    // ID of the product
    private long id;
    // Name of the product
    private String name;
    // Price of the product
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

    /**
     * Get the product id
     * @return Product id
     */
    public long getId() {
        return id;
    }

    /**
     * Get the product info
     * @return Product info
     */
    @Override
    public String toString() {
        return Long.toString(id) + ';' + name + ';' + price;
    }
}
