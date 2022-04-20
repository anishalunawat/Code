import java.util.*;
import java.io.*;

class SlidingWindow{

	public static int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<Integer>();
		if(nums == null)
			return null;
		PriorityQueue<Integer> heap = new PriorityQueue<>((Integer e1, Integer e2)->(-Integer.compare(e1,e2)));
		for(int i=0; i<k ;i++) {
			heap.add(nums[i]);	
		}
		result.add(heap.peek());
		int last = 0;
		int current = k;
		while(current<nums.length){
			heap.remove(nums[last]);
			heap.add(nums[current]);
			result.add(heap.peek());
			last++;
			current++;
		}
		return result.stream().mapToInt(i->i).toArray();
    }
	public static void main(String args[]) {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int[] result = maxSlidingWindow(nums, 3);
		for(int entry: result){
			System.out.println(entry);
		}
	}
}