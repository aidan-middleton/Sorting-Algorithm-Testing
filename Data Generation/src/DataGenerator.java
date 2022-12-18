import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class DataGenerator {
    public static void main(String[] args) throws Exception {
        int size = 50000;
        int arrSorted[] = new int[size];
        int arrReverse[] = new int[size];
        int arrAlmost[] = new int[size];
        int arrRandom[] = new int[size];
        try {
            PrintWriter sorted = new PrintWriter("data(sorted).txt");
            PrintWriter reverse = new PrintWriter("data(reverse).txt");
            PrintWriter almost = new PrintWriter("data(almost).txt");
            PrintWriter random = new PrintWriter("data(random).txt");

            //Gen sorted array and list
            for(int i = 0; i < size; i++){
                arrSorted[i] = i;
                sorted.println(i);
                sorted.flush();
            }
            //Gen reverse array
            arrReverse = reverseArr(arrSorted, size);
            //save reverse data
            for(int i = 0; i < size; i++){
                reverse.println(arrReverse[i]);
                reverse.flush();
            }
                
            //gen almost sorted data
            arrAlmost = perSort(arrSorted, 0.2, size);
            //save almost data
            for(int i = 0; i < size; i++){
                almost.println(arrAlmost[i]);
                almost.flush();
            }
            //Generate 80% unsorted data
            arrRandom = perSort(arrSorted, 0.8, size);
            //save 80% unsorted data
            for(int i = 0; i < size; i++){
                random.println(arrRandom[i]);
                random.flush();
            }

            sorted.close();
            reverse.close();
            almost.close();
            random.close();

        } catch (FileNotFoundException fe){
            System.exit(1);
        }


    }

    //Makes an array unsorted to a specific precentage
    //src: the array to sort
    //des: where to sort too
    //per: what percentage of the array to unsort(enter in decimal value)
    //size: size of arary to sort
    static int[] perSort(int src[], double per, int size){
        int tempArr[] = Arrays.copyOf(src, size);
        Arrays.sort(tempArr);
        for(int i = 0; i < size * per; i++){
            int pos1 = (int) (Math.random() * size);
            int pos2 = (int) (Math.random() * size);
            int temp = tempArr[pos1];
            tempArr[pos1] = tempArr[pos2];
            tempArr[pos2] = temp;
        }
        return tempArr;
    }

    //Reverse the order of all the elements in an array
    static int[] reverseArr(int src[], int size){
        int tempArr[] = new int[size];
        for(int i = 0; i < size; i++)
            tempArr[i] = src[size-1-i];
        return tempArr;
    }
}
