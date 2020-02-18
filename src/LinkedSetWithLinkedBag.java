import java.util.*;

/**
 * A class that implements the ADT set by using a linked bag.
 * The set is never full.
 *
 * @author Jamie Hernandez
 * @version 2/11/2020
 */
public class LinkedSetWithLinkedBag<T extends Comparable<? super T>> implements SetInterface<T> {
    private LinkedBag<T> setOfEntries;

    /**
     * Creates a set from a new, empty linked bag.
     */
    public LinkedSetWithLinkedBag() {
        //TODO Project1 - DONE
        this.setOfEntries = new LinkedBag<>();
    } // end default constructor

    public boolean add(T newEntry) {
        //TODO Project1 - DONE
        boolean success = false;
        if (newEntry != null && !this.setOfEntries.contains(newEntry)) {
            success = this.setOfEntries.add(newEntry);
            ;
        }
        return success;
    } // end add

    public T[] toArray() {
        //TODO Project1 - DONE
        return this.setOfEntries.toArray();
    } // end toArray

    public boolean isEmpty() {
        //TODO Project1 - DONE
        return this.setOfEntries.isEmpty();
    } // end isEmpty

    public boolean contains(T anEntry) {
        //TODO Project1 - DONE
        return this.setOfEntries.contains(anEntry);
    } // end contains

    public void clear() {
        //TODO Project1 - DONE
        this.setOfEntries.clear();
        System.out.println("The set is empty");
    } // end clear

    public T remove() {
        //TODO Project1 - DONE
        return this.setOfEntries.remove();
    } // end remove

    public boolean removeElement(T anEntry) {
        //TODO Project1 - DONE
        return this.setOfEntries.removeElement(anEntry);
    } // end remove

    // Displays a set.
    public void displaySet() {
        //TODO Project1 - DONE
        T[] tempArr = this.setOfEntries.toArray();
        if (!this.setOfEntries.isEmpty()) {
//            System.out.println("The set contains " + this.setOfEntries. + " element(s), as follows: ");
            for (int i = 0; i < tempArr.length; i++) {
                System.out.print(tempArr[i] + " ");
            }
        }
        System.out.println();
    } // end displaySet


    public static void main(String[] args) {
        String[] inputData = {"A", "B", "C", "D", "A", "C", "B", "B"};

        System.out.println("--> Creating set1 and adding to it elements from inputData: " + Arrays.toString(inputData));
        SetInterface<String> set1 = new LinkedSetWithLinkedBag<>();
        for (int i = 0; i < inputData.length; i++) {
            set1.add(inputData[i]);
        }
        System.out.println("--> Calling displaySet method to display elements in set1");
        set1.displaySet();
        System.out.println("--> Calling displaySet method to display elements in set1 one more time");
        set1.displaySet();

        System.out.println("\n--> Clearing set1");
        set1.clear();
        set1.displaySet();
        System.out.println("--> set1 isEmpty returns: " + set1.isEmpty());

        System.out.println("\n--> Creating set2 and set3");
        SetInterface<String> set2 = new LinkedSetWithLinkedBag<>();
        SetInterface<String> set3 = new LinkedSetWithLinkedBag<>();

        System.out.println("\n--> Adding elements to set2");
        set2.add("A");
        set2.add("A");
        set2.add("B");
        set2.add("A");
        set2.add("C");
        set2.add("A");
        System.out.println("--> set2 after adding elements");
        set2.displaySet();

        System.out.println("\n--> Adding elements to set3");
        set3.add("A");
        set3.add("B");
        set3.add("B");
        set3.add("A");
        set3.add("C");
        set3.add("C");
        set3.add("D");
        System.out.println("--> set3 after adding elements");
        set3.displaySet();

        System.out.println("\n--> set2 contains \"A\": " + set2.contains("A"));
        System.out.println("--> set2 contains \"E\": " + set2.contains("E"));

        System.out.println("\n--> Removing \"B\" from set2");
        set2.removeElement("B");
        System.out.println("--> After removing \"B\" from set2, ");
        set2.displaySet();

        System.out.println("\n--> Removing random element from set2");
        String removed = set2.remove();
        System.out.println("--> set2.remove() returned: \"" + removed + "\"");
        set2.displaySet();

        System.out.println("\n--> Removing \"A\" from set2");
        set2.removeElement("A");
        System.out.println("--> After removing \"A\" from set2, ");
        set2.displaySet();

        System.out.println("\n--> Removing random element from set2");
        removed = set2.remove();
        System.out.println("--> set2.remove() returned: \"" + removed + "\"");
        set2.displaySet();

        System.out.println("\n--> Adding 4 elements to set2");
        set2.add("K");
        set2.add("L");
        set2.add("M");
        set2.add("N");
        System.out.println("--> After adding 4 elements to set2:");
        set2.displaySet();

        System.out.println("\n--> Trying to add duplicate element \"N\" to set2");
        set2.add("N");
        System.out.println("--> After adding a duplicate element \"N\" to set2");
        set2.displaySet();

        System.out.println("\nTrying to add null entry");
        String nullEntry = null;
        set2.add(nullEntry);
        System.out.println("--> set2 after adding:");
        set2.displaySet();
    } // end main
} // end LinkedSetWithLinkedBag
