package by.epam.shape.entity;

import by.epam.shape.exeption.ShapeException;
import by.epam.shape.observer.ConeEvent;
import by.epam.shape.observer.Observable;
import by.epam.shape.observer.Observer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Cone extends Shape implements Observable {
    public static Logger logger = LogManager.getLogger();
    private Point topPoint;
    private Point basePoint;
    private int radius;
    private int id;
    private String name = "nameless";
    private List<Observer> observers = new ArrayList<>();

    public Cone(Point topPoint, Point basePoint, int radius) {
        this.topPoint = topPoint;
        this.basePoint = basePoint;
        this.radius = radius;
    }

    public Cone(Point topPoint, Point basePoint, int radius, String name) {
        this.topPoint = topPoint;
        this.basePoint = basePoint;
        this.radius = radius;
        this.name = name;
    }

    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Cone ");
        stringBuilder.append(name).append(":");
        stringBuilder.append("top point = ").append(topPoint.toString()).append(", ");
        stringBuilder.append("base point = ").append(basePoint.toString()).append(", ");
        stringBuilder.append("radius = ").append(radius).append(";");
        return stringBuilder.toString();
    }

    @Override
    public void attach(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        ConeEvent event = new ConeEvent(this);
        for (Observer observer : observers) {
            try {
                observer.parameterChanged(event);
            } catch (ShapeException e) {
                logger.log(Level.ERROR, "exception impossible");
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cone other = (Cone) obj;
        if (topPoint == null) {
            if (other.topPoint != null)
                return false;
        } else if (!topPoint.equals(other.topPoint))
            return false;
        if (basePoint == null) {
            if (other.basePoint != null)
                return false;
        } else if (!basePoint.equals(other.basePoint))
            return false;
        if (radius == 0) {
            if (other.radius != 0)
                return false;
        } else if (radius != other.radius)
            return false;
        return true;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((topPoint == null) ? 0 : topPoint.hashCode());
        result = prime * result + ((basePoint == null) ? 0 : basePoint.hashCode());
        long temp;
        temp = Double.doubleToLongBits(radius);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public Point getTopPoint() {
        return topPoint;
    }

    public void setTopPoint(Point topPoint) {
        this.topPoint = topPoint;
        notifyObservers();
    }

    public Point getBasePoint() {
        return basePoint;
    }

    public void setBasePoint(Point basePoint) {
        this.basePoint = basePoint;
        notifyObservers();
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        notifyObservers();
    }

}

