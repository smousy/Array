package by.epam.shape.observer;

import by.epam.shape.action.ShapeAction;
import by.epam.shape.action.impl.ConeAction;
import by.epam.shape.entity.Cone;
import by.epam.shape.exeption.ShapeException;
import by.epam.shape.warehouse.ShapeValue;
import by.epam.shape.warehouse.Warehouse;

import java.util.EventObject;

public class ConeObserver implements Observer {
    @Override
    public void parameterChanged(ConeEvent event) throws ShapeException {
        if (event == null) {
            throw new ShapeException("argument is null");
        }
        Cone cone = event.getSource();
        ShapeAction action = new ConeAction();
        double square = action.findSquare(cone);
        double volume = action.findVolume(cone);
        ShapeValue shapeValue = new ShapeValue(volume, square);
        Warehouse warehouse = Warehouse.getWarehouse();
        warehouse.putShapeValue(cone.getShapeId(), shapeValue);
    }
}