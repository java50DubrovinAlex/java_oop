package telran.shapes.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.shapes.Canvas;
import telran.shapes.Rectangle;
import telran.shapes.Square;

class ShapeTest {
	Canvas canvasTest;
	Canvas canvasTest2;
	@BeforeEach
	void setUp() throws Exception {
		canvasTest = new Canvas();
		canvasTest.addShape(new Square(2));
		canvasTest.addShape(new Rectangle(2, 3));
		canvasTest.addShape(new Rectangle(2, 4));
		canvasTest2 = new Canvas();
		canvasTest2.addShape(new Square(4));
		canvasTest.addShape(canvasTest2);
		
		
	}

	@Test
	void perimeterTest() {
		assertEquals(8, new Rectangle(2, 2).perimeter());
		assertEquals(6, new Rectangle(1, 2).perimeter());
	}
	@Test
	void squarTest() {
		assertEquals(4, new Rectangle(2, 2).square());
		assertEquals(8, new Rectangle(2, 4).square());
	}
	
	@Test
	void perimeterCanvasTest() {
		int res = canvasTest.perimeter();
		assertEquals(30, res);
	}
	
	@Test
	void squatCanvasTest() {
		int res = canvasTest.square();
		assertEquals(18, res);
	}
	
	@Test
	void removeTest() {
		boolean isRemove = canvasTest.removeIf(shape -> shape instanceof Square);
		assertTrue(isRemove);
		assertEquals(14, canvasTest.square());
		
	}
	@Test
	void removeNestedCanvasesTest() {
		boolean isRemove = canvasTest.removeNestedCanvases();
		assertTrue(isRemove);
	}

}
