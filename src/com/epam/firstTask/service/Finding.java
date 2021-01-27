package com.epam.firstTask.service;

import com.epam.firstTask.entity.ArrayEntity;

public class Finding {
    public int findMinElement(ArrayEntity array) {
        int minElement = array.getElement(0);
        for (int i = 0; i < array.sizeArray(); i++) {
            if (array.getElement(i) < minElement) {
                minElement = array.getElement(i);
            }
        }
        // добавить лог
        return minElement;
    }

    public int findMaxElement(ArrayEntity array) {
        int maxElement = array.getElement(0);
        for (int i = 0; i < array.sizeArray(); i++) {
            if (array.getElement(i) > maxElement) {
                maxElement = array.getElement(i);
            }
        }
        // добавить лог
        return maxElement;
    }

    public double findAverage(ArrayEntity inputArray) {
        int sum = findSum(inputArray);
        double size = (double) inputArray.sizeArray();
        return sum / size;
        // добавить лог
    }

    public int findSum(ArrayEntity inputArray) {
        int sumCode = 0;
        for (int i = 0; i < inputArray.sizeArray(); i++) {
            int element = inputArray.getElement(i);
            sumCode += element;
        }
        // добавить лог
        return sumCode;
    }

    public int findNumberOfPositiveElements(ArrayEntity inputArray) {
        int number = 0;
        for (int i = 0; i < inputArray.sizeArray(); i++) {
            int element = inputArray.getElement(i);
            if (element > 0) {
                number++;
            }
        }
        // добавить лог
        return number;
    }

    public int findNumberOfNegativeElements(ArrayEntity inputArray) {
        int number = 0;
        for (int i = 0; i < inputArray.sizeArray(); i++) {
            int element = inputArray.getElement(i);
            if (element < 0) {
                number++;
            }
        }
        // добавить лог
        return number;
    }
}
