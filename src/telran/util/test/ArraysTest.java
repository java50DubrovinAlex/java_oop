package telran.util.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static telran.util.Arrays.*;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

class ArraysTest {
	Integer[] numbers = {10, 5, -5, 100, 200};
	String [] string = {"lmn", "a", "ab", "abc", "b", "ba"};
@Test
void addObjectTest() {
	Integer [] expectedNumbers = {10, 5, -5, 100, 200, 50};
	assertArrayEquals(expectedNumbers, addObject(numbers, 50));
	String[] expectedString = {"lmn", "a", "ab", "abc", "b", "ba", "bb"};
	assertArrayEquals(expectedString, addObject(string, "bb"));
		
}
@Test
void insertObjectTest() {
	Integer [] expectedLast = {10, 5, -5, 100, 200, 50};
	Integer [] expectedFitst = {50, 10, 5, -5, 100, 200};
	Integer [] expectedMiddle = {10, 5, 50, -5, 100, 200};
	assertArrayEquals(expectedLast, insertObject(numbers, 5, 50));
	assertArrayEquals(expectedFitst, insertObject(numbers, 0, 50));
	assertArrayEquals(expectedMiddle, insertObject(numbers, 2, 50));
}
@Test
void digitsSumComparatorTest() {
	Comparator<Integer> comp = new DigitsSumComparator();
	assertTrue(comp.compare(9, 66) < 0);
	assertTrue(comp.compare(9, 111) > 0);
	assertTrue(comp.compare(3, 111) == 0);
	assertTrue(comp.compare(-3, 111) == 0);
	
}
@Test
void standartSortComparatorTest() {
	Integer [] array = {10, 5, 110, 9, 22, 33};
	Integer [] expected =  {10, 110, 22, 5, 33, 9};
	Arrays.sort(array, new DigitsSumComparator());
	assertArrayEquals(expected, array);
}
@Test
void bubbleSortComparatorTest() {
Integer [] expected= {-5, 5, 10, 100, 200};
Integer []array= {10, 5, -5, 100, 200};
bubbleSort(array, (a, b) -> a - b );
assertArrayEquals(expected, array);
}
@Test
void bubbleSortComparatorEvenOddTest() {
Integer [] expected= {10, 100, 200, 5, -5};
Integer []array= {10, 5, -5, 100, 200};
bubbleSort(array, new EvenOddComparator());
assertArrayEquals(expected, array);
}
}
