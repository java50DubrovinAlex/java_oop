package telran.exceptions.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import telran.exceptions.BallBrokenFloor;

class ExceptionsTest {

	@Test
	void ballBrokenFloorTest() {
		BallBrokenFloor bbf = new BallBrokenFloor(100000);
		assertEquals(bbf.getFloor(), getMinFloor(bbf));
	}

	private int getMinFloor(BallBrokenFloor bbf) {
		int count = 0;
		int left = 1;
		int right = bbf.getnFloors();
		int middle = right / 2;
		while (left <= right) {
			try {
				bbf.broken(middle);
				left = middle + 1;
			} catch (Exception e) {
				right = middle - 1;
				e.printStackTrace();
			}
			middle = (left + right) / 2;
			System.out.println(count++);
		}
		return left;
	}

}