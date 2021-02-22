package by.epam.shape.factory;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Shape;
import by.epam.shape.exeption.ShapeException;
import org.xml.sax.SAXException;

public abstract class ShapeFactory {
    public abstract Shape createShape(Point a, Point b, int r) throws SAXException, ShapeException;
}
