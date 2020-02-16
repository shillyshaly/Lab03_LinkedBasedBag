import java.awt.image.BandCombineOp;import java.util.*;/** * A class that implements the ADT set by using a chain of linked nodes. * The set is never full. * * @author Jamie Hernandez * @version 2/11/2020 */public class LinkedSetWithChainOfNodes<T extends Comparable<? super T>> implements SetInterface<T>{    private Node<T> firstNode;            // Head reference to first node    public LinkedSetWithChainOfNodes()    {        //TODO Project2 - DONE        this.firstNode = null;    } // end default constructor    public void clear()    {        //TODO Project2 - DONE        while (!isEmpty()){            remove();        }    } // end clear    public boolean add(T newEntry)    {        //TODO Project2 - DONE        Node<T> newNode = new Node<>(newEntry);        newNode.next = this.firstNode;        this.firstNode = newNode;        return true;    } // end add    /**     * Locates a given entry within this set.     * Returns a reference to the node containing the entry, if located,     * or null otherwise.     *     * Utilized by removeElement method     */    private Node<T> getReferenceTo(T anEntry)    {        //TODO Project2 - DONE        boolean found = false;        Node<T> currentNode = this.firstNode;        while (!found && (currentNode != null)){            if ((anEntry.equals(currentNode.data))){                found = true;            }else {                currentNode = currentNode.next;            }        }        return currentNode;    } // end getReferenceTo    public boolean removeElement(T anEntry)    {        //TODO Project2 - DONE        boolean result = false;        Node<T> node = getReferenceTo(anEntry);        if (node != null){            node.data = this.firstNode.data;            this.firstNode = this.firstNode.next;            result = true;        }        return result;    } // end remove    public T remove()    {        //TODO Project2 - DONE        T result = null;        if (this.firstNode != null){            result = this.firstNode.data;            this.firstNode = this.firstNode.next;        }        return result;    } // end remove    public boolean contains(T anEntry)    {        //TODO Project2 - DONE        return getReferenceTo(anEntry) != null;    } // end contains    public boolean isEmpty()    {        //TODO Project2 - DONE        return this.firstNode == null;    } // end getLength    public T[] toArray()    {        //TODO Project2 - DONE        int counter = 0;        Node<T> currentNode = this.firstNode;        while (currentNode != null){            counter++;            currentNode = currentNode.next;        }        T[] result = (T[]) new Comparable<?>[counter];        int index = 0;        currentNode = this.firstNode;        while ((index < result.length) && (currentNode != null)){            result[index] = currentNode.data;            index++;            currentNode = currentNode.next;        }        return result;    } // end toArray    // ****** IMPLEMENT THE FOLLOWING METHODS NOT DEFINED IN THE SetInterface ********    /**     * Displays all elements in the set;     * if the set is empty displays appropriate message     * if the set is not empty displays the elements and the number of elements     */    public void displaySet()    {        // TODO Project2 - DONE        Node<T> currentNode = this.firstNode;        int counter = 0;        System.out.println("The set contain the following element(s): ");        while (currentNode != null){            System.out.print(currentNode.data + " ");            currentNode = currentNode.next;            counter++;        }        System.out.printf("- The number of elements is " + counter);        System.out.println();    } // end displaySet    /**     * Checks if the given set called other is the same as the set     *     * @param o the other set to be compared with     * @return true both sets are the same     */    public boolean equals(Object o)    {        // TODO Project2 - DONE        // one return statement per value returning method please        boolean same;        if (this == o){            same = true;        }else if (o == null || getClass() != o.getClass()){            same = false;        }else {            LinkedSetWithChainOfNodes<T> other = (LinkedSetWithChainOfNodes<T>) o;            Node<T> otherCurrent = other.firstNode;            Node<T> thisCurrent = this.firstNode;            same = true;            while(thisCurrent != null && otherCurrent != null && same){                if (!thisCurrent.data.equals(otherCurrent.data)){                    same = false;                }                thisCurrent = thisCurrent.next;                otherCurrent = otherCurrent.next;            }            if ((thisCurrent == null && otherCurrent != null) || (thisCurrent != null && otherCurrent == null)){                same = false;            }        }        return same;    }    /**     * Gets the largest value in this set.     *     * @returns a reference to the largest object, or null if the set is empty     */    public T getMax()    {        // TODO Project2 - DONE        // one return statement per value returning method please        T largestValue = null;        Node<T> currentNode = this.firstNode;        if (currentNode == null){            System.out.println("The set is empty");        }else {            largestValue = currentNode.data;            while (currentNode != null){                if (largestValue.compareTo(currentNode.data) < 0) {                    largestValue = currentNode.data;                }                currentNode = currentNode.next;            }        }        return largestValue;    } // end getMax    /**     * Removes and returns the smallest element in the set     *     * @return - null if the element was not found or the smallest element     */    public T removeMin()    {        // TODO Project2 - need to test        T smallestValue = null;        // one return statement per value returning method please        // the method must traverse the data with a while loop to find the smallest element        // outside the loop should replace the found entry with the entry located in the firstNode and call remove()        // TODO Project2 - the code in main written to test removeMin method is currently commented out        //      uncomment it when ready for testing - DONE//        Node<T> currentNode = this.firstNode;////        if (currentNode == null){//            System.out.println("The set is empty");//        }else {//            smallestValue = currentNode.data;//            while (currentNode != null){//                if (smallestValue.compareTo(currentNode.data) > 0){//                    smallestValue = currentNode.data;//                }//                currentNode = currentNode.next;//            }//            firstNode = currentNode.next;//            firstNode.next = firstNode;//            remove();//        }        return smallestValue;    }    /**     * Removes from this set all entries that are larger than a given entry.     *     * @param anEntry the entry to be removed     */    public void removeAllLarger(T anEntry)    {        // TODO Project2 - debugging        // For efficiency it traverses the data and removes entries by changing pointers as needed        //     without calling any other method        Node<T> currentNode = this.firstNode;        Node<T> prevNode = this.firstNode;        if (currentNode == null){            System.out.println("The set is empty");        }else {            while (currentNode != null){                if (anEntry.compareTo(currentNode.data) <= 0){                    if (currentNode.next == null){                        currentNode = null;                    }else {                        currentNode = currentNode.next;                    }                    prevNode.next = currentNode;                }else {                    prevNode = prevNode.next;                    currentNode = currentNode.next;                }            }        }    } // end removeAllLarger    /**     * Creates a new set that combines the contents of this set and a     * second given set without affecting the original two sets.     *     * @param otherSet the given set     * @return a set that is the union of the two sets     */    public LinkedSetWithChainOfNodes<T> union(LinkedSetWithChainOfNodes<T> otherSet)    {        LinkedSetWithChainOfNodes<T> unionSet = new LinkedSetWithChainOfNodes<>();        // TODO Project2 - DONE        // one return statement per value returning method please        Node<T> thisCurrent = this.firstNode;        Node<T> otherCurrent = otherSet.firstNode;        while (thisCurrent != null){            if (!unionSet.contains(thisCurrent.data)){                unionSet.add(thisCurrent.data);            }            thisCurrent = thisCurrent.next;        }        while (otherCurrent != null){            if (!unionSet.contains(otherCurrent.data)){                unionSet.add(otherCurrent.data);            }            otherCurrent = otherCurrent.next;        }        return unionSet;    } // end union    /**     * Creates a new set that contains those objects that occur in both this     * set and a second given set without affecting the original two sets.     *     * @param otherSet the given set     * @return a set that is the intersection of the two sets     */    public LinkedSetWithChainOfNodes<T> intersection(LinkedSetWithChainOfNodes<T> otherSet)    {        LinkedSetWithChainOfNodes<T> intersectionSet = new LinkedSetWithChainOfNodes<>();        // TODO Project2 - DONE        // one return statement per value returning method please        // call getReferenceTo(anElement) instead of contains        Node<T> otherCurrent = otherSet.firstNode;        while (otherCurrent != null){            if (getReferenceTo(otherCurrent.data) != null){                intersectionSet.add(otherCurrent.data);            }            otherCurrent = otherCurrent.next;        }        return intersectionSet;    } // end intersection    /**     * Creates a new set of objects that would be left in this set     * after removing those that also occur in a second given set     * without affecting the original two sets.     *     * @param otherSet the given set     * @return a set that is the difference of the two sets     */    public LinkedSetWithChainOfNodes<T> difference(LinkedSetWithChainOfNodes<T> otherSet)    {        LinkedSetWithChainOfNodes<T> differenceSet = new LinkedSetWithChainOfNodes<>();        // TODO Project2 - DONE        // one return statement per value returning method please        // call getReferenceTo(anElement) instead of contains        Node<T> otherCurrent = otherSet.firstNode;        while (otherCurrent != null){            if (getReferenceTo(otherCurrent.data) == null){                differenceSet.add(otherCurrent.data);            }            otherCurrent = otherCurrent.next;        }        return differenceSet;    } // end difference    public void moveFirstToEnd()    {        //TODO Project2 - in progress        // this method should run only if the chain has at least two nodes        // do not create a new Node object (i.e. new Node<>()), just utilize        // reference variables (i.e. Node<T> someNode) to change appropriate pointers        // method DOES NOT rely on the number of elements        Node<T> currentNode = this.firstNode;        Node<T> tail = this.firstNode;        while (currentNode != null){            if (currentNode.next == null){                tail = currentNode;            }            currentNode = currentNode.next;        }        currentNode = this.firstNode;        tail.next = currentNode;        currentNode.next = null;    } // end moveToEnd    /**     * Replaces the first entry in this set with a given object.     *     * @param replacement the given object     * @return the original entry in the set that was replaced or     *         null if empty chain or a duplicate     */    public T replace(T replacement)    {        //TODO Project2        // change the data at the first node if appropriate        return null; // THIS IS A STUB    } // end replace    /**     * This method find the data in the middle node in one pass     *     * @return returns tha data in the middle node     */    public T findMiddleElementInOnePass()    {        // TODO Project2        // uses two pointers - DOES NOT rely on the number of elements        return null; // THIS IS A STUB    }    /**     * Check if the linked list has loop in one pass     *     * @return returns true as soon as the first loop is found     */    public boolean checkIfLoopExists()    {        // TODO Project2        // uses two pointers - DOES NOT rely on the number of elements        return false; // THIS IS A STUB    }    /**     * This method is created to test loop detection     */    private void createALoop()    {        // starting with a chain: A-> B-> C-> D-> E-> F-> G-> H-> I-> null        Node<T> last = this.firstNode;        while (last.next != null)            last = last.next;        last.next = this.firstNode.next.next.next;        // hardcoded a loop in the chain: A-> B-> C-> D-> E-> F-> G-> H-> I-> D    }    // A class of nodes for a chain of linked nodes.    private class Node<S>    {        private S data; // Data portion        private Node next; // Link to next node        private Node(S dataPortion)        {            this(dataPortion, null);        } // end constructor        private Node(S dataPortion, Node nextNode)        {            this.data = dataPortion;            this.next = nextNode;        } // end constructor    } // end Node    public static void main(String[] args)    {        String[] inputData = {"A", "B", "C", "D", "A", "C", "B", "B"};        System.out.println("\n\u001B[35m\u001B[1mRUNNING TEST CASES FOR METHODS DEFINED IN SetInterface plus displaySet\u001B[0m");        System.out.println("--> Creating aSet and adding to it elements from inputData: " + Arrays.toString(inputData));        SetInterface<String> aSet = new LinkedSetWithChainOfNodes<>();        for (int i=0; i < inputData.length; i++)        {            aSet.add(inputData[i]);        }        System.out.println("--> Calling displaySet method to display elements in aSet");        aSet.displaySet();        System.out.println("--> Calling displaySet method to display elements in aSet one more time");        aSet.displaySet();        System.out.println("\n--> Clearing aSet");        aSet.clear();        aSet.displaySet();        System.out.println("--> aSet isEmpty returns: " + aSet.isEmpty());        System.out.println("\n--> Creating set1 and set2");        SetInterface<String> set1 = new LinkedSetWithChainOfNodes<>();        SetInterface<String> set2 = new LinkedSetWithChainOfNodes<>();        System.out.println("\n--> Adding elements to set1");        set1.add("A");        set1.add("A");        set1.add("B");        set1.add("A");        set1.add("C");        set1.add("Z");        set1.add("A");        System.out.println("--> set1 after adding elements");        set1.displaySet();        System.out.println("\n--> Adding elements to set2");        set2.add("A");        set2.add("B");        set2.add("B");        set2.add("A");        set2.add("C");        set2.add("C");        set2.add("Z");        set2.add("D");        System.out.println("--> set2 after adding elements");        set2.displaySet();        System.out.println("\n--> set1 contains \"A\": " + set1.contains("A"));        System.out.println("--> set1 contains \"E\": " + set1.contains("E"));        System.out.println("\n--> Removing \"B\" from set1");        set1.removeElement("B");        System.out.println("--> After removing \"B\" from set1, ");        set1.displaySet();        System.out.println("\n--> Removing random element from set1");        String removed = set1.remove();        System.out.println("--> set1.remove() returned: \"" + removed + "\"");        set1.displaySet();        System.out.println("\n--> Removing \"A\" from set1");        set1.removeElement("A");        System.out.println("--> After removing \"A\" from set1, ");        set1.displaySet();        System.out.println("\n--> Removing random element from set1");        removed = set1.remove();        System.out.println("--> set1.remove() returned: \"" + removed + "\"");        set1.displaySet();        System.out.println("\n--> Adding 4 elements to set1");        set1.add("K");        set1.add("L");        set1.add("M");        set1.add("N");        System.out.println("--> After adding 4 elements to set1:");        set1.displaySet();        System.out.println("\n--> Trying to add duplicate element \"N\" to set1");        set1.add("N");        System.out.println("--> After adding a duplicate element \"N\" to set1");        set1.displaySet();        System.out.println("\nTrying to add null entry");        String nullEntry = null;        set1.add(nullEntry);        System.out.println("--> set1 after adding:");        set1.displaySet();        System.out.println("\n--> Testing toArray");        Object[] setArray = set1.toArray();        System.out.print("The set contains " + setArray.length +                " element(s), as follows: ");        for (int index = 0; index < setArray.length; index++)        {            System.out.print(setArray[index] + " ");        }        System.out.println();        System.out.println("\n\u001B[35m\u001B[1mRUNNING TEST CASES FOR METHODS NOT DEFINED IN SetInterface\u001B[0m");        LinkedSetWithChainOfNodes<String> set3 = new LinkedSetWithChainOfNodes<>();        LinkedSetWithChainOfNodes<String> set3Plus1 = new LinkedSetWithChainOfNodes<>();        LinkedSetWithChainOfNodes<String> set4 = new LinkedSetWithChainOfNodes<>();        LinkedSetWithChainOfNodes<String> set5 = new LinkedSetWithChainOfNodes<>();        LinkedSetWithChainOfNodes<String> testSet = new LinkedSetWithChainOfNodes<>();        LinkedSetWithChainOfNodes<String> emptySet = new LinkedSetWithChainOfNodes<>();        LinkedSetWithChainOfNodes<String> setCopyOfSet3 = new LinkedSetWithChainOfNodes<>();        set3Plus1.add("Z");        set3.add("C");        set3Plus1.add("C");        setCopyOfSet3.add("C");        set3.add("B");        set3Plus1.add("B");        setCopyOfSet3.add("B");        set3.add("D");        set3Plus1.add("D");        setCopyOfSet3.add("D");        set3.add("A");        set3Plus1.add("A");        setCopyOfSet3.add("A");        set3.add("X");        set3Plus1.add("X");        setCopyOfSet3.add("X");        // testing equals        System.out.println("\n\u001B[35m\u001B[1m***Testing equals method***\u001B[0m");        System.out.println("set3:");        set3.displaySet();        System.out.println("Are set3 and emptySet equal? --> " + (set3.equals(emptySet) ? "YES" : "NO"));        System.out.println("Are emptySet and emptySet equal? --> " + (emptySet.equals(emptySet) ? "YES" : "NO"));        System.out.println("Are emptySet and set3 equal? --> " + (emptySet.equals(set3) ? "YES" : "NO"));        set4.add("A");        set4.add("B");        set4.add("D");        set4.add("C");        set4.add("X");        set4.add("Z");        System.out.println("\nset4:");        set4.displaySet();        System.out.println("Are set3 and set4 equal? --> " + (set3.equals(set4) ? "YES" : "NO"));        System.out.println("\nRemoved \"" + set4.remove() + "\" from set4.");        set4.displaySet();        System.out.println("Are set3 and set4 equal now? --> " + (set3.equals(set4) ? "YES" : "NO"));        System.out.println("\nsetCopyOfSet3:");        setCopyOfSet3.displaySet();        System.out.println("Are set3 and setCopyOfSet3 equal? --> " + (set3.equals(setCopyOfSet3) ? "YES" : "NO"));        System.out.println("\nset3Plus1:");        set3Plus1.displaySet();        System.out.println("Are set3 and set3Plus1 equal? --> " + (set3.equals(set3Plus1) ? "YES" : "NO"));        // testing getMax        System.out.println("\n\u001B[35m\u001B[1m***Testing getMax method***\u001B[0m");        System.out.println("The largest item in emptySet is: " + emptySet.getMax());        set3.clear();        set3.add("D");        set3.add("X");        set3.add("A");        set3.add("C");        System.out.println("\nset3: ");        set3.displaySet();        System.out.println("The largest item in set3 is: " + set3.getMax());        set4.clear();        set4.add("B");        set4.add("A");        set4.add("C");        set4.add("Z");        System.out.println("\nset4: ");        set4.displaySet();        System.out.println("The largest item in set4 is: " + set4.getMax());        set5.add("Y");        set5.add("A");        set5.add("C");        set5.add("B");        System.out.println("\nset5: ");        set5.displaySet();        System.out.println("The largest item in set5 is: " + set5.getMax());        System.out.println("\n\u001B[35m\u001B[1m***Testing union, removeMin, intersection, difference and subset methods***\u001B[0m");        System.out.println("set3: ");        set3.displaySet();        System.out.println("set4: ");        set4.displaySet();        // testing union        System.out.println("\n\u001B[35m\u001B[1m***Testing union method***\u001B[0m");        LinkedSetWithChainOfNodes<String> everything = set3.union(set4);        System.out.println("The union of set3 and set4 is ");        everything.displaySet();        everything = set3.union(emptySet);        System.out.println("\nThe union of set3 and emptySet is ");        everything.displaySet();        everything = emptySet.union(set3);        System.out.println("\nThe union of emptySet and set3 is ");        everything.displaySet();        // testing removeMin        System.out.println("\n\u001B[35m\u001B[1m***Testing removeMin method***\u001B[0m");        String smallest;        // TODO - uncomment the following lines to test removeMin        //      the following 12 lines are commented out for now to avoid an infinite loop//        while (!everything.isEmpty())//        {//            smallest = everything.removeMin();//            System.out.println("Removed the smallest element \"" + smallest + "\" from the union set; the current content is:");//            everything.displaySet();//        }////        smallest = everything.removeMin();//        if (smallest == null)//            System.out.println("\nThe union set is empty and removeMin returned null - CORRECT");//        else//            System.out.println("\nThe union set is empty but removeMin did not return null - INCORRECT");        // testing intersection        System.out.println("\n\u001B[35m\u001B[1m***Testing intersection method***\u001B[0m");        LinkedSetWithChainOfNodes<String> commonItems = set3.intersection(set4);        System.out.println("The intersection of set3 and set4 is ");        commonItems.displaySet();        commonItems = set3.intersection(emptySet);        System.out.println("\nThe intersection of set3 and emptySet is ");        commonItems.displaySet();        commonItems = emptySet.intersection(set3);        System.out.println("\nThe intersection of emptySet and set3 is ");        commonItems.displaySet();        // testing difference        System.out.println("\n\u001B[35m\u001B[1m***Testing difference method***\u001B[0m");        LinkedSetWithChainOfNodes<String> leftOver = set3.difference(set4);        System.out.println("The difference of set3 and set4 is ");        leftOver.displaySet();        leftOver = set4.difference(set3);        System.out.println("\nThe difference of set4 and set3 is ");        leftOver.displaySet();        leftOver = set3.difference(emptySet);        System.out.println("\nThe difference of set3 and emptySet is ");        leftOver.displaySet();        leftOver = emptySet.difference(set3);        System.out.println("\nThe difference of emptySet and set3 is ");        leftOver.displaySet();        // testing replace        System.out.println("\n\u001B[35m\u001B[1m***Testing replace method***\u001B[0m");        set3.clear();        set3.add("A");        set3.add("C");        set3.add("D");        set3.add("X");        set3.add("B");        set3.add("A");        set3.add("X");        System.out.println("set3:");        set3.displaySet();        System.out.println("Trying to replace the first element with \"X\"");        if (set3.replace("X") == null)            System.out.println("CORRECT - returned null since no replacement was made");        else            System.out.println("INCORRECT - replacement should not be made");        System.out.println("Now set3 contains:");        set3.displaySet();        System.out.println("Trying to replace the first element with \"B\"");        if (set3.replace("B") == null)            System.out.println("CORRECT - returned null since no replacement was made");        else            System.out.println("INCORRECT - replacement should not be made");        System.out.println("Now set3 contains:");        set3.displaySet();        System.out.println("Trying to replace the first element with \"Z\"");        if (set3.replace("Z") == null)            System.out.println("INCORRECT - replacement should be made");        else            System.out.println("CORRECT - replacement was made");        System.out.println("Now set3 contains:");        set3.displaySet();        System.out.println("\nCalling replace on emptySet");        String replaced = emptySet.replace("X");        if (replaced == null)            System.out.println("The set is empty and replace returned null - CORRECT");        else            System.out.println("The set is empty but replace did not return null - INCORRECT");        System.out.println("Now emptySet contains:");        emptySet.displaySet();        // testing removeAllLarger        System.out.println("\n\u001B[35m\u001B[1m***Testing removeAllLarger method***\u001B[0m");        set3.add("K");        set3.add("B");        System.out.println("set3:");        set3.displaySet();        System.out.println("Removing all that are larger than \"Z\"");        set3.removeAllLarger("Z");        System.out.println("After removing all that are larger than \"Z\" set3 contains:");        set3.displaySet();        System.out.println("Removing all that are larger than \"K\"");        set3.removeAllLarger("K");        System.out.println("After removing all that are larger than \"K\" set3 contains:");        set3.displaySet();        System.out.println("Removing all that are larger than \"D\"");        set3.removeAllLarger("D");        System.out.println("After removing all that are larger than \"D\" set3 contains:");        set3.displaySet();        System.out.println("Removing all that are larger than \"B\"");        set3.removeAllLarger("B");        System.out.println("After removing all that are larger than \"B\" set3 contains:");        set3.displaySet();        System.out.println("\n\u001B[35m\u001B[1m*** TESTING moveFirstToEnd ***\u001B[0m");        testSet.clear();        testSet.add("C");        testSet.add("B");        testSet.add("A");        System.out.println("List before:");        testSet.displaySet();        testSet.moveFirstToEnd();        System.out.println("List after:");        testSet.displaySet();        System.out.println();        System.out.println("Calling moveFirstToEnd three times");        testSet.clear();        testSet.add("B");        testSet.add("C");        testSet.add("A");        System.out.println("List before:");        testSet.displaySet();        testSet.moveFirstToEnd();        testSet.moveFirstToEnd();        testSet.moveFirstToEnd();        System.out.println("List after:");        testSet.displaySet();        System.out.println();        System.out.println("Calling moveFirstToEnd four times");        testSet.clear();        testSet.add("F");        testSet.add("D");        testSet.add("E");        testSet.add("B");        testSet.add("C");        testSet.add("A");        System.out.println("List before:");        testSet.displaySet();        testSet.moveFirstToEnd();        testSet.moveFirstToEnd();        testSet.moveFirstToEnd();        testSet.moveFirstToEnd();        System.out.println("List after:");        testSet.displaySet();        System.out.println();        System.out.println("Calling moveFirstToEnd on a list of length 0");        testSet.clear();        System.out.println("List before:");        testSet.displaySet();        testSet.moveFirstToEnd();        System.out.println("List after:");        testSet.displaySet();        System.out.println();        System.out.println("Calling moveFirstToEnd on a list of length 1");        testSet.clear();        testSet.add("B");        System.out.println("List before:");        testSet.displaySet();        testSet.moveFirstToEnd();        System.out.println("List after:");        testSet.displaySet();        System.out.println();        System.out.println("Calling moveFirstToEnd on a list of length 2");        testSet.clear();        testSet.add("A");        testSet.add("B");        System.out.println("List before:");        testSet.displaySet();        testSet.moveFirstToEnd();        System.out.println("List after:");        testSet.displaySet();        System.out.println();        System.out.println("\n\u001B[35m\u001B[1m*** TESTING findMiddleElementInOnePass ***\u001B[0m");        testSet.clear();        testSet.displaySet();        System.out.println("middle: " + testSet.findMiddleElementInOnePass());        testSet.add("A");        testSet.displaySet();        System.out.println("middle: " + testSet.findMiddleElementInOnePass() + "\n");        testSet.add("B");        testSet.displaySet();        System.out.println("middle: " + testSet.findMiddleElementInOnePass() + "\n");        testSet.add("C");        testSet.add("D");        testSet.add("E");        testSet.add("F");        testSet.displaySet();        System.out.println("middle: " + testSet.findMiddleElementInOnePass() + "\n");        testSet.add("G");        testSet.displaySet();        System.out.println("middle: " + testSet.findMiddleElementInOnePass() + "\n");        System.out.println("\n\u001B[35m\u001B[1m*** TESTING checkIfLoopExists ***\u001B[0m");        boolean result = testSet.checkIfLoopExists();        if (!result)            System.out.println("testSet does not have a loop - CORRECT");        else            System.out.println("testSet does have a loop - INCORRECT");        LinkedSetWithChainOfNodes<String> setWithLoop = new LinkedSetWithChainOfNodes<>();        setWithLoop.add("I");        setWithLoop.add("H");        setWithLoop.add("G");        setWithLoop.add("F");        setWithLoop.add("E");        setWithLoop.add("D");        setWithLoop.add("C");        setWithLoop.add("B");        setWithLoop.add("A");        setWithLoop.createALoop();        result = setWithLoop.checkIfLoopExists();        if (result)            System.out.println("setWithLoop does have a loop - CORRECT");        else            System.out.println("setWithLoop does not have a loop - INCORRECT");    } // end main} // end LinkedSetWithChainOfNodes