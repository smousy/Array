package by.epam.shape.comparator;

import by.epam.shape.action.ShapeAction;
import by.epam.shape.action.impl.ConeAction;
import by.epam.shape.entity.Cone;
import by.epam.shape.entity.Shape;
import by.epam.shape.exeption.ShapeException;

import java.util.Comparator;

public enum ConeComparator implements Comparator<Shape> {
    ID {
        @Override
        public int compare(Shape shape1, Shape shape2) {
            return Long.compare(shape1.getShapeId(), shape2.getShapeId());
        }
    },
    VOLUE {
        @Override
        public int compare(Shape shape1, Shape shape2) {
            ShapeAction action = new ConeAction();
            int result;
            try {
                result = Double.compare(action.findVolume(shape1), action.findVolume(shape2));
            } catch (ShapeException e) {
                throw new NullPointerException();
            }
            return result;
        }
    },
    SQUARE {
        @Override
        public int compare(Shape shape1, Shape shape2) {
            ShapeAction action = new ConeAction();
            int result;
            try {
                result = Double.compare(action.findSquare(shape1), action.findSquare(shape2));
            } catch (ShapeException e) {
                throw new NullPointerException();
            }
            return result;
        }
    },
    POINT_TOP_X {
        @Override
        public int compare(Shape shape1, Shape shape2) {
            Cone cone1 = (Cone) shape1;
            Cone cone2 = (Cone) shape2;
            return Double.compare(cone1.getTopPoint().getX(), cone2.getTopPoint().getX());
        }
    },
    POINT_TOP_Y {
        @Override
        public int compare(Shape shape1, Shape shape2) {
            Cone cone1 = (Cone) shape1;
            Cone cone2 = (Cone) shape2;
            return Double.compare(cone1.getTopPoint().getY(), cone2.getTopPoint().getY());
        }
    },
    POINT_TOP_Z {
        @Override
        public int compare(Shape shape1, Shape shape2) {
            Cone cone1 = (Cone) shape1;
            Cone cone2 = (Cone) shape2;
            return Double.compare(cone1.getTopPoint().getZ(), cone2.getTopPoint().getZ());
        }
    }
}
