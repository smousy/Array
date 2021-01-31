package by.epam.firstTask.reader;

import by.epam.firstTask.exeption.FileExeption;
import by.epam.firstTask.exeption.InvalidCharacterExeption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayReader {
    static Logger logger = LogManager.getLogger();

    public int[] ConsoleArrayRead() throws InvalidCharacterExeption {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array size: ");
        int arraySize = scanner.nextInt();
        if (arraySize > 0) {
            int[] resultArray = new int[arraySize];
            System.out.println("Input numbers: ");
            for (int i = 0; i < arraySize; i++) {
                resultArray[i] = scanner.nextInt();
            }
            return resultArray;
        } else {
            throw new InvalidCharacterExeption("wrong array size");
        }
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
            logger.info("Read file " + path + " is successful");
            return converter.convertToInt(arrays);
        } catch (IOException ex) {
            logger.error("failed reading file " + path);
            throw new FileExeption("File " + path + " error");
        }
    }
}
