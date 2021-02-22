package by.epam.shape.action.impl;

import by.epam.shape.action.PointAction;
import by.epam.shape.action.ShapeAction;
import by.epam.shape.entity.Cone;
import by.epam.shape.entity.Point;
import by.epam.shape.entity.Shape;
import by.epam.shape.exeption.ShapeException;

import static java.lang.StrictMath.pow;

public class ConeAction implements ShapeAction {
    @Override
    public double findSquare(Shape shape) throws ShapeException {
        Cone cone = (Cone) shape;
        double radius = cone.getRadius();
        Point top = cone.getTopPoint();
        Point base = cone.getBasePoint();
        double height = PointAction.computeDistanceBetweenPoints(top, base);
        return 3.14 * radius * (radius + pow(pow(radius, 2) + pow(height, 2), 2));
    }

    @Override
    public double findVolume(Shape shape) throws ShapeException {
        Cone cone = (Cone) shape;
        double radius = cone.getRadius();
        Point top = cone.getTopPoint();
        Point base = cone.getBasePoint();
        double height = PointAction.computeDistanceBetweenPoints(top, base);
        return (3.14 * height * radius * radius) / 3;
    }

    public boolean onPlane(Shape shape) {
        Cone cone = (Cone) shape;
        Point base = cone.getBasePoint();
        boolean check = false;
        if (base.getX() == 0 | base.getZ() == 0 | base.getY() == 0) {
            check = true;
        }
        return check;
    }

    double volumeUpXY(Shape shape) throws ShapeException {
        Cone cone = (Cone) shape;
        Point base = cone.getBasePoint();
        Point top = cone.getTopPoint();
        double volume = findVolume(cone);
        if (base.getZ() < 0 & top.getZ() > 0) {
            double height = PointAction.computeDistanceBetweenPoints(top, base);
            double radius = cone.getRadius();
            Point plane = new Point(base.getX(), base.getY(), 0);
            double newHeight = PointAction.computeDistanceBetweenPoints(top, plane);
            double newRadius = (newHeight * radius) / height;
            volume = (3.14 * newHeight * newRadius * newRadius) / 3;
        } else {
            if (base.getZ() > 0) {
                volume = findVolume(cone);
            }
            if (top.getZ() < 0) {
                volume = 0;
            }
        }
        return volume;
    }
}

