package service;
import core.ConsistManager;
import java.util.ArrayList;
public class TrainService {
    private final ConsistManager consistManager = new ConsistManager();
    public void executeUC1() {
        System.out.println("--- UC1 OUTPUT ---");
        System.out.println("=== Train Consist Management App ===");
        ArrayList<String> bogies = consistManager.createArrayListConsist();
        System.out.println("Initial bogie count: " + bogies.size() + "\n");
    }
}