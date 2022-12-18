
public class HeapSort {
	/** Heap sort method */
	public static long[] heapSort(int[] list) {
		
		long results[] = {0,0,0};
		long start = System.currentTimeMillis(); //start time

		//	Create a Heap of integers
		Heap heap = new Heap();
		
		//	Add elements to the heap
		for (int i = 0; i < list.length; i++){
			results[0]++; //for loop running
			int temp[] = heap.add(list[i]);
			results[0] += temp[0]; //Add results from subroutine
			results[1] += temp[1];
		}
		results[0]++; //end of loop running
		
		//	Remove elements from the heap
		for (int i = list.length -1; i >= 0; i--){
			results[0]++; //for loop running
			int temp[] = heap.remove();
			results[0] += temp[0]; //Add results from subroutine
			results[1] += temp[1];
			list[i] = temp[3]; //temp[3] is the removed element
		}
		results[0]++; //end of loop running
		long end = System.currentTimeMillis(); // end time
		results[2] = end - start; // calc time
		return results;
	}
	
	
 	/**	A test method 
	public static void main(String[] args) {
		Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
		heapSort(list);
		for(int i = 0; i < list.length; i++)
			System.out.println(list[i] + " ");
	}
	*/
}
