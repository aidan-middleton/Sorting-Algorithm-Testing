
public class MergeSort {
	/**	The method for sorting the numbers */
	public static long[] mergeSort(int[] list) {
		long results[] = {0,0,0};
		long temp[]; //Used to add results form function calls calls to the total results overall
		long start = System.currentTimeMillis(); //start time
		results[0]++; //If statement
		if (list.length > 1) {
			//	Merge sort the first half
			int [] firstHalf = new int[list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			temp = mergeSort(firstHalf);
			results[0] += temp[0]; //Add results from subroutine
			results[1] += temp[1];
			
			//Merge sort the second half
			int secondHalfLength = list.length - list.length / 2;
			int[] secondHalf = new int[secondHalfLength];
			System.arraycopy(list, list.length / 2, 
				secondHalf, 0, secondHalfLength);
			temp = mergeSort(secondHalf);
			results[0] += temp[0];  //Add results from subroutine
			results[1] += temp[1];

			//	Merge firstHalf with secondHalf into list
			temp = merge(firstHalf, secondHalf, list);
			results[0] += temp[0];  //Add results from subroutine
			results[1] += temp[1];
		}
		long end = System.currentTimeMillis(); //end timer
        results[2] = (end - start); //calc elapsed time
		return results;
	}
	
	/** Merge two sorted list */
	public static long[] merge(int[] list1, int[] list2, int[] temp) {
		long results[] = {0,0,0};

		int current1 = 0; // Current index in list1
		int current2 = 0; // Current index in list2
		int current3 = 0; // Current index in temp
		
		while (current1 < list1.length && current2 < list2.length) {
			results[0]++; //While loop
			results[0]++; //If statement
			if (list1[current1] < list2[current2])
				temp[current3++] = list1[current1++];
			else
				temp[current3++] = list2[current2++];
			results[1]++; //movement happens regardless of branch
		}
		results[0]++; //end of While loop

		while (current1 < list1.length){
			results[0]++; //while loop
			results[1]++; //movment
			temp[current3++] = list1[current1++];
		}
		results[0]++; //end of While loop
		
		while (current2 < list2.length){
			results[0]++;//while loop
			results[1]++;//movement
			temp[current3++] = list2[current2++];
		}
		results[0]++; //end of While loop

		return results;
	}
	
	/**
	/** A test method *
	public static void main(String[] args) {
		int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		mergeSort(list);
		for (int i = 0; i < list.length; i++)
			System.out.println(list[i] + " ");
	}
	*/
}
