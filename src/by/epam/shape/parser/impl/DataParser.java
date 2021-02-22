package by.epam.shape.parser.impl;

import by.epam.shape.action.PointAction;
import by.epam.shape.action.ShapeAction;
import by.epam.shape.entity.Cone;
import by.epam.shape.entity.Point;
import by.epam.shape.entity.Shape;
import by.epam.shape.exeption.ShapeException;
import by.epam.shape.parser.CommonParser;
import by.epam.shape.validator.ConeValidator;
import by.epam.shape.validator.DataValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.StrictMath.pow;

public class DataParser implements CommonParser {
    public static Logger logger = LogManager.getLogger();

    @Override
    public List<Point[]> parseList(List<String> data) throws ShapeException {
        if (data == null || data.isEmpty()) {
            throw new ShapeException("null or empty argument");
        }
        List<Point[]> coneData = new ArrayList<Point[]>();
        Point[] points;
        for (String lineData : data) {
            try {
                points = parseLine(lineData);
                coneData.add(points);
            } catch (ShapeException e) {
                logger.log(Level.ERROR, lineData + "isn't validate for creation a cone");
            }
        }
        if (coneData.isEmpty()) {
            throw new ShapeException("no data to create a cone");
        }
        return coneData;
    }

    @Override
    public Point[] parseLine(String lineData) throws ShapeException {
        if (!DataValidator.pointDataValidator(lineData)) {
            throw new ShapeException(lineData + " is not suitable for creating a triangle");
        }
        String[] linePointCoordinate = lineData.split(" ");
        Point[] points = new Point[2];
        int numberPoint = 0;
        int numberCoordinate = 0;
        while (numberPoint < points.length) {
            points[numberPoint] = new Point((int) Double.parseDouble(linePointCoordinate[numberCoordinate]),
                    (int) Double.parseDouble(linePointCoordinate[numberCoordinate + 1]),
                    (int) Double.parseDouble(linePointCoordinate[numberCoordinate + 2]));
            numberPoint++;
            numberCoordinate = numberCoordinate + 3;
        }
        int radius = (int) Double.parseDouble(linePointCoordinate[numberCoordinate]);
        if (!ConeValidator.pointsForCone(points[0], points[1], radius)) {
            throw new ShapeException(Arrays.toString(points) + " don't form cone");
        }
        return points;
    }
}

