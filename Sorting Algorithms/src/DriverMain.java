import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DriverMain {
    public static void main(String[] args) throws Exception {
        System.out.println("--Now running program! This may take some time!--");
        Scanner s;

        int size = 50000;
        long results[][][] = new long[6][4][3]; //6 algorithms; 4 data types; 3 Data items per; Format (Compares, Moves, Time)

        int list1[] = new int[size];    //In order list
        int list2[] = new int[size];    //Reverse order list
        int list3[] = new int[size];    //Almost order list(20% unsorted)
        int list4[] = new int[size];    //Random order list(80% unsorted)

        //Populate arrays with data
        s = new Scanner(new File("data(sorted).txt"));
        for(int i = 0; i < size; i++)
            list1[i] = s.nextInt();
        s = new Scanner(new File("data(reverse).txt"));
        for(int i = 0; i < size; i++)
            list2[i] = s.nextInt();
        s = new Scanner(new File("data(almost).txt"));
        for(int i = 0; i < size; i++)
            list3[i] = s.nextInt();
        s = new Scanner(new File("data(random).txt"));
        for(int i = 0; i < size; i++)
            list4[i] = s.nextInt();

        for(int i = 0; i < 6; i++){
            //Use temporary arrays to sort while perserving original arrays
            int temp1[] = Arrays.copyOf(list1, size); 
            int temp2[] = Arrays.copyOf(list2, size); 
            int temp3[] = Arrays.copyOf(list3, size); 
            int temp4[] = Arrays.copyOf(list4, size);

            //Iteravley preform each search type for each data set type
            results[i][0] = preformSortType(temp1, i);
            results[i][1] = preformSortType(temp2, i);
            results[i][2] = preformSortType(temp3, i);
            results[i][3] = preformSortType(temp4, i);
        }
        printResults(results, 6, 4, 3); //Print the results
        System.out.println("--Program complete! Exiting!--");
    }

    //Maps each sorting algorithm to an integer
    //Used so that a for loop may acesss the different algorithms
    static long[] preformSortType(int src[], int type){
        long results[] = {0,0,0};
        if(type == 0)
            results = HeapSort.heapSort(src);
        else if(type == 1)
            results = InsertionSort.insertionSort(src);
        else if(type == 2)
            results = MergeSort.mergeSort(src);
        else if(type == 3)
            results = QuickSort.quickSort(src);
        else if(type == 4)
            results = RadixSort.radixsort(src, src.length);
        else if(type == 5)
            results = SelectionSort.selectionSort(src);
        else{
            System.out.println("Exit from error");
            System.exit(1);
        }

    
        return results;
    }

    static void printResults(long results[][][], int size1, int size2, int size3){
        String types[] = {"Inorder", "Reverse-Order", "Almost-Order(20% Unsorted)", "Random-Order(80% Unsorted)"};
        String algs[] = {"Heap Sort", "Insertion Sort", "Merge Sort", "Quick Sort", "Radix Sort", "Selection Sort"};
        String data[] = {"Comparisons", "Movements", "Time"};
        
        for(int i = 0; i < size1; i++){
            System.out.println(algs[i]);
            for(int j = 0; j < size2; j++){
                System.out.println("\t" + types[j]);
                    for(int k = 0; k < size3; k++){
                        System.out.print("\t\t" + data[k] + ": " + results[i][j][k]);
                        if(k==2)
                            System.out.print(" ms");
                        System.out.println();
                    }
            }
        }
        System.out.println("--Results Printed! You may need to scroll to see all results!--");
    }
}