package model;

/**
 * Custom runtime exception for UC15 to handle unsafe cargo assignments.
 */
public class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}
