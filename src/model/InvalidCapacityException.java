package model;

/**
 * Custom exception for UC14 to handle invalid bogie capacities.
 */
public class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}
