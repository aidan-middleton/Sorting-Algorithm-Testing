
public class SelectionSort {
	/** The method for sorting the numbers */
	public static long[] selectionSort(int[] list) { //int[] list?
		long results[] = {0,0,0};
		long start = System.currentTimeMillis();//start timer

		for (int i = 0; i < list.length -1; i++) {
			results[0]++; //for loop
			// Find the minimum in the list[i..list.length-1]
			int currentMin = list[i];
			int currentMinIndex = i;
			
			
			for (int j = i+1; j < list.length; j++) {
				results[0]++; //for loop
				results[0]++; //if statement
				if (currentMin > list[j]) {
					results[1]++;//swap
					currentMin = list[j];
					currentMinIndex = j;
				}
			}results[0]++; //for loop
			
			//	Swap list[i] wiht list[currentMinIndex[ if necessary
			//results[0]++; // if statement
			if (currentMinIndex != i) {
				results[1]++; //Swap
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}results[0]++; // end of for loop
		}results[0]++; // end of for loop
		long end = System.currentTimeMillis(); //end timer
        results[2] = (end - start); // calc timer
		return results;
	}
}
