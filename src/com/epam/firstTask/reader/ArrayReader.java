package com.epam.firstTask.reader;

import java.util.Scanner;

public class ArrayReader {
    public String[] ConsoleArrayRead(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array size: ");
        int arraySize = scanner.nextInt();
        String[] resultArray = new String[arraySize];
        System.out.println("Input numbers: ");
        for(int i=0; i<arraySize; i++) {
            resultArray[i] = scanner.next();
        }
        return resultArray;
    }
}
