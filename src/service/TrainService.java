package service;

import core.ConsistManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.LinkedHashSet;

/**
 * Service class that handles business logic and execution of Use Cases 1 to 5.
 * It separates the logic from the Main class following Separation of Concerns.
 */
public class TrainService {

    private final ConsistManager consistManager;

    public TrainService() {
        this.consistManager = new ConsistManager();
    }

    /**
     * UC1: Initialize Train & Display Summary
     * Features: Prints greeting and initializes an empty ArrayList.
     */
    public void executeUC1() {
        System.out.println("--- UC1 OUTPUT ---");
        System.out.println("=== Train Consist Management App ===");
        
        // Initialize empty ArrayList<String> for bogies
        ArrayList<String> bogies = consistManager.createArrayListConsist();
        
        // Display initial bogie count using .size()
        System.out.println("Initial bogie count: " + bogies.size());
        System.out.println();
    }

    /**
     * UC2: Add Passenger Bogies (ArrayList)
     * Demonstrates dynamic resizing, appending elements, and removal by value in an ArrayList.
     */
    public void executeUC2() {
        System.out.println("--- UC2 OUTPUT ---");
        
        // Use ArrayList<String>
        ArrayList<String> bogies = consistManager.createArrayListConsist();
        
        // Add bogies
        addBogies(bogies, "Sleeper");
        addBogies(bogies, "AC Chair");
        addBogies(bogies, "First Class");
        
        // Display list
        System.out.println("Current Bogies: " + bogies);
        
        // Remove "AC Chair"
        removeBogie(bogies, "AC Chair");
        
        // Check contains("Sleeper")
        boolean hasSleeper = bogies.contains("Sleeper");
        System.out.println("Contains 'Sleeper'? " + hasSleeper);
        
        // Print final list
        displayConsist("Final Passenger Bogies (ArrayList)", bogies);
        System.out.println();
    }

    /**
     * UC3: Unique Bogie IDs (HashSet)
     * Demonstrates how a HashSet automatically resolves distinct objects. 
     */
    public void executeUC3() {
        System.out.println("--- UC3 OUTPUT ---");
        
        // Use HashSet<String>
        HashSet<String> uniqueBogies = consistManager.createHashSetConsist();
        
        System.out.println("Adding bogie IDs: B1, B2, B3, B1 (duplicate)");
        // Add bogie IDs
        uniqueBogies.add("B1");
        uniqueBogies.add("B2");
        uniqueBogies.add("B3");
        // A Set does not allow duplicates, so adding "B1" again prevents duplicate tracking
        boolean isAdded = uniqueBogies.add("B1"); // Duplicate
        
        // Show duplicates are ignored automatically
        System.out.println("Was duplicate 'B1' added? " + isAdded + " (Duplicates are ignored automatically)");
        
        // Print unique IDs
        displayConsist("Unique Bogie IDs (HashSet)", uniqueBogies);
        System.out.println();
    }

    /**
     * UC4: Ordered Train Consist (LinkedList)
     * Demonstrates how LinkedList offers efficient manipulations at arbitrary indices and ends.
     */
    public void executeUC4() {
        System.out.println("--- UC4 OUTPUT ---");
        
        // Use LinkedList<String>
        LinkedList<String> orderedConsist = consistManager.createLinkedListConsist();
        
        // Add: Engine, Sleeper, AC, Cargo, Guard
        orderedConsist.add("Engine");
        orderedConsist.add("Sleeper");
        orderedConsist.add("AC");
        orderedConsist.add("Cargo");
        orderedConsist.add("Guard");
        System.out.println("Initial Ordered Consist: " + orderedConsist);
        
        // Insert: Pantry Car at index 2
        orderedConsist.add(2, "Pantry Car");
        System.out.println("After inserting Pantry Car at index 2: " + orderedConsist);
        
        // Remove first bogie and last bogie
        String removedFirst = orderedConsist.removeFirst();
        String removedLast = orderedConsist.removeLast();
        System.out.println("Removed first bogie: " + removedFirst);
        System.out.println("Removed last bogie: " + removedLast);
        
        // Print final train order
        displayConsist("Final Train Order (LinkedList)", orderedConsist);
        System.out.println();
    }

    /**
     * UC5: Preserve Order + Uniqueness (LinkedHashSet)
     * Demonstrates holding elements while maintaining order without duplicates.
     */
    public void executeUC5() {
        System.out.println("--- UC5 OUTPUT ---");
        
        // Use LinkedHashSet<String>
        LinkedHashSet<String> orderedUniqueConsist = consistManager.createLinkedHashSetConsist();
        
        // Add: Engine, Sleeper, Cargo, Guard
        orderedUniqueConsist.add("Engine");
        orderedUniqueConsist.add("Sleeper");
        orderedUniqueConsist.add("Cargo");
        orderedUniqueConsist.add("Guard");
        
        System.out.println("Initial Ordered+Unique Consist: " + orderedUniqueConsist);
        
        // Try adding duplicate: Sleeper
        boolean isDuplicateAdded = orderedUniqueConsist.add("Sleeper");
        System.out.println("Tried adding duplicate 'Sleeper'. Was it added? " + isDuplicateAdded);
        
        // Print formation (ensure no duplicates, order preserved)
        displayConsist("Final Formation (LinkedHashSet)", orderedUniqueConsist);
        System.out.println();
    }

    // --- Reusable Methods ---

    /**
     * Reusable method to add bogies to an ArrayList collection.
     */
    public void addBogies(ArrayList<String> list, String bogie) {
        System.out.println("Adding: " + bogie);
        list.add(bogie);
    }

    /**
     * Reusable method to remove bogies.
     */
    public void removeBogie(ArrayList<String> list, String bogie) {
        System.out.println("Removing: " + bogie);
        list.remove(bogie);
    }

    /**
     * Displays any given consist collection using Iterable.
     */
    public void displayConsist(String heading, Iterable<String> consist) {
        System.out.println(heading + ": " + consist);
    }
}