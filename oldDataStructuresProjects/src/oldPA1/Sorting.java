package oldPA1;

public class Sorting {

	public static void selectionSort(int[] array, int arrayLen) { // complete this method
		for (int i = 0; i < arrayLen - 1; i++) {
			int index = i;
			for (int j = i + 1 ; j < arrayLen; j++) {
				if (array[j] < array[index]) {
					index = j;  // searching for lowest index
				}// end if
			} // end for
			int smallNum = array[index];
			array[index] = array[i];
			array[i] = smallNum;
		} // end for
	}

	public static void insertionSort(int[] array, int arrayLen) { // complete this method
		 for (int j = 1; j < arrayLen; j++) {  
	            int key = array[j];  
	            int i = j-1;  
	            while ( (i > -1) && ( array [i] > key ) ) {  
	                array [i+1] = array [i];  
	                i--;  
	            }  // end while
	            array[i+1] = key;  
	        }// end for  
	}// end method insertionSort
}// end class Sorting
