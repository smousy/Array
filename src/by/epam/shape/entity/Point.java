package by.epam.shape.entity;

public class Point {
    private int x;
    private int y;
    private int z;
    private String name;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point(int x, int y, int z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Point obj = (Point) o;
        if (this.x != obj.getX()) {
            return false;
        }
        if (this.y != obj.getY()) {
            return false;
        }
        if (this.z != obj.getZ()) {
            return false;
        }
        return true;
    }

    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Point ");
        stringBuilder.append(name).append(":");
        stringBuilder.append("x = ").append(x).append(", ");
        stringBuilder.append("y = ").append(y).append(", ");
        stringBuilder.append("z = ").append(z).append(";");
        return stringBuilder.toString();
    }

}
