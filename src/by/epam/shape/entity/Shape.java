package by.epam.shape.entity;

import by.epam.shape.util.GeneratorId;

public abstract class Shape {
    private String shapeID;

    public String Shape() {
        return shapeID;
    }

    private long shapeId;

    public Shape() {
        this.shapeId = GeneratorId.generateId();
    }

    public long getShapeId() {
        return shapeId;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getName());
        builder.append(" shapeId=");
        builder.append(shapeID);
        return builder.toString();
    }
}
