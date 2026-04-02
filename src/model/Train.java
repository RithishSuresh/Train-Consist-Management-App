package model;

/**
 * Model class representing a basic Train.
 * This class follows standard Object-Oriented Programming (OOP) principles by encapsulating state.
 */
public class Train {
    private String trainNumber;
    private String trainName;

    /**
     * Constructor for initialization
     * @param trainNumber The train's unique identifier
     * @param trainName The name of the train
     */
    public Train(String trainNumber, String trainName) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
    }

    // Getters and Setters

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainNumber='" + trainNumber + '\'' +
                ", trainName='" + trainName + '\'' +
                '}';
    }
}