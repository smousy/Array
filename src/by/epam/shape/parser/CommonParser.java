package by.epam.shape.parser;

import by.epam.shape.entity.Point;
import by.epam.shape.exeption.ShapeException;

import java.util.List;

public interface CommonParser {
    List<Point[]> parseList(List<String> data) throws ShapeException;

    Point[] parseLine(String lineData) throws ShapeException;

}
