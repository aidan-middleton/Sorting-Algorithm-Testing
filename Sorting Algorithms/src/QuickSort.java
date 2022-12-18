public class QuickSort {
	public static long[] quickSort(int[] list) {
		long results[] = quickSort(list, 0, list.length-1);
		return results;
	}
	
	public static long[] quickSort(int[] list, int first, int last) {
		long results[] = {0,0,0};
		//Temps takes alternate form for partition; 4th indext (index 3) is pivot index; quicksort functions uses normal form
		long temp[] = {0,0,0,0};

		long start = System.currentTimeMillis(); //Start timer

		results[0]++; //If statement
		if (last > first) {
			
			temp = partition(list, first, last);
			results[0] += temp[0]; //Add number of movements and comparisons from subroutine
			results[1] += temp[1];
			int pivotIndex = (int) temp[3];
			temp = quickSort(list, first, pivotIndex -1);
			results[0] += temp[0]; //Add number of movements and comparisons from subroutine
			results[1] += temp[1];
			temp = quickSort(list, pivotIndex + 1, last);
			results[0] += temp[0]; //Add number of movements and comparisons from subroutine
			results[1] += temp[1];
		}
		
		long end = System.currentTimeMillis(); //Calc time
        results[2] = end - start;

		return results;
	}
	
	/** Partition the array list[first..last] */
	public static long[] partition(int[] list, int first, int last) {
		long results[] = {0,0,0,0}; //We need an aditional slot in the results for the pivot index; index 3 is the pivot index
		int pivot = list[first]; // Choose the first element as the pivot
		int low = first + 1; // Index for forward search
		int high = last; //Index for backward search
		
		
		while (high > low) {
			results[0]++; //Every time the code in this for loop is executed, A comparison happens
			// Search forward from left
			while (low <= high && list[low] <= pivot){
				results[0]++;//Every time the code in this for loop is executed, A comparison happens
				low++;
			}
			results[0]++; //End of a while loop
			
			// Search backward from right
			while (low <= high && list[high] > pivot){
				results[0]++;//Every time the code in this for loop is executed, A comparison happens
				high--;
			}
			results[0]++; //End of a while loop

			//	Swap two elements in the list
			results[0]++; //If statment
			if (high > low) {
				results[1]++; //Movement
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}
		results[0]++; //Once this for loop ends, that means a comparison happened, but out counter is inside the while loop; which will not rub. Thus, we need to add one comparison when then while loop ends.

		while (high > first && list[high] >= pivot){
			results[0]++;
			high--;
		}
		results[0]++;results[0]++; //End of a while loop
		//	Swap pivot with list[high]
		results[0]++; //If statement -> comparison
		if (pivot > list[high]) {
			results[1]++; //movement
			list[first] = list[high];
			list[high] = pivot;
			results[3] = high;
			return results;
		}
		else {
			results[3] = low;
			return results;
		}
	}
}
