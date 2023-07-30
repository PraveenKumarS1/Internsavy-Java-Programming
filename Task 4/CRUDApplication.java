import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Item {
    private int id;
    private String name;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class CRUDApplication {
    private static List<Item> itemList = new ArrayList<>();
    private static int nextId = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to CRUD Application!");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add new item");
            System.out.println("2. View all items");
            System.out.println("3. Update an item");
            System.out.println("4. Delete an item");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading the integer input.

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    viewAllItems();
                    break;
                case 3:
                    updateItem();
                    break;
                case 4:
                    deleteItem();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void addItem() {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        Item newItem = new Item(nextId, name);
        itemList.add(newItem);
        nextId++;
        System.out.println("Item added successfully!");
    }

    private static void viewAllItems() {
        if (itemList.isEmpty()) {
            System.out.println("No items found.");
        } else {
            System.out.println("Items in the list:");
            for (Item item : itemList) {
                System.out.println("ID: " + item.getId() + ", Name: " + item.getName());
            }
        }
    }

    private static void updateItem() {
        System.out.print("Enter the ID of the item to update: ");
        int itemId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after reading the integer input.

        for (Item item : itemList) {
            if (item.getId() == itemId) {
                System.out.print("Enter new name for the item: ");
                String newName = scanner.nextLine();
                item.setName(newName);
                System.out.println("Item updated successfully!");
                return;
            }
        }

        System.out.println("Item with ID " + itemId + " not found.");
    }

    private static void deleteItem() {
        System.out.print("Enter the ID of the item to delete: ");
        int itemId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after reading the integer input.

        for (Item item : itemList) {
            if (item.getId() == itemId) {
                itemList.remove(item);
                System.out.println("Item deleted successfully!");
                return;
            }
        }

        System.out.println("Item with ID " + itemId + " not found.");
    }
}
