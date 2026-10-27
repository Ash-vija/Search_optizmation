import java.util.Scanner; 
 
public class SearchOptimizationSystem_Original { 
   static Scanner sc; 
 
   public SearchOptimizationSystem_Original() { 
   } 
 
   static void displayArray(int[] var0) { 
      System.out.println("\nCurrent Data:"); 
 
      for(int var4 : var0) { 
         System.out.print(var4 + " "); 
      } 
 
      System.out.println(); 
   } 
 
   static int linearSearch(int[] var0, int var1) { 
      for(int var2 = 0; var2 < var0.length; ++var2) { 
         if (var0[var2] == var1) { 
            return var2; 
         } 
      } 
 
      return -1; 
   } 
 
   static int binarySearch(int[] var0, int var1) { 
      int var2 = 0; 
      int var3 = var0.length - 1; 
 
      while(var2 <= var3) { 
         int var4 = var2 + (var3 - var2) / 2; 
         if (var0[var4] == var1) { 
            return var4; 
         } 
 
         if (var0[var4] < var1) { 
            var2 = var4 + 1; 
         } else { 
            var3 = var4 - 1; 
         } 
      } 
 
      return -1; 
   } 
 
   static void sortArray(int[] var0) { 
      for(int var1 = 0; var1 < var0.length - 1; ++var1) { 
         boolean var2 = false; 
 
         for(int var3 = 0; var3 < var0.length - var1 - 1; ++var3) { 
            if (var0[var3] > var0[var3 + 1]) { 
               int var4 = var0[var3]; 
               var0[var3] = var0[var3 + 1]; 
               var0[var3 + 1] = var4; 
               var2 = true; 
            } 
         } 
 
         if (!var2) { 
            break; 
         } 
      } 
 
   } 
 
   static void optimizedSearch(int[] var0, int var1) { 
      System.out.println("\n--- Optimized Search ---"); 
      sortArray(var0); 
      System.out.println("Data sorted successfully."); 
      int var2 = binarySearch(var0, var1); 
      if (var2 != -1) { 
         System.out.println("Element " + var1 + " found at sorted index " + var2); 
      } else { 
         System.out.println("Element " + var1 + " not found."); 
      } 
 
   } 
 
   static void compareSearch(int[] var0, int var1) { 
      System.out.println("\n--- Search Comparison ---"); 
      long var2 = System.nanoTime(); 
      int var4 = linearSearch(var0, var1); 
      long var5 = System.nanoTime(); 
      long var7 = var5 - var2; 
      sortArray(var0); 
      long var9 = System.nanoTime(); 
      int var11 = binarySearch(var0, var1); 
      long var12 = System.nanoTime(); 
      long var14 = var12 - var9; 
      System.out.println("\nLinear Search:"); 
      if (var4 != -1) { 
         System.out.println("Element found."); 
      } else { 
         System.out.println("Element not found."); 
      } 
 
      System.out.println("Execution Time: " + var7 + " nanoseconds"); 
      System.out.println("\nBinary Search:"); 
      if (var11 != -1) { 
         System.out.println("Element found."); 
      } else { 
         System.out.println("Element not found."); 
      } 
 
      System.out.println("Execution Time: " + var14 + " nanoseconds"); 
      System.out.println("\nConclusion:"); 
      if (var14 < var7) { 
         System.out.println("Binary Search is faster for this search."); 
      } else { 
         System.out.println("Linear Search was faster for this particular run."); 
      } 
 
   } 
 
   public static void main(String[] var0) { 
      System.out.println("======================================"); 
      System.out.println("     SEARCH OPTIMIZATION SYSTEM"); 
      System.out.println("======================================"); 
      System.out.print("\nEnter number of elements: "); 
      int var1 = sc.nextInt(); 
      int[] var2 = new int[var1]; 
      System.out.println("\nEnter " + var1 + " elements:"); 
 
      for(int var3 = 0; var3 < var1; ++var3) { 
         var2[var3] = sc.nextInt(); 
      } 
 
      int var10; 
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
         var10 = sc.nextInt(); 
         switch (var10) { 
            case 1: 
               displayArray(var2); 
               break; 
            case 2: 
               System.out.print("Enter element to search: "); 
               int var4 = sc.nextInt(); 
               int var5 = linearSearch(var2, var4); 
               if (var5 != -1) { 
                  System.out.println("Element found at index " + var5); 
               } else { 
                  System.out.println("Element not found."); 
               } 
               break; 
            case 3: 
               System.out.println("\nBinary Search requires sorted data."); 
               sortArray(var2); 
               System.out.println("Data sorted successfully."); 
               System.out.print("Enter element to search: "); 
               int var6 = sc.nextInt(); 
               int var7 = binarySearch(var2, var6); 
               if (var7 != -1) { 
                  System.out.println("Element found at index " + var7); 
               } else { 
                  System.out.println("Element not found."); 
               } 
               break; 
            case 4: 
               System.out.print("Enter element to search: "); 
               int var8 = sc.nextInt(); 
               optimizedSearch(var2, var8); 
               break; 
            case 5: 
               System.out.print("Enter element to search: "); 
               int var9 = sc.nextInt(); 
               compareSearch(var2, var9); 
               break; 
            case 6: 
               sortArray(var2); 
               System.out.println("Data sorted successfully."); 
               displayArray(var2); 
               break; 
            case 7: 
               System.out.println("\nThank you for using Search Optimization System!"); 
               break; 
            default: 
               System.out.println("Invalid choice. Please try again."); 
         } 
      } while(var10 != 7); 
 
      sc.close(); 
   } 
 
   static { 
      sc = new Scanner(System.in); 
   } 
} 
