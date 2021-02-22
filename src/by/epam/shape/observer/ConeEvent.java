package by.epam.shape.observer;

import by.epam.shape.entity.Cone;

import java.util.EventObject;

public class ConeEvent extends EventObject {
    private static final long serialVersionUID = 1L;

    public ConeEvent(Cone source) {
        super(source);
    }

    @Override
    public Cone getSource() {
        return (Cone) super.getSource();
    }
}