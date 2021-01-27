package com.epam.firstTask.creator;

import com.epam.firstTask.entity.ArrayEntity;
import com.epam.firstTask.reader.ArrayReader;

public class ArrayCreator {
    public ArrayEntity createArray() {
        ArrayReader arrayReader = new ArrayReader();
        return new ArrayEntity(arrayReader.ConsoleArrayRead());
    }

    public ArrayEntity createArray(String path) {
        ArrayReader arrayReader = new ArrayReader();
        return new ArrayEntity(arrayReader.fileArrayRead(path));
    }
}
