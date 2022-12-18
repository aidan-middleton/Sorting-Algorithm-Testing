
public class Heap {
	private java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
	
	/** Create a default heap */
	public Heap() {
	}
	
	/** Create a heap from an array of objects */
	public Heap(Integer[] objects) {
		for (int i = 0; i < objects.length; i++){
			add(objects[i]);
		}
	}
	
	/**	Add a new object into the heap */
	public int[] add(Integer newObject) {
		int results[] = {0,0,0};
		list.add(newObject); //	Append to the heap
		int currentIndex = list.size()-1; // The index of the last node
		
		while (currentIndex > 0) {
			results[0]++; // while loop running
			int parentIndex = (currentIndex -1)/2;
			//	Swap if the current object is greater than its parent
			results[0]++; //If/else
			if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
				Integer temp = list.get(currentIndex);
				list.set(currentIndex, list.get(parentIndex));
				list.set(parentIndex, temp);
				results[1]++; //Movement
			}
			else
				break; // The tree is a heap now
			
			currentIndex = parentIndex;
		}
		results[0]++; // end of while loop running

		return results;
	}
	
	/** Remove the root from the heap */
	public int[] remove() {
		//4th element is integer removed
		int results[] = {0,0,0,-1}; //adding index three bcs remove needs to return the item removed

		results[0]++; //If statement
		if (list.size() == 0) {
			return results;
		}
		
		Integer removedObject = list.get(0);
		results[3] = (int) removedObject; //results[3] is the removed item

		results[1]++; //Shift last index to first
		list.set(0, list.get(list.size()-1));
		list.remove(list.size()-1);
		
		int currentIndex = 0;
		while (currentIndex < list.size()) {
			results[0]++; // while loop running
			int leftChildIndex = 2 * currentIndex + 1;
			int rightChildIndex = 2 * currentIndex + 2;
			
			//	Find the maximum between two children
			results[0]++;//if
			if (leftChildIndex >= list.size())
				break; // The tree is a heap
			int maxIndex = leftChildIndex;
			results[0]++;//if
			if (rightChildIndex < list.size()) {
				results[0]++;//if
				if (list.get(maxIndex).compareTo( 
						list.get(rightChildIndex)) < 0) {
					maxIndex = rightChildIndex;
				}		
			}
			
			//	Swap if the current node is less than the maximum
			results[0]++;//if else
			if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
				results[1]++; //movement
				Integer temp = list.get(maxIndex);
				list.set(maxIndex, list.get(currentIndex));
				list.set(currentIndex, temp);
				currentIndex = maxIndex; 
			}
			else
				break; // The tree is a heap
		}
		results[0]++; // end of while loop running
		
		return results;
	}
	
	/** Get the number of nodes in the tree */
	public int getSize() {
		return list.size();
	}
}
