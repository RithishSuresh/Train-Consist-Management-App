package main;
import service.TrainService;
public class Main {
    public static void main(String[] args) {
        TrainService trainService = new TrainService();
        trainService.executeUC1();
        trainService.executeUC2();
        trainService.executeUC3();
    }
}