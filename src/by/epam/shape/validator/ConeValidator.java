package by.epam.shape.validator;

import by.epam.shape.entity.Point;

public class ConeValidator {

    public static boolean pointsForCone(Point top, Point base, int radius) {
        boolean validation = false;
        if (radius > 0) {
            if (top.getX() == base.getX() && top.getY() == base.getY()) {
                validation = true;
            } else if (top.getY() == base.getY() && top.getZ() == base.getZ()) {
                validation = true;
            } else if (top.getX() == base.getX() && top.getZ() == base.getZ()) {
                validation = true;
            }
        }
        return validation;
    }


}