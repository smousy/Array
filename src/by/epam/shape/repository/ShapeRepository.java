package by.epam.shape.repository;

import by.epam.shape.entity.Shape;
import by.epam.shape.exeption.ShapeException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShapeRepository {
    public static Logger logger = LogManager.getLogger();
    private final static ShapeRepository repository = new ShapeRepository();
    private List<Shape> shapes = new ArrayList<>();

    private ShapeRepository() {
    }

    public static ShapeRepository getShapeRepository() {
        return repository;
    }

    public boolean addShape(Shape shape) throws ShapeException {
        if (shape == null) {
            throw new ShapeException("shape repository cannot store null");
        }
        return shapes.add(shape);
    }

    public boolean removeShape(Shape shape) {
        return this.shapes.remove(shape);
    }

    public Shape setShape(int index, Shape shape) throws ShapeException {
        if (shape == null) {
            throw new ShapeException("shape repository cannot store null");
        }
        return shapes.set(index, shape);
    }

    public Shape getShape(int index) {
        return shapes.get(index);
    }

    public List<Shape> query(Specification specification) {
        List<Shape> requestedShapes = new ArrayList<Shape>();
        for (Shape shape : shapes) {
            if (specification.specify(shape)) {
                requestedShapes.add(shape);
            }
        }
        logger.log(Level.INFO, "requested shapes: " + requestedShapes.toString());
        return requestedShapes;
    }

    public List<Shape> sort(Comparator<Shape> comparator) {
        shapes.sort(comparator);
        logger.log(Level.INFO, "sorted shapes: " + shapes.toString());
        return shapes;
    }
}
