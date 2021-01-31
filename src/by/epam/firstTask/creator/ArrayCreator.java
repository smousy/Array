package by.epam.firstTask.creator;

import by.epam.firstTask.entity.ArrayEntity;
import by.epam.firstTask.exeption.FileExeption;
import by.epam.firstTask.exeption.InvalidCharacterExeption;
import by.epam.firstTask.reader.ArrayReader;

public class ArrayCreator {
    public ArrayEntity createArray() throws InvalidCharacterExeption {
        ArrayReader arrayReader = new ArrayReader();
        return new ArrayEntity(arrayReader.ConsoleArrayRead());
    }

    public ArrayEntity createArray(String path) throws FileExeption {
        ArrayReader arrayReader = new ArrayReader();
        try {
            return new ArrayEntity(arrayReader.fileArrayRead(path));
        } catch (FileExeption fileExeption) {
            throw new FileExeption("file" + path + "doesn't exist");
        }
    }
}
