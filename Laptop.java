package Java_test;
public class Laptop {
    private String model;
    private int ramSize;
    private int storageSize;
    private String operatingSystem;
    private String color;

    // Constructor
    public Laptop(String model, int ramSize, int storageSize, String operatingSystem, String color) {
        this.model = model;
        this.ramSize = ramSize;
        this.storageSize = storageSize;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    // Getters

    public String getModel() {
        return model;
    }

    public int getRamSize() {
        return ramSize;
    }

    public int getStorageSize() {
        return storageSize;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "model='" + model + '\'' +
                ", ramSize=" + ramSize +
                ", storageSize=" + storageSize +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
