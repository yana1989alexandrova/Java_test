package Java_test;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LaptopStore {
    private Set<Laptop> laptops;

    // Constructor
    public LaptopStore() {
        laptops = new HashSet<>();
        // Add a few laptops for example
        laptops.add(new Laptop("Dell XPS", 16, 512, "Windows 10", "black"));
        laptops.add(new Laptop("MacBook Pro", 8, 256, "macOS", "gray"));
        laptops.add(new Laptop("Lenovo ThinkPad", 32, 1_000, "Windows 11", "silver"));
    }

    // Method to filter laptops based on criteria
    public Set<Laptop> filterLaptops(Map<String, Object> criteria) {
        Set<Laptop> result = new HashSet<>(laptops);

        for (Map.Entry<String, Object> entry : criteria.entrySet()) {
            String criterion = entry.getKey();
            Object value = entry.getValue();

            result.removeIf(laptop -> {
                switch (criterion) {
                    case "RAM":
                        return laptop.getRamSize() < (int) value;
                    case "StorageSize":
                        return laptop.getStorageSize() < (int) value;
                    case "OperatingSystem":
                        return !laptop.getOperatingSystem().equalsIgnoreCase((String) value);
                    case "Color":
                        return !laptop.getColor().equalsIgnoreCase((String) value);
                    default:
                        return false;
                }
            });
        }

        return result;
    }

    public static void main(String[] args) {
        LaptopStore store = new LaptopStore();
        Scanner scanner = new Scanner(System.in);
    
        Map<String, Object> criteria = new HashMap<>();
    
        while (true) {
            System.out.println("Choose a filter criterion:");
            System.out.println("1. RAM");
            System.out.println("2. Storage size");
            System.out.println("3. Operating system");
            System.out.println("4. Color");
            System.out.println("5. Finish filtering");
    
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline
    
            if (choice == 5) {
                break;
            }
    
            switch (choice) {
                case 1:
                    System.out.print("Enter RAM size: ");
                    int ramSize = scanner.nextInt();
                    criteria.put("RAM", ramSize);
                    break;
                case 2:
                    System.out.print("Enter storage size: ");
                    int storageSize = scanner.nextInt();
                    criteria.put("StorageSize", storageSize);
                    break;
                case 3:
                    System.out.print("Enter operating system: ");
                    String operatingSystem = scanner.nextLine();
                    criteria.put("OperatingSystem", operatingSystem);
                    break;
                case 4:
                    System.out.print("Enter color: ");
                    String color = scanner.nextLine();
                    criteria.put("Color", color);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    
        // Filter laptops and print the result
        Set<Laptop> filteredResult = store.filterLaptops(criteria);
    
        System.out.println("Filtered Laptops:");
        for (Laptop laptop : filteredResult) {
            System.out.println(laptop);
        }
    
        // Close the scanner
        scanner.close();
    }
}
