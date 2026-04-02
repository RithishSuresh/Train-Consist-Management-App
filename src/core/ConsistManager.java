package core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.LinkedHashSet;

/**
 * Core component to manage the initialization operations based on the Java Collections Framework.
 * Demonstrates the use of different Collections to solve specific data organization scenarios.
 */
public class ConsistManager {

    /**
     * Creates and returns an empty ArrayList.
     * ArrayList is used when we need a resizable array for fast random access and sequential ordering. (UC1, UC2)
     */
    public ArrayList<String> createArrayListConsist() {
        return new ArrayList<>();
    }

    /**
     * Creates and returns an empty HashSet.
     * HashSet is used when we need to ensure uniqueness of elements without caring about insertion order. (UC3)
     */
    public HashSet<String> createHashSetConsist() {
        return new HashSet<>();
    }

    /**
     * Creates and returns an empty LinkedList.
     * LinkedList is the best choice when there are frequent insertions and deletions at both ends or middle of a sequence. (UC4)
     */
    public LinkedList<String> createLinkedListConsist() {
        return new LinkedList<>();
    }

    /**
     * Creates and returns an empty LinkedHashSet.
     * LinkedHashSet is beneficial when we need both the unique characteristics of HashSet 
     * AND the predictable insertion-ordered characteristics of a LinkedList. (UC5)
     */
    public LinkedHashSet<String> createLinkedHashSetConsist() {
        return new LinkedHashSet<>();
    }
}