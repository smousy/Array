package by.epam.shape.observer;

import by.epam.shape.entity.Point;
import by.epam.shape.exeption.ShapeException;
import org.xml.sax.SAXException;

public interface Observer {
    void parameterChanged(ConeEvent event) throws ShapeException;
}