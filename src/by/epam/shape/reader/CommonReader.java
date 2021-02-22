package by.epam.shape.reader;

import by.epam.shape.entity.Point;
import by.epam.shape.exeption.ShapeException;

import java.util.List;

public interface CommonReader {
    List<String> readAll(String path) throws ShapeException;
}
