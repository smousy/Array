package by.epam.shape.factory;

import by.epam.shape.entity.Cone;
import by.epam.shape.entity.Point;
import by.epam.shape.entity.Shape;
import by.epam.shape.exeption.ShapeException;
import by.epam.shape.validator.ConeValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeFactory extends ShapeFactory {
    public static Logger logger = LogManager.getLogger();

    @Override
    public Shape createShape(Point a, Point b, int r) throws ShapeException {
        if (a == null || b == null || r == 0 || !ConeValidator.pointsForCone(a, b, r)) {
            throw new ShapeException("error input data for creating a cone");
        }
        Cone cone = new Cone(a, b, r);
        logger.log(Level.INFO, "create shape" + cone.toString());
        return cone;
    }
}
