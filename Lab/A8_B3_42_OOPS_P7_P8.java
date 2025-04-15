import java.io.*;
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

        Scanner scanner = new Scanner(System.in);
        int choice=0;

        System.out.println("Enter 1 To Display All Products");
        System.out.println("Enter 2 To Display Products With 50% Discount And Final Cost:");
        System.out.println("Enter 3 To Exit");

        while (choice != 3) {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("All Products:\n");
                    Iterator<Product> iterator = products.iterator();
                    while (iterator.hasNext()) {
                        Product p = iterator.next();
                        p.display_product();
                    }
                    break;
                case 2:
                    System.out.println("Products with 50% Discount:");
                    for (Product p : products) {
                        if (p.getmax_discount() == 50) {
                            p.display_product();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Exiting...\n");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }
        scanner.close();
    }
}
