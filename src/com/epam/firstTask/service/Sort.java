package com.epam.firstTask.service;

import com.epam.firstTask.entity.ArrayEntity;

public class Sort {
    public void shakerSort(ArrayEntity array) {
        // добавить лог
        int begin = 0;
        int end = array.sizeArray();
        int size = end - begin;
        if (size > 1) {
            begin--;
            end--;
            boolean check = true;
            while (check) {
                check = false;
                begin++;
                for (int i = begin; i < end; i++) {
                    if (array.getElement(i) > array.getElement(i + 1)) {
                        int temp = array.getElement(i + 1);
                        array.changeElement(i + 1, array.getElement(i));
                        array.changeElement(i, temp);
                        check = true;
                    }
                }
                if (check) {
                    end--;
                    for (int i = end; i > begin; i--) {
                        if (array.getElement(i) < array.getElement(i - 1)) {
                            int temp = array.getElement(i - 1);
                            array.changeElement(i - 1, array.getElement(i));
                            array.changeElement(i, temp);
                            check = true;
                        }
                    }
                }
            }
        }
    }

    public void gnomeSort(ArrayEntity array) {
        // добавить лог
        int begin = 0;
        int end = array.sizeArray();
        int i = begin;
        while (i < end) {
            int right = array.getElement(i);
            if (i == begin || array.getElement(i - 1) <= right) {
                i++;
            } else {
                int left = array.getElement(i - 1);
                array.changeElement(i - 1, right);
                array.changeElement(i, left);
                i--;
            }
        }
    }

    public void shellSort(ArrayEntity array) {
        // добавить лог
        int size = array.sizeArray();
        for (int gap = size / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < size; i++) {
                int temp = array.getElement(i);
                int j;
                for (j = i; j >= gap && array.getElement(j - gap) > temp; j -= gap) {
                    int checkElement = array.getElement(j - gap);
                    array.changeElement(j, checkElement);
                }
                array.changeElement(j, temp);
            }
        }
    }
}
