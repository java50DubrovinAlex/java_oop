package telran.points.test;

import java.util.function.Predicate;

import telran.point.Point;

public class XyEqualPredicate implements Predicate<Point> {

	@Override
	public boolean test(Point t) {
		
		return t.getX() == t.getY();
	}

}
