import java.util.*;

class QuickSort {
	private static void swap(List<Integer> array, int a, int b) {
		Integer temp = array.get(a);
		array.set(a, array.get(b));
		array.set(b, temp);
	}

	private static int partition(List<Integer> array, int start, int end) {
		int i = start - 1, j = start;
		while (j < end) {
			if (array.get(j) < array.get(end)) {
				i++;
				swap(array, i, j);
			}
			j++;
		}
		if (j == end) {
			i++;
			swap(array, i, end);
		}
		return i;
	}

	private static void quickSort(List<Integer> array, int start, int end) {
		if (array == null || start >= end)
			return;
		int pivot = partition(array, start, end);
		quickSort(array, start, pivot - 1);
		quickSort(array, pivot + 1, end);
	}

	public static void main(String args[]) {
		List<Integer> array = new ArrayList<Integer>(Arrays.asList(2, 5, 1, 8, 7, 9, 3));
		quickSort(array, 0, array.size() - 1);
		Iterator<Integer> iterator = array.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}