package by.epam.shape.warehouse;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class ShapeValue {
    private double volume;
    private double square;

    public ShapeValue(double volume, double square) {
        this.volume = volume;
        this.square = square;
    }

    public double getVolume() {
        return volume;
    }

    public double getSquare() {
        return square;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(volume);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(square);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ShapeValue other = (ShapeValue) obj;
        if (Double.doubleToLongBits(volume) != Double.doubleToLongBits(other.volume))
            return false;
        if (Double.doubleToLongBits(square) != Double.doubleToLongBits(other.square))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ShapeValues [volume=");
        builder.append(volume);
        builder.append(", square=");
        builder.append(square);
        builder.append("]");
        return builder.toString();
    }
}
