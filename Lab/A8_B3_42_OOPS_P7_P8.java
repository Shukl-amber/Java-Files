import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Product {
    private String product_name, manufacturer;
    private double max_discount, cost;

    public Product(String name, String mf, double price, double mdiscount) {
        this.product_name = name;
        this.manufacturer = mf;
        this.cost = price;
        this.max_discount = mdiscount;
    }

    public double getmax_discount() {
        return max_discount;
    }

    public double getfinal_discount() {
        return (cost - (cost * max_discount / 100));
    }

    public void display_product() {
        System.out.println("Product Name: " + product_name + ",");
        System.out.println("Cost: " + cost + ",");
        System.out.println("Manufacturer: " + manufacturer + ",");
        System.out.println("Max Discount: " + max_discount + "%,");
        System.out.println("Final Cost: " + getfinal_discount() + "\n");
    }
}

public class A8_B3_42_OOPS_P7_P8 {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("products.txt"))) {
            String line;
            while ((line = br.readLine()) != null && products.size() < 10) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0].trim();
                    double cost = Double.parseDouble(parts[1].trim());
                    String manufacturer = parts[2].trim();
                    double discount = Double.parseDouble(parts[3].trim());

                    Product p = new Product(name, manufacturer, cost, discount);
                    products.add(p);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        for (Product p : products) {
            p.display_product(); 
        }
    }
}
