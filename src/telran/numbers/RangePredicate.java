package telran.numbers;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class RangePredicate implements Iterable<Integer>{
	int minInclusive;
	int maxExclusive;
	Predicate<Integer> predicate;
	public RangePredicate(int minInclusive, int maxExclusive) {
		
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
		int [] res = new int [length()];
		int index = 0;
		
		
		if(predicate != null) {
			for(int num:this) {
				if(getPredicate().test(num)) {
					res[index++] = num;
				}
			}
			
		}else {
			for(int num:this) {
				res[index++] = num;
			}
		}
		int [] resIfPredicat = new int [index];
		System.arraycopy(res, 0, resIfPredicat, 0, index);
//		for(int num:this) {
//			if(predicate != null && getPredicate().test(num)) {
//				res[index++] = num;
//			}
//			
//		}
		return predicate != null ? resIfPredicat : res;
	}
	
	private class RangePredicateIterator implements Iterator<Integer> {
		int current = minInclusive;
		Predicate<Integer> innerPredicate;
		RangePredicateIterator(Predicate<Integer> predicate) {
			innerPredicate = predicate;
			if(innerPredicate == null) {
				innerPredicate = num -> true;
			}else
			 {
				while (current < maxExclusive && !innerPredicate.test(current)) {
		            current++;
			}
			
        }
		}
		@Override
		public boolean hasNext() {
			return current < maxExclusive;
		}

		@Override
		public Integer next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			while(!innerPredicate.test(current)){
				
			}
			int res = current++;
			if(innerPredicate != null) {
				while (current < maxExclusive && !innerPredicate.test(current)) {
		            current++;
		        }
			}
			
	        
			return res;
		}
		
	}
	@Override
	public Iterator<Integer> iterator() {
		
		return new RangePredicateIterator(predicate);
	}

}
