package com.stu.exercise1.presentation;

import com.stu.exercise1.entity.Product;
import com.stu.exercise1.service.ProductService;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ProductService productService = new ProductService();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n--- Product Management System ---");

            System.out.println("1. Add Product");
            System.out.println("2. Edit Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Products");
            System.out.println("5. Filter Products (Price > 100)");
            System.out.println("6. Total Value of Products");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1: {
                    System.out.print("Enter Product ID: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Product Price: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    Product product = new Product(id, name, price);

                    if (productService.save(product)) {
                        System.out.println("Product added successfully");

                    } else {
                        System.out.println("Product ID already exists");
                    }
                    break;
                }

                case 2: {

                    System.out.print("Enter Product ID to edit: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter new Product Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter new Product Price: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    Product product = new Product(id, name, price);

                    if (productService.update(product)) {
                        System.out.println("Product updated successfully");

                    } else {
                        System.out.println("Product not found");
                    }
                    break;
                }

                case 3: {

                    System.out.print("Enter Product ID to delete: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    if (productService.deleteById(id)) {
                        System.out.println("Product deleted successfully");
                    } else {
                        System.out.println("Product not found");
                    }
                    break;
                }

                // Display Products
                case 4: {
                    productService.displayProduct();
                    break;
                }

                case 5: {

                    Map<Integer, Product> filterProducts = productService.filterPrice();

                    if (filterProducts.isEmpty()) {
                        System.out.println("No products found");

                    } else {
                        filterProducts.forEach((id, product) -> System.out.println(product)
                        );
                    }
                    break;
                }

                case 6: {
                    double total = productService.SumProduct();
                    System.out.println("Total value of products: " + total);
                    break;
                }

                case 0: {
                    System.out.println("Program exited");
                    System.exit(0);
                }

                default: {
                    System.out.println("Invalid choice");
                }
            }
        }
    }
}
