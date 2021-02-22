package by.epam.shape.repository.impl;

import by.epam.shape.action.ShapeAction;
import by.epam.shape.action.impl.ConeAction;
import by.epam.shape.entity.Shape;
import by.epam.shape.exeption.ShapeException;
import by.epam.shape.repository.Specification;

public class VolumeIntervalSpecification implements Specification {
    private ShapeAction shapeAction;
    private double perimeterFrom;
    private double perimeterTo;

    public VolumeIntervalSpecification(double perimeterFrom, double perimeterTo) {
        this.perimeterFrom = perimeterFrom;
        this.perimeterTo = perimeterTo;
        shapeAction = new ConeAction();
    }

    @Override
    public boolean specify(Shape shape) {
        boolean result;
        try {
            double perimeter = shapeAction.findVolume(shape);
            result = perimeter >= perimeterFrom && perimeter <= perimeterTo;
        } catch (ShapeException e) {
            result = false;
        }
        return result;
    }
}
