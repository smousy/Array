package by.epam.firstTask.exeption;

public class ArrayActionExeption extends Exception {
    public ArrayActionExeption() {
    }

    public ArrayActionExeption(String message) {
        super(message);
    }

    public ArrayActionExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayActionExeption(Throwable cause) {
        super(cause);
    }
}
