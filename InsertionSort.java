import java.util.*;
import java.io.*;

class InsertionSort {
	private static void insertionSort(int[] array) {
		if(array == null)
			return;
		int length = array.length;
		for(int i=1; i<length ;i++) {
			int element = array[i];
			int j = i-1;
			while(j >= 0 && array[j] > element) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1]=element;
		}
	}
	
	public static void main(String args[]) {
		int[] array = new int[]{1,3,2,6,4,5};
		insertionSort(array);
		if(array != null) {
		   for(int i =0; i<array.length ;i++) {
			System.out.println(array[i]);
			}
		}
	}
}

