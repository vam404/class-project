package co.edu.poli.models;

/**
 * SalesReport class
 * This class represents a sales report of a product
 *
 * @version 1.0 06 Apr 2024
 */
public class SalesReport extends Product {
    // Total sales of the product
    private double totalSales;

    /**
     * Constructor
     *
     * @param id    Product id
     * @param name  Product name
     * @param price Product price
     */
    public SalesReport(long id, String name, double price, double totalSales) {
        super(id, name, price);
        this.totalSales = totalSales;
    }

    /**
     * Get the total sales info
     *
     * @return Total sales info
     */
    @Override
    public String toString() {
        return super.toString() + ';' + totalSales;
    }
}
