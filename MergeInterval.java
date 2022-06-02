import java.util.*;

class MergeInterval {
	public static void main(String args[]) {
		int[][] array = { { 1, 3 }, { 2, 5 }, { 2, 3 }, { 7, 9 }, { 9, 10 }, { 11, 15 } };

		int result[][] = mergeInterval(array);
		for (int i = 0; i < result.length; i++) {
			System.out.println("[" + result[i][0] + "],[" + result[i][1] + "]");
		}
	}

	static int[][] mergeInterval(int[][] array) {
		if (array == null || array.length == 1)
			return array;
		Collections.sort(Arrays.asList(array), Comparator.comparingInt(o -> o[0]));
		LinkedList<int[]> merge = new LinkedList<int[]>();
		for (int[] entry : array) {
			if (merge.isEmpty() || merge.getLast()[1] < entry[0])
				merge.add(entry);
			else
				merge.getLast()[1] = Math.max(merge.getLast()[1], entry[1]);

		}
		return merge.toArray(new int[merge.size()][]);
	}

}