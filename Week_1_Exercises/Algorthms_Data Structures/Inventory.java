/*Exercise 1: Inventory Management System
Scenario: 
You are developing an inventory management system for a warehouse. Efficient data storage and retrieval are crucial.
Steps:
1.	Understand the Problem:
o	Explain why data structures and algorithms are essential in handling large inventories.
o	Discuss the types of data structures suitable for this problem.
2.	Setup:
o	Create a new project for the inventory management system.
3.	Implementation:
o	Define a class Product with attributes like productId, productName, quantity, and price.
o	Choose an appropriate data structure to store the products (e.g., ArrayList, HashMap).
o	Implement methods to add, update, and delete products from the inventory.
4.	Analysis:
o	Analyze the time complexity of each operation (add, update, delete) in your chosen data structure.
o	Discuss how you can optimize these operations.
 */


 import java.util.HashMap;
 import java.util.Scanner;
 
 //Product
 
 class Product {
     private String productId;
     private String productName;
     private int quantity;
     private double price;
 
     public Product(String productId, String productName, int quantity, double price) {
         this.productId = productId;
         this.productName = productName;
         this.quantity = quantity;
         this.price = price;
     }
 
     // Getters and setters
     public String getProductId() {
         return productId;
     }
 
     public double getPrice() {
         return price;
     }
 
     public String getProductName() {
         return productName;
     }
 
     public int getQuantity() {
         return quantity;
     }

     public String display() {
         return "Product [ID=" + productId + ", Name=" + productName + ", Quantity=" + quantity + ", Price=" + price + "]";
     }
 }
 
 // Inventory
 
 public class Inventory {
     private HashMap<String, Product> inventory;
 
     public Inventory() {
         this.inventory = new HashMap<>();
     }
 
     // Add product to the inventory
     public void addProduct(Product product) {
         inventory.put(product.getProductId(), product);
     }

     // Update product in the inventory
     public void updateProduct(Product product){
        if(inventory.containsKey(product.getProductId())){
            inventory.put(product.getProductId(),product);
        }
        else{
            System.out.println("Not found");
        }
    }

     // Delete product from the inventory
     public void deleteProduct(String productId) {
         if(inventory.containsKey(productId)){
             inventory.remove(productId);
             System.out.println("Product deleted.");
         }else{
             System.out.println("Product not found.");
         }
     }
 //Display products in inventory
     public void displayInventory() {
        if(inventory.isEmpty()){
            System.out.println("Inventory is empty");
        }
         for (Product product : inventory.values()) {
             System.out.println(product.display());
         }
     }

     //checks if product with given id is present or not
     public boolean check (String productId){
        return inventory.containsKey(productId);
     }
 
 
     public static void main(String[] a ){
         Inventory inv = new Inventory();
         Scanner sc= new Scanner (System.in);
         while (true) {
             System.out.println("\n1.Add product\n2.Update product\n3.Delete product\n4.Display inventory\n5.Exit\nEnter your choice");
 
             int choice;
             choice=sc.nextInt();
 
             if(choice==5)
             break;
 
         String id, name;
         int quantity;
         double price;
 
             switch (choice) {
 
                 case 1:
                 System.out.println("Enter product id:");
                 id = sc.next();
                 System.out.println("Enter product name:");
                 name = sc.next();
                 System.out.println("Enter product quantity:");
                 quantity = sc.nextInt();
                 System.out.println("Enter product price:");
                 price = sc.nextDouble();
                 inv.addProduct(new Product(id,name,quantity,price));
                 break;
                 
                 case 2:
                 System.out.println("Enter product id:");
                 id = sc.next();
                 if(inv.check(id)){
                    System.out.println("Enter product name:");
                    name = sc.next();
                    System.out.println("Enter product quantity:");
                    quantity = sc.nextInt();
                    System.out.println("Enter product price:");
                    price = sc.nextDouble();
                    inv.updateProduct(new Product(id,name,quantity,price));
                 }else{
                    System.out.println("Product with ID : "+id+" not found");
                 }
                 break;
 
             case 3:  
                 System.out.println("Enter product id:");
                 id = sc.next();
                 inv.deleteProduct(id);
                 break;
 
             case 4:
                 inv.displayInventory();
                 break;

            default:
            break;
             }
         }
         sc.close();
     }
 }
 
/* 
 Analysis

 Time Complexity Analysis:
 
 Add Product:
 The addProduct method involves adding a product to the HashMap.
 Time Complexity: O(1) 
 Adding an element to a HashMap is generally an O(1) operation due to the average constant-time complexity for insertion.
 
 Update Product:
 The updateProduct method checks if the product with the given product id exists and then updates it.
 Time Complexity: O(1) 
 The containsKey and put methods both have O(1) average time complexity in a HashMap.
 
 Delete Product:
 The deleteProduct method involves removing a product from the HashMap.
 Time Complexity: O(1)
 The containsKey and remove methods have O(1) average time complexity in a HashMap.
 
 The operations can be optimized by :
 1)When creating the HashMap, we can set an initial capacity and load factor that match our expected number of elements to reduce the need for resizing and rehashing.
 2)Batch operations: If user needs to perform multiple updates or additions at once,we can consider batching these operations. This can be more efficient than performing each operation individually due to reduced overhead.
 */
