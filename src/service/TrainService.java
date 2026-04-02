package service;
import core.ConsistManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
public class TrainService {
    private final ConsistManager consistManager = new ConsistManager();
    public void executeUC1() {
        System.out.println("--- UC1 OUTPUT ---");
        System.out.println("=== Train Consist Management App ===");
        ArrayList<String> bogies = consistManager.createArrayListConsist();
        System.out.println("Initial bogie count: " + bogies.size() + "\n");
    }
    public void executeUC2() {
        System.out.println("--- UC2 OUTPUT ---");
        ArrayList<String> bogies = consistManager.createArrayListConsist();
        addBogies(bogies, "Sleeper"); addBogies(bogies, "AC Chair"); addBogies(bogies, "First Class");
        System.out.println("Current Bogies: " + bogies);
        removeBogie(bogies, "AC Chair");
        System.out.println("Contains 'Sleeper'? " + bogies.contains("Sleeper"));
        displayConsist("Final Passenger Bogies (ArrayList)", bogies);
        System.out.println();
    }
    public void executeUC3() {
        System.out.println("--- UC3 OUTPUT ---");
        HashSet<String> uniqueBogies = consistManager.createHashSetConsist();
        System.out.println("Adding bogie IDs: B1, B2, B3, B1 (duplicate)");
        uniqueBogies.add("B1"); uniqueBogies.add("B2"); uniqueBogies.add("B3");
        boolean isAdded = uniqueBogies.add("B1");
        System.out.println("Was duplicate 'B1' added? " + isAdded + " (Duplicates are ignored automatically)");
        displayConsist("Unique Bogie IDs (HashSet)", uniqueBogies);
        System.out.println();
    }
    public void executeUC4() {
        System.out.println("--- UC4 OUTPUT ---");
        LinkedList<String> orderedConsist = consistManager.createLinkedListConsist();
        orderedConsist.add("Engine"); orderedConsist.add("Sleeper"); orderedConsist.add("AC"); orderedConsist.add("Cargo"); orderedConsist.add("Guard");
        System.out.println("Initial Ordered Consist: " + orderedConsist);
        orderedConsist.add(2, "Pantry Car");
        System.out.println("After inserting Pantry Car at index 2: " + orderedConsist);
        System.out.println("Removed first bogie: " + orderedConsist.removeFirst());
        System.out.println("Removed last bogie: " + orderedConsist.removeLast());
        displayConsist("Final Train Order (LinkedList)", orderedConsist);
        System.out.println();
    }
    public void addBogies(ArrayList<String> list, String bogie) { System.out.println("Adding: " + bogie); list.add(bogie); }
    public void removeBogie(ArrayList<String> list, String bogie) { System.out.println("Removing: " + bogie); list.remove(bogie); }
    public void displayConsist(String heading, Iterable<String> consist) { System.out.println(heading + ": " + consist); }
}