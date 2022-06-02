
class MergeSort {
	private static void mergeSortedArray(int[] array, int start, int mid, int end) {
		int leftLength = mid-start+1;
		int rightLength = end-mid;
		int[] leftArray = new int[leftLength];
		int[] rightArray = new int[rightLength];
		int k=0,i,j;
		for(i=start; i<=mid; i++, k++)
			leftArray[k]=array[i];
		k=0;
		for(i=mid+1; i<=end; i++,k++) {
			rightArray[k] = array[i];
		}
		k=start;i=0;j=0;
		while(i<leftLength && j<rightLength) {
			if(leftArray[i] < rightArray[j]) {
				array[k] = leftArray[i];
				i++;
			} else {
				array[k] = rightArray[j];
				j++;
			}
			k++;
		}
		while(i<leftLength) {
			array[k] = leftArray[i];
			k++;
			i++;
		}
		while(j<rightLength) {
			array[k] = rightArray[j];
			k++;
			j++;
		}
	}
	
	private static void mergeSort(int[] array, int start, int end) {
		if(start >= end)
			return;
		int mid = (start+end)/2;
		mergeSort(array, start, mid);
		mergeSort(array, mid+1, end);
		mergeSortedArray(array, start, mid, end);
	} 
	
	public static void main(String args[]) {
		int[] array = new int[]{7,5,2,3,1};
		mergeSort(array, 0, array.length -1);
		for(int i=0;i<array.length;i++)
		{
			System.out.println(array[i]);
		}
	}

}