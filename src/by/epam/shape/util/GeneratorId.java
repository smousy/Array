package by.epam.shape.util;

public class GeneratorId {
    private static long idCounter;

    private GeneratorId() {
    }

    public static long generateId() {
        return ++idCounter;
    }

}
