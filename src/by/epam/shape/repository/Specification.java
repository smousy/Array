package by.epam.shape.repository;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Shape;
import by.epam.shape.exeption.ShapeException;

import java.util.List;

public interface Specification {
    boolean specify(Shape shape);
}
