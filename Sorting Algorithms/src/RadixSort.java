import java.util.*;

class RadixSort {
	static long[] getMax(int arr[], int n) {
		long results[] = {0,0,0,0}; //index 3 needed to show max
		int mx = arr[0];
		for (int i = 1; i < n; i++){
			results[0]++; //for loop
			results[0]++; //if statement
			if (arr[i] > mx)
				mx = arr[i];
		}
		results[0]++; //end of for loop
		results[3] = mx;
		return results;
	}

	static long[] countSort(int arr[], int n, int exp) {
		long results[] = {0,0,0};
		int output[] = new int[n];
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);
		for (i = 0; i < n; i++){
			results[0]++;//for loop
			count[(arr[i] / exp) % 10]++;
		}
		results[0]++;//end of for loop
		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (i = 1; i < 10; i++){
			results[0]++;//for loop
			count[i] += count[i - 1];
		}
		results[0]++;//end of for loop
		// Build the output array
		for (i = n - 1; i >= 0; i--) {
			results[0]++;//for loop
			results[1]++;//movement
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}
		results[0]++;//end of for loop
		for (i = 0; i < n; i++){
			results[0]++;//for loop
			results[1]++;//copying values
			arr[i] = output[i];
		}
		results[0]++;//end of for loop
		return results;
	}

	static long[] radixsort(int arr[], int n) { // Find the maximum number to know number of digits
		long results[] = {0,0,0,0};
		long start = System.currentTimeMillis();//Start timer
		long temp[] = getMax(arr, n);
		int m = (int) temp[3];
		for (int exp = 1; m / exp > 0; exp *= 10){
			results[0]++; // for loop
			temp = countSort(arr, n, exp);
		}
		results[0]++; //end of for loop

		results[0] += temp[0];  //Add results from subroutine
		results[1] += temp[1];

		long end = System.currentTimeMillis();//end timer
        results[2] = (end - start);//calc timer
		return results;
	}

	static void print(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
	/**
	public static void main(String[] args) {
		int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
		int n = arr.length;
		radixsort(arr, n);
		print(arr, n);
	}
	*/
}