package com.epam.firstTask.reader;

import com.epam.firstTask.exeption.FileExeption;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayReader {
    public int[] ConsoleArrayRead() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array size: ");
        int arraySize = scanner.nextInt();
        int[] resultArray = new int[arraySize];
        System.out.println("Input numbers: ");
        for (int i = 0; i < arraySize; i++) {
            resultArray[i] = scanner.nextInt();
        }
        return resultArray;
    }

    public int[] fileArrayRead(String path) throws FileExeption {
        ArrayList<String> arrays = new ArrayList<>();
        File file = new File(path);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String array = scanner.nextLine();
                arrays.add(array);
            }
            Converter converter = new Converter();
            return converter.convertToInt(arrays);

            //add logger

        } catch (IOException ex) {
            throw new FileExeption("File error");
            //add logger
        }
    }
}
