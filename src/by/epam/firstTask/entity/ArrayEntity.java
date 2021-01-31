package by.epam.firstTask.entity;

import by.epam.firstTask.exeption.InvalidCharacterExeption;

import java.util.Arrays;

public class ArrayEntity {
    private int[] array;

    public int[] getArray() {
        return array;
    }

    public void setArray(int... array) {
        this.array = array;
    }

    //нужны ли здесь исключения?
    public int getElement(int index) throws InvalidCharacterExeption {
        if (index > array.length - 1 || index < 0) {
            throw new InvalidCharacterExeption("wrong index");
        }
        return this.array[index];
    }

    public ArrayEntity(int... array) {
        this.array = array;
    }

    public int sizeArray() {
        return this.array.length;
    }

    public void changeElement(int index, int value) throws InvalidCharacterExeption {
        if (index > array.length - 1 || index < 0) {
            throw new InvalidCharacterExeption("wrong index");
        }
        array[index] = value;
    }

    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int value : array) {
            string.append(value).append(" ");
        }
        return string.toString();
    }

    // разве так можно??
    public int hashCode() {
        return Arrays.hashCode(array);

    }
}
