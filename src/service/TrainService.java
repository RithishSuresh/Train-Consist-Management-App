package service;

import core.ConsistManager;
import model.Bogie;
import model.GoodsBogie;
import model.InvalidCapacityException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

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
    public void displayConsist(String heading, Iterable<?> consist) {
        System.out.println(heading + ": " + consist);
    }

    // --- NEW USE CASES (UC6 - UC12) ---

    /**
     * UC6: Map Bogie to Capacity (HashMap)
     */
    public void executeUC6() {
        System.out.println("--- UC6 OUTPUT ---");
        Map<String, Integer> capacities = new HashMap<>();
        capacities.put("Sleeper", 72);
        capacities.put("AC Chair", 60);
        capacities.put("First Class", 40);

        System.out.println("Bogie Capacities:");
        for (Map.Entry<String, Integer> entry : capacities.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();
    }

    /**
     * UC7: Sort Bogies by Capacity (Comparator)
     */
    public void executeUC7() {
        System.out.println("--- UC7 OUTPUT ---");
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(createSafeBogie("B1", 72, "Passenger"));
        bogies.add(createSafeBogie("B2", 40, "Passenger"));
        bogies.add(createSafeBogie("B3", 60, "Passenger"));

        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("Bogies Sorted by Capacity:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }
        System.out.println();
    }

    /**
     * UC8: Filter Bogies Using Streams
     */
    public void executeUC8() {
        System.out.println("--- UC8 OUTPUT ---");
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(createSafeBogie("B1", 72, "Passenger"));
        bogies.add(createSafeBogie("B2", 40, "Passenger"));
        bogies.add(createSafeBogie("B3", 60, "Passenger"));

        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        System.out.println("Bogies with capacity > 60:");
        filteredBogies.forEach(System.out::println);
        System.out.println();
    }

    /**
     * UC9: Group Bogies by Type
     */
    public void executeUC9() {
        System.out.println("--- UC9 OUTPUT ---");
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(createSafeBogie("B1", 72, "Passenger"));
        bogies.add(createSafeBogie("C1", 100, "Cargo"));
        bogies.add(createSafeBogie("B2", 60, "Passenger"));

        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        System.out.println("Bogies Grouped by Type:");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("Type: " + entry.getKey());
            entry.getValue().forEach(b -> System.out.println("  " + b));
        }
        System.out.println();
    }

    /**
     * UC10: Total Seat Calculation (reduce)
     */
    public void executeUC10() {
        System.out.println("--- UC10 OUTPUT ---");
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(createSafeBogie("B1", 72, "Passenger"));
        bogies.add(createSafeBogie("B2", 40, "Passenger"));
        bogies.add(createSafeBogie("B3", 60, "Passenger"));

        int totalSeats = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        System.out.println("Total seating capacity: " + totalSeats);
        System.out.println();
    }

    /**
     * UC11: Regex Validation
     */
    public void executeUC11() {
        System.out.println("--- UC11 OUTPUT ---");
        Pattern trainIdPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoCodePattern = Pattern.compile("PET-[A-Z]{2}");

        String[] testStrings = {"TRN-1234", "TRN-123", "PET-AB", "PET-A"};

        System.out.println("Regex Validation Results:");
        for (String test : testStrings) {
            boolean isTrainIdValid = trainIdPattern.matcher(test).matches();
            boolean isCargoCodeValid = cargoCodePattern.matcher(test).matches();
            
            if (isTrainIdValid) {
                System.out.println(test + " -> Valid Train ID");
            } else if (isCargoCodeValid) {
                System.out.println(test + " -> Valid Cargo Code");
            } else {
                System.out.println(test + " -> Invalid Format");
            }
        }
        System.out.println();
    }

    /**
     * UC12: Safety Compliance Check
     */
    public void executeUC12() {
        System.out.println("--- UC12 OUTPUT ---");
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Box", "Coal"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));

        boolean isSafe = goodsBogies.stream()
                .allMatch(b -> {
                    if ("Cylindrical".equals(b.getType())) {
                        return "Petroleum".equals(b.getCargo());
                    }
                    return true;
                });

        System.out.println("Safety Compliance Check: " + (isSafe ? "Safe" : "Not Safe"));
        System.out.println();
    }
    /**
     * UC13: Performance Comparison (Loops vs Streams)
     */
    public void comparePerformance() {
        System.out.println("--- UC13 OUTPUT ---");
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
        try {
            bogies.add(new Bogie("B" + i, (i % 100) + 1, "Passenger"));
        } catch (InvalidCapacityException e) {
            // Ignored for performance setup
        }
        }

        // Loop
        long startLoop = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 50) {
                loopFiltered.add(b);
            }
        }
        long loopTime = System.nanoTime() - startLoop;

        // Stream
        long startStream = System.nanoTime();
        List<Bogie> streamFiltered = bogies.stream()
                .filter(b -> b.getCapacity() > 50)
                .collect(Collectors.toList());
        long streamTime = System.nanoTime() - startStream;

        System.out.println("Loop execution time: " + loopTime + " ns");
        System.out.println("Stream execution time: " + streamTime + " ns");
        System.out.println();
    }

    /**
     * Helper to safely construct a bogie without throwing checked exceptions constantly.
     */
    private Bogie createSafeBogie(String name, int capacity, String type) {
        try {
            return new Bogie(name, capacity, type);
        } catch (InvalidCapacityException e) {
            System.err.println("Failed to create safe bogie: " + e.getMessage());
            return null;
        }
    }

    /**
     * UC14: Custom Exception for Invalid Capacity
     */
    public void createValidatedBogie() {
        System.out.println("--- UC14 OUTPUT ---");
        try {
            System.out.println("Attempting to create a bogie with capacity -10...");
            Bogie b = new Bogie("Invalid", -10, "Passenger");
        } catch (InvalidCapacityException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        System.out.println();
    }

    /**
     * UC15: Safe Cargo Assignment
     */
    public void assignCargoSafely() {
        System.out.println("--- UC15 OUTPUT ---");
        try {
            System.out.println("Assigning Petroleum to a Rectangular bogie...");
            String bogieShape = "Rectangular";
            String cargoType = "Petroleum";
            
            if ("Rectangular".equals(bogieShape) && "Petroleum".equals(cargoType)) {
                throw new model.CargoSafetyException("Safety Violation: Rectangular bogie cannot carry Petroleum!");
            }
            System.out.println("Cargo assigned successfully.");
        } catch (model.CargoSafetyException e) {
            System.out.println("Error message: " + e.getMessage());
        } finally {
            System.out.println("Finally block: Cargo safety check completed.");
        }
        System.out.println();
    }

    /**
     * UC16: Bubble Sort Implementation
     */
    public void bubbleSortCapacities() {
        System.out.println("--- UC16 OUTPUT ---");
        int[] capacities = {80, 40, 100, 60, 20};
        System.out.print("Before Bubble Sort: ");
        for (int c : capacities) System.out.print(c + " ");
        System.out.println();

        for (int i = 0; i < capacities.length - 1; i++) {
            for (int j = 0; j < capacities.length - i - 1; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }

        System.out.print("After Bubble Sort: ");
        for (int c : capacities) System.out.print(c + " ");
        System.out.println("\n");
    }
}