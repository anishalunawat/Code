// @lc code=start
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
import java.util.*;

class SpecialIterator  implements Iterator<Integer> {
	Integer next, element;
	Iterator<Integer> iterator;
	public SpecialIterator (Iterator<Integer> iterator) {
		// initialize any member here.
		this.iterator=iterator;
		if(iterator.hasNext()) {
			next = iterator.next();
			if(iterator.hasNext()) {
				element = iterator.next();
			// if initial element cout is 0 we 
				while(next == 0 && iterator.hasNext()) {
					next = iterator.next();
					if(iterator.hasNext())
						element = iterator.next();
					else
						next = -1;
				}
			} else // if size of array is 1
				next = -1;
		} else // if size of array is 0
				next = -1;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if(next > 0) {
			//System.out.println(next +" : "+element);
			int val = element;
			next--;
			while(next == 0 && iterator.hasNext()) {
				next = iterator.next();
				//System.out.println("Anisha "+ next);
				if(iterator.hasNext())
					element = iterator.next();
				else
					next = -1;
			}
			if(next == 0)
				next = -1;
			return val;
		}
		return -1;
	}
	
	@Override
	public boolean hasNext() {
	    return next>0;
	}
	
	public static void main(String args[]) {
		Integer[] arr = {2, 3, 0, 4, 2, 2};
		//Integer[] arr = {2};
		//Integer[] arr = {};
		//Integer[] arr = {0,1,0,2,3,3};
		//Integer[] arr = {1,1,0,2,0,3};
		List<Integer> list = Arrays.asList(arr);
		Iterator<Integer> iterator = list.iterator();
		SpecialIterator sp = new SpecialIterator(iterator);
		while(sp.hasNext()){
				System.out.print(sp.next()+" ");
		}
	}
	
}
// @lc code=end

