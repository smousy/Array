package by.epam.shape.repository.impl;

import by.epam.shape.action.ShapeAction;
import by.epam.shape.action.impl.ConeAction;
import by.epam.shape.entity.Shape;
import by.epam.shape.exeption.ShapeException;
import by.epam.shape.repository.Specification;

public class ShapeIdIntervalSpecification implements Specification {
    private double shapeIdFrom;
    private double shapeIdTo;

    public ShapeIdIntervalSpecification(double shapeIdFrom, double shapeIdTo) {
        this.shapeIdFrom = shapeIdFrom;
        this.shapeIdTo = shapeIdTo;
    }

    @Override
    public boolean specify(Shape shape) {
        boolean result = shape.getShapeId() >= shapeIdFrom && shape.getShapeId() <= shapeIdTo;
        return result;
    }
}
