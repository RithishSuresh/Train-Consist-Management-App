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

        // Sequentially execute UC6 to UC12
        trainService.executeUC6();
        trainService.executeUC7();
        trainService.executeUC8();
        trainService.executeUC9();
        trainService.executeUC10();
        trainService.executeUC11();
        trainService.executeUC12();

        // Sequentially execute UC13 to UC20
        trainService.comparePerformance();
        trainService.createValidatedBogie();
        trainService.assignCargoSafely();
        trainService.bubbleSortCapacities();
        trainService.sortBogieNames();
        trainService.linearSearchBogie();
    }
}