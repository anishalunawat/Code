class MaxSumArray {

	public int setMaxSumSubArray(int[] arr) {
		int sum = 0, max = Integer.MIN_VALUE;
		int j = 0;
		while (j < arr.length) {
			sum += arr[j];
			if (sum > max)
				max = sum;
			if (sum < 0)
				sum = 0;
			j++;
		}
		return max;
	}

	public static void main(String args[]) {
		MaxSumArray maxSum = new MaxSumArray();
		int arr[] = { -1, 4, -3, 9, -10, -16 };
		int result = maxSum.setMaxSumSubArray(arr);
		System.out.println(result + " is the max sum");
	}
}