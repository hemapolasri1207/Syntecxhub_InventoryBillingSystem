
	import java.util.*;

	// Item Class
	class Item {
	    String name;
	    double price;
	    int quantity;

	    // Constructor
	    Item(String name, double price, int quantity) {
	        this.name = name;
	        this.price = price;
	        this.quantity = quantity;
	    }
	}

	// Main Class
	public class InventoryBillingSystem {

	    static ArrayList<Item> inventory = new ArrayList<>();
	    static Scanner sc = new Scanner(System.in);

	    // Add Item
	    public static void addItem() {
	        System.out.print("Enter item name: ");
	        String name = sc.next();

	        System.out.print("Enter price: ");
	        double price = sc.nextDouble();

	        System.out.print("Enter quantity: ");
	        int quantity = sc.nextInt();

	        inventory.add(new Item(name, price, quantity));
	        System.out.println("Item added successfully!");
	    }

	    // Display Items
	    public static void displayItems() {
	        if (inventory.isEmpty()) {
	            System.out.println("No items available!");
	            return;
	        }

	        System.out.println("\nAvailable Items:");
	        for (Item item : inventory) {
	            System.out.println(item.name + " | Price: ₹" + item.price + " | Stock: " + item.quantity);
	        }
	    }

	    // Update Stock
	    public static void updateStock() {
	        System.out.print("Enter item name to update: ");
	        String name = sc.next();

	        for (Item item : inventory) {
	            if (item.name.equalsIgnoreCase(name)) {
	                System.out.print("Enter new quantity: ");
	                item.quantity = sc.nextInt();
	                System.out.println("Stock updated!");
	                return;
	            }
	        }
	        System.out.println("Item not found!");
	    }

	    // Generate Bill
	    public static void generateBill() {
	        double total = 0;

	        System.out.println("\n--- Billing ---");

	        while (true) {
	            System.out.print("Enter item name (or 'done' to finish): ");
	            String name = sc.next();

	            if (name.equalsIgnoreCase("done")) break;

	            for (Item item : inventory) {
	                if (item.name.equalsIgnoreCase(name)) {
	                    System.out.print("Enter quantity: ");
	                    int qty = sc.nextInt();

	                    if (qty <= item.quantity) {
	                        double cost = qty * item.price;
	                        total += cost;
	                        item.quantity -= qty;

	                        System.out.println(item.name + " x " + qty + " = ₹" + cost);
	                    } else {
	                        System.out.println("Insufficient stock!");
	                    }
	                    break;
	                }
	            }
	        }

	        System.out.println("Total Bill: ₹" + total);
	    }

	    // Main Menu
	    public static void main(String[] args) {
	        int choice;

	        do {
	            System.out.println("\n===== Inventory Billing System =====");
	            System.out.println("1. Add Item");
	            System.out.println("2. Display Items");
	            System.out.println("3. Update Stock");
	            System.out.println("4. Generate Bill");
	            System.out.println("5. Exit");
	            System.out.print("Enter choice: ");

	            choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    addItem();
	                    break;

	                case 2:
	                    displayItems();
	                    break;

	                case 3:
	                    updateStock();
	                    break;

	                case 4:
	                    generateBill();
	                    break;

	                case 5:
	                    System.out.println("Visit Again \n exiting............");
	                    break;

	                default:
	                    System.out.println("Invalid choice!");
	            }

	        } while (choice != 5);
	    }
	}
