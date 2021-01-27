package com.epam.firstTask.entity;

public class ArrayEntity {
    private int[] array;

    public int[] getArray() {
        return array;
    }

    public void setArray(int... array) {
        this.array = array;
    }

    public int getElement(int index) {
        if (index > array.length - 1 || index < 0) {
            //исключение
        }
        return this.array[index];
    }

    public ArrayEntity(int... array) {
        this.array = array;
    }

    public int sizeArray() {
        return this.array.length;
    }

    public void changeElement(int index, int value) {
        if (index > array.length - 1 || index < 0) {
            //исключение
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
}
