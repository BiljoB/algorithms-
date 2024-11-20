import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {
    private List<Item> items;


    public Shop() {
        this.items = new ArrayList<>();
    }


    public void addItem(String name, String category, String sku) {
        Item newItem = new Item(name, category, sku);
        items.add(newItem);
        System.out.println("Item added: " + newItem);
    }


    public boolean removeItem(String sku) {
        for (Item item : items) {
            if (item.getSku().equals(sku)) {
                items.remove(item);
                System.out.println("Item removed: " + item);
                return true;
            }
        }
        System.out.println("Item with SKU " + sku + " not found.");
        return false;
    }


    public boolean editItem(String sku, String newName, String newCategory, String newSku) {
        for (Item item : items) {
            if (item.getSku().equals(sku)) {
                item.setName(newName);
                item.setCategory(newCategory);
                item.setSku(newSku);
                System.out.println("Item updated: " + item);
                return true;
            }
        }
        System.out.println("Item with SKU " + sku + " not found.");
        return false;
    }


    public void deleteAllItems() {
        items.clear();
        System.out.println("All items have been deleted.");
    }

    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("No items in the shop.");
        } else {
            System.out.println("Items in the shop:");
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }


    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Shop Menu ===");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Edit Product");
            System.out.println("4. Display Products");
            System.out.println("5. Delete All Products");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter product SKU: ");
                    String sku = scanner.nextLine();
                    addItem(name, category, sku);
                    break;
                case 2:

                    System.out.print("Enter SKU of product to remove: ");
                    String skuToRemove = scanner.nextLine();
                    removeItem(skuToRemove);
                    break;
                case 3:

                    System.out.print("Enter SKU of product to edit: ");
                    String skuToEdit = scanner.nextLine();
                    System.out.print("Enter new product name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new product category: ");
                    String newCategory = scanner.nextLine();
                    System.out.print("Enter new product SKU: ");
                    String newSku = scanner.nextLine();
                    editItem(skuToEdit, newName, newCategory, newSku);
                    break;
                case 4:

                    displayItems();
                    break;
                case 5:

                    deleteAllItems();
                    break;
                case 6:

                    running = false;
                    System.out.println("Exiting the shop.");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        scanner.close();
    }
}
