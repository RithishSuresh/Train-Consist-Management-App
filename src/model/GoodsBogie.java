package model;

/**
 * Model class representing a Goods Bogie for Safety Compliance verification (UC12).
 */
public class GoodsBogie {
    private String type; // e.g., "Cylindrical"
    private String cargo; // e.g., "Petroleum"

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "GoodsBogie{type='" + type + "', cargo='" + cargo + "'}";
    }
}
