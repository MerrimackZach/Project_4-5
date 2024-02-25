import java.util.*;

/**
 * This class reads a list of Integer numbers from the scanned input and saves them into a Linked List sorted from the smallest to the largest.
 */
public class SortedLinkedList {

    /**
     * Default constructor for the SortedLinkedList class.
     */
    public SortedLinkedList() {
        // Default constructor is empty
    }
    /**
     * Main method that reads input from command line arguments and prints the sorted linked list.
     * @param args Command line arguments containing integer numbers.
     */
    public static void main(String[] args) {
        LinkedList<Integer> sortedList = new LinkedList<>();
        
        // Reading input from command line arguments
        for (String arg : args) {
            try {
                int num = Integer.parseInt(arg);
                insertIntoSortedList(sortedList, num);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + arg);
            }
        }
        
        // Print the sorted list
        System.out.println("Sorted Linked List: " + sortedList);
    }
    
    /**
     * Inserts a number into a sorted LinkedList.
     * @param list The sorted LinkedList to insert into.
     * @param num The number to insert.
     */
    private static void insertIntoSortedList(LinkedList<Integer> list, int num) {
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (num < iterator.next()) {
                iterator.previous();
                iterator.add(num);
                return;
            }
        }
        iterator.add(num);
    }
}
