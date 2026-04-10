package model;

/**
 * Model class representing a Bogie (UC7, UC8, UC9).
 */
public class Bogie {
    private String name;
    private int capacity;
    private String type; // Passenger or Cargo

    public Bogie(String name, int capacity, String type) {
        this.name = name;
        this.capacity = capacity;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Bogie{name='" + name + "', capacity=" + capacity + ", type='" + type + "'}";
    }
}
