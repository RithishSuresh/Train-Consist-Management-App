package main;

import service.TrainService;

/**
 * Main application entry point for Train Consist Management App.
 * Sequentially executes Use Cases 1 to 5.
 */
public class Main {
    public static void main(String[] args) {
        TrainService trainService = new TrainService();
        
        // Sequentially execute UC1 to UC5
        trainService.executeUC1();
        trainService.executeUC2();
        trainService.executeUC3();
        trainService.executeUC4();
        trainService.executeUC5();

        trainService.executeUC6();
        trainService.executeUC7();
        trainService.executeUC8();
    }
}