package com.epam.firstTask.service;

import com.epam.firstTask.entity.ArrayEntity;

public class Edit {
    public ArrayEntity changePrimeASCIICodeToNull(ArrayEntity inputArray){
        String[] array= inputArray.getArray();
        for(int i=0; i<array.length; i++){
            String element = inputArray.getElement(i);
            char[] chars = element.toCharArray();
            int sumStringElementCode=0;
            for (char aChar : chars) {
                sumStringElementCode += (int) aChar;
            }
            if(primeCheck(sumStringElementCode)){
                array[i] = null;
            }
        }
        inputArray.setArray(array);
        return inputArray;
    }

    private boolean primeCheck(int num){
        int temp;
        for(int i=2; i<num/2; i++){
            temp=num%i;
            if(temp==0){
                return false;
            }
        }
        return true;
    }
}
