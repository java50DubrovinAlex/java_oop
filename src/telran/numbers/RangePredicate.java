package telran.numbers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class RangePredicate implements Iterable<Integer> {
	int minInclusive;
	int maxExclusive;
	Predicate<Integer> predicate;

	public RangePredicate(int minInclusive, int maxExclusive) {
		if(minInclusive >= maxExclusive) {
    		throw new IllegalArgumentException("min must be less than max");
    	}
		this.minInclusive = minInclusive;
		this.maxExclusive = maxExclusive;
	}

	public Predicate<Integer> getPredicate() {
		return predicate;
	}

	public void setPredicate(Predicate<Integer> predicate) {
		this.predicate = predicate;
	}

	public int length() {
		return maxExclusive - minInclusive;
	}

	public int[] toArray() {
		int[] res = new int[length()];
		int index = 0;
		
        for (int num : this) {
        	if(predicate == null){
                res[index++] = num;
        	}else if(predicate.test(num)){
        		res[index++] = num;
        	}
        }
        Arrays.copyOf(res, index);
		return res;
	}

	private class RangePredicateIterator implements Iterator<Integer> {
		

		int current = minInclusive;;
		Predicate<Integer> innerPredicate;

		RangePredicateIterator(Predicate<Integer> predicate) {
//			current = minInclusive;
            innerPredicate = predicate;
        }
		

		public void setCurrent(int current) {
			this.current = current;
		}


		public int getCurrent() {
			return current;
		}


		@Override
		public boolean hasNext() {
			return current < maxExclusive;
		}

		@Override
		public Integer next() {
			if (!hasNext()) {
                throw new NoSuchElementException();
            }

            int res = current;
           if(innerPredicate != null) {
            while (current < maxExclusive && !innerPredicate.test(res)) {
//                current ++;
//            	setCurrent(current);
            	res = current++;
            }
           }else {
//        	   setCurrent(current);
        	   res = current++;
           }
            return res;
		}

	}

	@Override
	public Iterator<Integer> iterator() {

		return new RangePredicateIterator(predicate);
	}

}
