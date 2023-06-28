package telran.shapes;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Canvas implements Shape, Iterable<Shape> {
    private Shape[] shapes = new Shape[0];
    private class CanvasIterator implements Iterator<Shape> {
    private int index = 0;
    	
    	

		@Override
		public boolean hasNext() {
			
			return index < shapes.length;
		}

		@Override
		public Shape next() {
			
			while(!hasNext()) {
				throw new NoSuchElementException();
			}
			Shape currentShape = shapes[index];
			index++;
			return currentShape;
		}
		@Override
		public void remove() {
			if (index <= 0) {
		        throw new IllegalStateException();
		    }
		    int removeIndex = index - 1;
		    Shape[] newShapes = new Shape[shapes.length - 1];
		    System.arraycopy(shapes, 0, newShapes, 0, removeIndex);
		    System.arraycopy(shapes, removeIndex + 1, newShapes, removeIndex, shapes.length - removeIndex - 1);
		    shapes = newShapes;
		    index--;
		}
    	
    }
	@Override
	public int perimeter() {
		int res = 0;
		for(Shape shape:shapes) {
			res += shape.perimeter();
		}
		return res;
	}

	@Override
	public int square() {
		int res = 0;
		for(Shape shape:shapes) {
			res += shape.square();
		}
		return res;
	}

	@Override
	public Iterator<Shape> iterator() {
		
		return new CanvasIterator();
	}
	public void addShape(Shape shape) {
		Shape[] newShapes = new Shape[shapes.length + 1];
		System.arraycopy(shapes, 0, newShapes, 0, shapes.length);
		newShapes[shapes.length] = shape;
		shapes = newShapes;
	}
    public boolean removeIf(Predicate<Shape> predicate) {
    	Iterator<Shape> iterator = iterator();
    	boolean isRemoved = false;
    	
    	while (iterator.hasNext()) {
            Shape shape = iterator.next();
            if (predicate.test(shape)) {
                iterator.remove();
                isRemoved = true;
            }
        }
    	return isRemoved;
    }
    public boolean removeNestedCanvases() {
    	return removeIf(shape -> shape instanceof Canvas);
    }

}