import java.util.Scanner;

/**
 * SearchOptimizationSystem
 *
 * An interactive algorithm optimization and benchmarking system in Java.
 * Compares Linear Search vs. Binary Search and demonstrates how pre-sorting
 * data via an optimized Bubble Sort achieves O(log n) search performance.
 *
 * Includes high-resolution execution time comparison using System.nanoTime().
 */
public class SearchOptimizationSystem {
    private static Scanner sc = new Scanner(System.in);

    public SearchOptimizationSystem() {
    }

    /**
     * Traverses and prints the elements of the integer array.
     *
     * @param arr Array to be displayed
     */
    static void displayArray(int[] arr) {
        System.out.println("\nCurrent Data:");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    /**
     * Performs a sequential scan over the array to locate the target element.
     * Time Complexity: O(n), Space Complexity: O(1)
     *
     * @param arr    Input array (can be unsorted)
     * @param target Value to search for
     * @return 0-based index if found, or -1 if not present
     */
    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Performs binary search on a sorted array using divide-and-conquer.
     * Time Complexity: O(log n), Space Complexity: O(1)
     *
     * @param arr    Sorted array
     * @param target Value to search for
     * @return 0-based index if found, or -1 if not present
     */
    static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Sorts the array in ascending order using an optimized Bubble Sort
     * featuring an early-exit flag to achieve O(n) best-case complexity.
     *
     * @param arr Array to sort in-place
     */
    static void sortArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            boolean swapped = false;

            for (int j = 0; j < arr.length - i - 1; ++j) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Pre-conditions the array by sorting it before performing binary search.
     *
     * @param arr    Input array
     * @param target Element to search for
     */
    static void optimizedSearch(int[] arr, int target) {
        System.out.println("\n--- Optimized Search ---");
        sortArray(arr);
        System.out.println("Data sorted successfully.");
        int index = binarySearch(arr, target);
        if (index != -1) {
            System.out.println("Element " + target + " found at sorted index " + index);
        } else {
            System.out.println("Element " + target + " not found.");
        }
    }

    /**
     * Benchmarks Linear Search against Binary Search using System.nanoTime()
     * and reports detailed execution metrics and comparative conclusion.
     *
     * @param arr    Input array
     * @param target Element to search for
     */
    static void compareSearch(int[] arr, int target) {
        System.out.println("\n--- Search Comparison ---");

        // Benchmark Linear Search
        long startLinear = System.nanoTime();
        int linearIndex = linearSearch(arr, target);
        long endLinear = System.nanoTime();
        long linearTime = endLinear - startLinear;

        // Pre-condition array for Binary Search
        sortArray(arr);

        // Benchmark Binary Search
        long startBinary = System.nanoTime();
        int binaryIndex = binarySearch(arr, target);
        long endBinary = System.nanoTime();
        long binaryTime = endBinary - startBinary;

        System.out.println("\nLinear Search:");
        if (linearIndex != -1) {
            System.out.println("Element found.");
        } else {
            System.out.println("Element not found.");
        }
        System.out.println("Execution Time: " + linearTime + " nanoseconds");

        System.out.println("\nBinary Search:");
        if (binaryIndex != -1) {
            System.out.println("Element found.");
        } else {
            System.out.println("Element not found.");
        }
        System.out.println("Execution Time: " + binaryTime + " nanoseconds");

        System.out.println("\nConclusion:");
        if (binaryTime < linearTime) {
            System.out.println("Binary Search is faster for this search.");
        } else {
            System.out.println("Linear Search was faster for this particular run.");
        }
    }

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("     SEARCH OPTIMIZATION SYSTEM");
        System.out.println("======================================");
        System.out.print("\nEnter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("\nEnter " + n + " elements:");

        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }

        int choice;
        do {
            System.out.println("\n======================================");
            System.out.println("              MAIN MENU");
            System.out.println("======================================");
            System.out.println("1. Display Data");
            System.out.println("2. Linear Search");
            System.out.println("3. Binary Search");
            System.out.println("4. Optimized Search");
            System.out.println("5. Compare Search Methods");
            System.out.println("6. Sort Data");
            System.out.println("7. Exit");
            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displayArray(arr);
                    break;
                case 2:
                    System.out.print("Enter element to search: ");
                    int targetLinear = sc.nextInt();
                    int resLinear = linearSearch(arr, targetLinear);
                    if (resLinear != -1) {
                        System.out.println("Element found at index " + resLinear);
                    } else {
                        System.out.println("Element not found.");
                    }
                    break;
                case 3:
                    System.out.println("\nBinary Search requires sorted data.");
                    sortArray(arr);
                    System.out.println("Data sorted successfully.");
                    System.out.print("Enter element to search: ");
                    int targetBinary = sc.nextInt();
                    int resBinary = binarySearch(arr, targetBinary);
                    if (resBinary != -1) {
                        System.out.println("Element found at index " + resBinary);
                    } else {
                        System.out.println("Element not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter element to search: ");
                    int targetOpt = sc.nextInt();
                    optimizedSearch(arr, targetOpt);
                    break;
                case 5:
                    System.out.print("Enter element to search: ");
                    int targetComp = sc.nextInt();
                    compareSearch(arr, targetComp);
                    break;
                case 6:
                    sortArray(arr);
                    System.out.println("Data sorted successfully.");
                    displayArray(arr);
                    break;
                case 7:
                    System.out.println("\nThank you for using Search Optimization System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        sc.close();
    }
}
