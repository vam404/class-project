package co.edu.poli;

import co.edu.poli.models.Product;
import co.edu.poli.models.SalesMan;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * GenerateInfoFiles class
 * This class generates the files with the dummy data for the tests
 *
 * @version 1.0 22 Mar 2025
 */
public class GenerateInfoFiles {
    public static void main(String[] args) {
        // Create a salesmen info file and return the list of salesmen
        List<SalesMan> salesMEN = createSalesManInfoFile(5);
        // Create a products file and return the list of products
        List<Product> products = createProductsFile(5);

        // Iterate over the list of salesmen and create a sales file for each salesman
        for (SalesMan salesMan : salesMEN) {
            createSalesMenFile(salesMan, products, 15);
        }
    }

    /**
     * Create a sales file
     * @param salesMan SalesMan object
     * @param Products List of products
     * @param randomSalesCount Random sales count
     */
    private static void createSalesMenFile(SalesMan salesMan, List<Product> Products, int randomSalesCount) {
        // Check if the salesmen and products are not null and the random sales count is greater than 0
        if (salesMan == null || Products == null || randomSalesCount <= 0) return;

        // Create a file path for the salesmen file
        String filePath = String.format("src/files/test/output/Sales_%s.txt", salesMan.getDocumentNumber());
        // Create a path object
        Path path = Paths.get(filePath);

        try {
            // Check if the file exists, if not create it
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            // Write the header
            bw.write(String.format("%s;%s", salesMan.getDocumentType(), salesMan.getDocumentNumber()));
            // Write a new line
            bw.newLine();

            // Write the salesmen sales
            for (int x = 0; x < ThreadLocalRandom.current().nextInt(1, 15); x++) {
                // Get a random product from the list of products
                Product product = Products.get(ThreadLocalRandom.current().nextInt(0, Products.size()));
                // Write the product id and a random quantity
                bw.write(String.format("%s;%s", product.getId(), ThreadLocalRandom.current().nextInt(1, 100)));
                // Write a new line
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create a products file
     * @param productsCount Products count
     * @return List of products
     */
    private static List<Product> createProductsFile(int productsCount) {
        // Check if the products count is greater than 0
        if (productsCount <= 0) return null;

        // Get the products from the file
        List<String> productsNames = getProducts();
        // Check if the products names are not null
        if (productsNames == null) return null;

        // Create a list of products
        List<Product> products = new ArrayList<>();

        // Create a product for each product name
        for (int i = 0; i < productsCount; i++) {
            // Get a random product name from the list of products
            String name = productsNames.get(i);
            // Generate a random product price
            double price = ThreadLocalRandom.current().nextInt(1000, 100000);

            // Create a product object and add it to the list of products
            products.add(new Product(i, name, price));
        }

        // Create a file path for the products file
        String filePath = "src/files/test/output/products.txt";
        // Create a path object
        Path path = Paths.get(filePath);

        try {
            // Check if the file exists, if not create it
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write the products to the file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            // Iterate over the list of products and write each product to the file
            for (Product product : products) {
                // Write the product id, name and price
                bw.write(product.toString());
                // Write a new line
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Return the list of products
        return products;
    }

    /**
     * Create a salesman info file
     * @param salesmanCount Number of salesmen to generate for the info file
     * @return List of salesmen
     */
    private static List<SalesMan> createSalesManInfoFile(int salesmanCount) {
        // Check if the salesman count is greater than 0
        if (salesmanCount <= 0) return null;

        // Get the names from the file
        List<String> names = getNames();
        // Check if the names are not null
        if (names == null) return null;

        // Create a list of salesmen
        List<SalesMan> salesMEN = new ArrayList<>();

        // Create a salesman for each name
        for (int i = 0; i < salesmanCount; i++) {
            // Get a random name from the list of names
            String name = names.get(i);
            // Generate a random id
            long id = (ThreadLocalRandom.current().nextInt(500000, 1000000));

            // Split the name into first and last name
            String[] nameSplit = name.split(" ");

            // Create a salesmen object and add it to the list of salesmen
            salesMEN.add(new SalesMan(Long.toString(id), "CC", nameSplit[0], nameSplit[1]));
        }

        // Create a file path for the salesmen file
        String filePath = "src/files/test/output/salesMen.txt";
        // Create a path object
        Path path = Paths.get(filePath);

        try {
            // Check if the file exists, if not create it
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write the salesmen to the file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            // Iterate over the list of salesmen and write each salesman to the file
            for (SalesMan salesMan : salesMEN) {
                // Write the salesman id, name and last name
                bw.write(salesMan.toString());
                // Write a new line
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Return the list of salesmen
        return salesMEN;
    }

    /** Get products from file */
    private static List<String> getProducts() {
        // File path for the products file
        String filePath = "src/files/test/input/Products.csv";

        try {
            // Read all lines from the file and return them as a list
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /** Get names from file */
    private static List<String> getNames() {
        // File path for the names file
        String filePath = "src/files/test/input/Names.csv";

        try {
            // Read all lines from the file and return them as a list
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
