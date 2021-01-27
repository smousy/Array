package com.epam.firstTask.service;

import com.epam.firstTask.entity.ArrayEntity;
import com.epam.firstTask.exeption.ArrayActionExeption;

public class Edit {
    public ArrayEntity changePrimeElementToNull(ArrayEntity inputArray) throws ArrayActionExeption {
        if(inputArray!=null){
            for (int i = 0; i < inputArray.sizeArray(); i++) {
                int element = inputArray.getElement(i);
                if (primeCheck(element)) {
                    inputArray.changeElement(i, 0);
                }
            }
            // добавить лог
            return inputArray;
        }else{
            // добавить лог
            throw new ArrayActionExeption("Null array");
        }

    }

    private boolean primeCheck(int num) {
        int temp;
        for (int i = 2; i <= num / 2; i++) {
            temp = num % i;
            if (temp == 0) {
                return false;
            }
        }
        return true;
    }
}
