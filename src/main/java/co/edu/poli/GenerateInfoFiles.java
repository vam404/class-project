package co.edu.poli;

import co.edu.poli.models.Product;
import co.edu.poli.models.SalesMen;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateInfoFiles {
    public static void main(String[] args) {
        List<SalesMen> salesMens = createSalesManInfoFile(5);
        List<Product> products = createProductsFile(5);

        for (SalesMen salesMen : salesMens) {
            createSalesMenFile(salesMen, products, 15);
        }
    }

    private static void createSalesMenFile(SalesMen salesMen, List<Product> Products, int randomSalesCount) {
        if (salesMen == null || Products == null || randomSalesCount <= 0) return;

        String filePath = String.format("src/files/test/output/Sales%s.txt", salesMen.getDocumentNumber());
        Path path = Paths.get(filePath);

        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(String.format("%s;%s", salesMen.getDocumentType(), salesMen.getDocumentNumber()));
            bw.newLine();

            for (int x = 0; x < ThreadLocalRandom.current().nextInt(1, 15); x++) {
                Product product = Products.get(ThreadLocalRandom.current().nextInt(0, Products.size()));
                bw.write(String.format("%s;%s", product.getId(), ThreadLocalRandom.current().nextInt(1, 100)));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Product> createProductsFile(int productsCount) {
        if (productsCount <= 0) return null;

        List<String> productsNames = getProducts();
        if (productsNames == null) return null;

        List<Product> products = new ArrayList<>();

        for (int i = 0; i < productsCount; i++) {
            String name = productsNames.get(i);
            double price = ThreadLocalRandom.current().nextInt(1000, 100000);

            products.add(new Product(i, name, price));
        }

        String filePath = "src/files/test/output/Products.txt";
        Path path = Paths.get(filePath);

        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Product product : products) {
                bw.write(product.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }

    private static List<SalesMen> createSalesManInfoFile(int salesmanCount) {
        if (salesmanCount <= 0) return null;

        List<String> names = getNames();
        if (names == null) return null;

        List<SalesMen> salesMens = new ArrayList<>();

        for (int i = 0; i < salesmanCount; i++) {
            String name = names.get(i);
            long id = (ThreadLocalRandom.current().nextInt(500000, 1000000));

            String[] nameSplit = name.split(" ");

            salesMens.add(new SalesMen(Long.toString(id), "CC", nameSplit[0], nameSplit[1]));
        }

        String filePath = "src/files/test/output/SalesMans.txt";
        Path path = Paths.get(filePath);

        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (SalesMen salesMen : salesMens) {
                bw.write(salesMen.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return salesMens;
    }

    private static List<String> getProducts() {
        String filePath = "src/files/test/input/Products.csv";

        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static List<String> getNames() {
        String filePath = "src/files/test/input/Names.csv";

        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
