package by.epam.shape.observer;

import by.epam.shape.exeption.ShapeException;

public interface Observable {
    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObservers();
}