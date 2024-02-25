import java.util.*;

/**
 * This class represents a utility for sorting a list of Integer numbers from the scanned input
 * and saving them into a Stack sorted from smallest to largest.
 * **Changes made:**
 * - Renamed the class from SortedLinkedList to SortedStack to reflect the use of a Stack DS.
 * - Changed the data structure from LinkedList to Stack for sorting integers in ascending order.
 * - Updated the main method to use a Stack Integer and to call the appropriate methods for sorting and printing.
 * - Changed the insertion method to use a stack-based approach for sorting.
 */
public class SortedStack {

    /**
     * Default constructor for the SortedStack class.
     * Constructs a new SortedStack instance.
     */
    public SortedStack() {
        // Default constructor is empty
    }

    /**
     * Main method that reads input from command line arguments and prints the sorted stack.
     * @param args Command line arguments containing integer numbers.
     */
    public static void main(String[] args) {
        Stack<Integer> sortedStack = new Stack<>();

        // Reading input from command line arguments
        for (String arg : args) {
            try {
                int num = Integer.parseInt(arg);
                insertIntoSortedStack(sortedStack, num);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + arg);
            }
        }

        // Pop off each value into a new stack to reverse and sort
        Stack<Integer> reversedSortedStack = new Stack<>();
        while (!sortedStack.isEmpty()) {
            reversedSortedStack.push(sortedStack.pop());
        }

        // Print the reversed and sorted stack
        System.out.print("Sorted Stack: [");
        while (!reversedSortedStack.isEmpty()) {
            System.out.print(reversedSortedStack.pop());
            if (!reversedSortedStack.isEmpty()) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * Inserts a number into a sorted Stack.(LIFO)
     * @param stack The sorted Stack to insert into.
     * @param num The number to insert.
     */
    private static void insertIntoSortedStack(Stack<Integer> stack, int num) {
        Stack<Integer> tempStack = new Stack<>();

        // push elements from stack into tempStack until num is greater than top element
        while (!stack.isEmpty() && stack.peek() > num) {
            tempStack.push(stack.pop());
        }

        // Push numbers into the stack
        stack.push(num);

        // Push elements back from tempStack to stack while maintaining sorted order
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
}
