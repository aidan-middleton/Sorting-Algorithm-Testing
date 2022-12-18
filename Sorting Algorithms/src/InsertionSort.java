
public class InsertionSort {
	/**The method for sorting the numbers 
	 * @return */
	public static long[] insertionSort(int[] list) {
		long results[] = {0, 0, 0};
		long start = System.currentTimeMillis(); //start timer
		for (int i = 1; i < list.length; i++) {
			results[0]++;//For loop comparison -> true
			/** Insert list[i] into a sorted sublist list[0..i-1] so that 
			 * 	list[0..i] is sorted
			 */
			int currentElement = list[i];
			int k;
			for (k = i-1; k>= 0 && list[k] > currentElement; k--) {
				results[0]++;
				results[1]++;
				list[k+1] = list[k];
			}
			
			//insert the current element into list[k + 1]
			results[1]++;
			list[k + 1] = currentElement;
			
		}
		//For loop comparison -> false; end of for loop
		long end = System.currentTimeMillis(); // end timer
		results[2] = end - start; //calc time
		return results;
	}
}
