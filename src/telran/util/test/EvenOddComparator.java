package telran.util.test;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
//		Integer res;
//		if(o1 % 2 == 0 && o2 % 2 == 0) {
//			res = o1 - o2;
//		} else
//		if(o1 % 2 != 0 && o2 % 2 != 0) {
//			res = o2 - o1;
//		} else {
//			res = o1 % 2 != 0 && o2 % 2 == 0 ? o2 - o1 : o2 - o1;
//		}
//		return res;
		
		boolean isNum1Even = ((int)o1 % 2 == 0) ;
		boolean isNum2Even = ((int)o2 % 2 == 0) ;
		if(isNum1Even && isNum2Even || !isNum1Even && !isNum2Even) {
			return isNum1Even ? o1 - o2: o2 - o1;
		} 
			return  isNum1Even ? -1 : 1;
			
	}

}
