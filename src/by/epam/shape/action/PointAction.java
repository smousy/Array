package by.epam.shape.action;

import by.epam.shape.entity.Point;
import by.epam.shape.exeption.ShapeException;

public class PointAction {
    public static double computeDistanceBetweenPoints(Point pointA, Point pointB)
            throws ShapeException {
        if (pointA == null || pointB == null) {
            throw new ShapeException("point is null");
        }
        double distanceBetweenPoints = Math.sqrt(Math.pow(pointB.getX() - pointA.getX(), 2)
                + Math.pow(pointB.getY() - pointA.getY(), 2)
                + Math.pow(pointB.getZ() - pointA.getZ(), 2));
        return distanceBetweenPoints;
    }

}

