package co.edu.poli;

import co.edu.poli.models.Product;
import co.edu.poli.models.SalesMan;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Main class
 * This class is the entry point of the program
 *
 * @version 1.1 08 Apr 2025
 */
public class Main {
    public static void main(String[] args) {
        List<Product> products = readProducts();
        List<SalesMan> salesMen = readSalesMen();

        HashMap<String, List<String>> sales = readSales();
    }

    /**
     * Read the products from a file
     *
     * @return List of products
     */
    private static List<Product> readProducts() {
        String filePath = "input/products.txt";

        try {
            // Read all lines from the file
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            // Create a list to store the products
            List<Product> products = new ArrayList<>();

            for (String line : lines) {
                // Split the line by semicolon
                String[] parts = line.split(";");

                // Obtain the product id
                long id = Long.parseLong(parts[0]);
                // Obtain the product name and price
                String name = parts[1];
                // Obtain the product price
                double price = Double.parseDouble(parts[2]);

                // Create a new product and add it to the list
                products.add(new Product(id, name, price));
            }

            return products;
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    /**
     * Read the salesmen from a file
     *
     * @return List of salesmen
     */
    private static List<SalesMan> readSalesMen() {
        String filePath = "input/salesmen.txt";

        try {
            // Read all lines from the file
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            // Create a list to store the salesmen
            List<SalesMan> salesMen = new ArrayList<>();

            for (String line : lines) {
                // Split the line by semicolon
                String[] parts = line.split(";");

                // Obtain the salesman document number
                String documentNumber = parts[0];
                // Obtain the salesman document type
                String documentType = parts[1];
                // Obtain the salesman names
                String names = parts[2];
                // Obtain the salesman surnames
                String surnames = parts[3];

                // Create a new salesman and add it to the list
                salesMen.add(new SalesMan(documentNumber, documentType, names, surnames));
            }

            return salesMen;
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    /**
     * Read the sales from a folder
     *
     * @return Map of sales
     */
    private static HashMap<String, List<String>> readSales() {
        // Create a map to store the sales
        HashMap<String, List<String>> sales = new HashMap<>();
        // Path to the folder containing the sales files
        String folderPath = "input/sales";

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(folderPath))) {
            for (Path filePath : stream) {
                // Check if the path is a file
                if (Files.isRegularFile(filePath)) {
                    // Read all lines from the file
                    List<String> lines = Files.readAllLines(filePath);

                    // Index to keep track of the first line
                    int index = 0;
                    // Key to store the first line
                    String key = "";
                    // List to store the values
                    List<String> values = new ArrayList<>();

                    // Print the content of the file
                    for (String line : lines) {
                        // Check if is the first line
                        if (index == 0) {
                            // Assign the first line to the key
                            key = line;
                            // Increment the index
                            index++;
                        }
                        else {
                            // Add the line to the values list
                            values.add(line);
                        }
                    }

                    // Add the key and values to the map
                    if (!sales.containsKey(key)) {
                        sales.put(key, values);
                    }
                    else {
                        // Get the existing values and add the new values
                        List<String> val = sales.get(key);
                        val.addAll(values);

                        // Replace the existing values with the new values
                        sales.replace(key, val);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sales;
    }
}