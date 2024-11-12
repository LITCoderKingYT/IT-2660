import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Unsorted Array ---------------------------------------------------");
        ArrayList<Integer> integerList = Lab4.getList();
        Lab4.outputList(integerList);

        // Measure time for Bubble Sort
        long startTime = System.nanoTime();
        ArrayList<Integer> bubbleSortedList = Lab4.bubbleSort(integerList);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds
        System.out.println("\n\nBubble sort results ----------------------------------------------");
        Lab4.outputList(bubbleSortedList);
        System.out.println("\nTime taken for Bubble Sort: " + duration + " ms");

        // Measure time for Insertion Sort
        startTime = System.nanoTime();
        ArrayList<Integer> insertionSortedList = Lab4.insertionSort(integerList);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds
        System.out.println("\n\nInsertion sort results -------------------------------------------");
        Lab4.outputList(insertionSortedList);
        System.out.println("\nTime taken for Insertion Sort: " + duration + " ms");
    }
}

class Lab4 {
    public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
        ArrayList<Integer> sortedList = new ArrayList<>(integerList);
        // Step 1 - Implement insertion sort algorithm here
        for (int i = 1; i < sortedList.size(); i++) {
            int key = sortedList.get(i);
            int j = i - 1;
            while (j >= 0 && sortedList.get(j) > key) {
                sortedList.set(j + 1, sortedList.get(j));
                j = j - 1;
            }
            sortedList.set(j + 1, key);
        }
        return sortedList;
    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {
        ArrayList<Integer> sortedList = new ArrayList<>(integerList);
        // Step 2 - Implement the bubble sort algorithm here
        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = 0; j < sortedList.size() - i - 1; j++) {
                if (sortedList.get(j) > sortedList.get(j + 1)) {
                    int temp = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j + 1));
                    sortedList.set(j + 1, temp);
                }
            }
        }
        return sortedList;
    }

    public static ArrayList<Integer> getList() {
        ArrayList<Integer> integerList = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("integers.txt"))) {
            while ((line = br.readLine()) != null) {
                integerList.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return integerList;
    }

    public static void outputList(ArrayList<Integer> integerList) {
        for (int i = 0; i < integerList.size(); i++) {
            System.out.print(integerList.get(i) + " ");
        }
        System.out.println();
    }
}

/*If you were implementing a sort algorithm for a new language, which sort would you use?


I would add the quick or merge sort algorithm because they are able to offer average-case time. They can be more efficient too.


*Was there a difference in the time it took for Bubble and Insertion Sort to run? Does this make sense given the time complexities for these sorting algorithms?
Yes, insertion will take less time than bubble sorting, because it moves the elements directly to the correct position while bubble sorting compares and swaps.


*Which sort algorithm has an easier implementation (in terms of understanding) to you?
Bubble sorting is easier for me to understand since it's a more straightforward, easier to understand sorting algorithm.

*/
