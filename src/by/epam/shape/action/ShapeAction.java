package by.epam.shape.action;

import by.epam.shape.entity.Shape;
import by.epam.shape.exeption.ShapeException;

public interface ShapeAction {
    double findSquare(Shape shape) throws ShapeException;

    double findVolume(Shape shape) throws ShapeException;
}

