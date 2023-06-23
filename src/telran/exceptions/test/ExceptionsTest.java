package telran.exceptions.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.exceptions.BallBrokenFloor;

class ExceptionsTest {

	@Test
	void ballBrokenFloorTest() {
		BallBrokenFloor bbf = new BallBrokenFloor(1000000);
		assertEquals(bbf.getFloor(), getMinFloor(bbf));
	}

	private int getMinFloor(BallBrokenFloor bbf) {
		int left = 1;
		int right = bbf.getnFloors();
		int middle = right / 2;
		while (left <= right) {
			try {
				bbf.broken(middle);
				left = middle + 1;
			} catch (Exception e) {
				right = middle - 1;
			}
			middle = (left + right) / 2;
		}
		return left;
	}

}