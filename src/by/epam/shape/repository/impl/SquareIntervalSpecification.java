package by.epam.shape.repository.impl;

import by.epam.shape.action.ShapeAction;
import by.epam.shape.action.impl.ConeAction;
import by.epam.shape.entity.Shape;
import by.epam.shape.exeption.ShapeException;
import by.epam.shape.repository.Specification;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SquareIntervalSpecification implements Specification {
    private ShapeAction shapeAction;
    private double squareFrom;
    private double squareTo;

    public SquareIntervalSpecification(double squareFrom, double squareTo) {
        this.squareFrom = squareFrom;
        this.squareTo = squareTo;
        shapeAction = new ConeAction();
    }

    @Override
    public boolean specify(Shape shape) {
        boolean result;
        try {
            double square = shapeAction.findSquare(shape);
            result = square >= squareFrom && square <= squareTo;
        } catch (ShapeException e) {
            result = false;
        }
        return result;
    }
}
