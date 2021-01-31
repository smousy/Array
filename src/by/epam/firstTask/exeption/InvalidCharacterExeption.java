package by.epam.firstTask.exeption;

public class InvalidCharacterExeption extends Exception {
    public InvalidCharacterExeption() {
    }

    public InvalidCharacterExeption(String message) {
        super(message);
    }

    public InvalidCharacterExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCharacterExeption(Throwable cause) {
        super(cause);
    }

}
