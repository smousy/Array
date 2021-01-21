package com.epam.firstTask.service;

import com.epam.firstTask.entity.ArrayEntity;

public class Finding {
    public String findMinElement(ArrayEntity array){
        String minElement = array.getElement(0);
        for(int i=0; i<array.getArray().length; i++){
            if(array.getElement(i).compareTo(minElement)<0){
                minElement = array.getElement(i);
            }
        }
        return minElement;
    }

    public String findMaxElement(ArrayEntity array){
        String maxElement = array.getElement(0);
        for(int i=0; i<array.getArray().length; i++){
            if(array.getElement(i).compareTo(maxElement)>0){
                maxElement = array.getElement(i);
            }
        }
        return maxElement;
    }

    public double findAverage(ArrayEntity inputArray){
        String[] array= inputArray.getArray();
        return findSum(inputArray)/(double)array.length;
    }

    public int findSum(ArrayEntity inputArray){
        String[] array= inputArray.getArray();
        int sumCode=0;
        for(int i=0; i<array.length; i++){
            String element = inputArray.getElement(i);
            int sumStringElementCode=getASCIICodeOfElement(element);
            sumCode+=sumStringElementCode;
        }
        return sumCode;
    }

    public int findNumberOfPositiveElements(ArrayEntity inputArray){
        String[] array= inputArray.getArray();
        int number=0;
        for(int i=0; i<array.length; i++) {
            String element = inputArray.getElement(i);
            int sumStringElementCode = getASCIICodeOfElement(element);
            if(sumStringElementCode>0){
                number++;
            }
        }
        return number;
    }

    public int findNumberOfNegativeElements(ArrayEntity inputArray){
        String[] array= inputArray.getArray();
        int number=0;
        for(int i=0; i<array.length; i++) {
            String element = inputArray.getElement(i);
            int sumStringElementCode = getASCIICodeOfElement(element);
            if(sumStringElementCode<0){
                number++;
            }
        }
        return number;
    }

    private int getASCIICodeOfElement(String element){
        char[] chars = element.toCharArray();
        int sumStringElementCode = 0;
        for (char aChar : chars) {
            sumStringElementCode += (int) aChar;
        }
        return sumStringElementCode;
    }
}
