package test.epam.firstTask.service;

import by.epam.firstTask.entity.ArrayEntity;
import by.epam.firstTask.exeption.InvalidCharacterExeption;
import by.epam.firstTask.service.Sort;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SortTest {
    Sort sort = new Sort();

    @Test(dataProvider = "arraysForSorting")
    public void shakerSortTest(ArrayEntity sortedArray, ArrayEntity unsortedArray) throws InvalidCharacterExeption {
        sort.shakerSort(unsortedArray);
        Assert.assertEquals(sortedArray.getArray(),unsortedArray.getArray());
    }

    @Test(dataProvider = "arraysForSorting")
    public void shellSortTest(ArrayEntity sortedArray, ArrayEntity unsortedArray) throws InvalidCharacterExeption {
        sort.shellSort(unsortedArray);
        Assert.assertEquals(sortedArray.getArray(),unsortedArray.getArray());
    }

    @Test(dataProvider = "arraysForSorting")
    public void gnomeSortTest(ArrayEntity sortedArray, ArrayEntity unsortedArray) throws InvalidCharacterExeption {
        sort.gnomeSort(unsortedArray);
        Assert.assertEquals(sortedArray.getArray(),unsortedArray.getArray());
    }

    @DataProvider(name = "arraysForSorting")
    public Object[] createArraysForSorting() {
        ArrayEntity array1 = new ArrayEntity();
        array1.setArray(10, 7, 3, 0);
        ArrayEntity array2 = new ArrayEntity();
        array2.setArray(547, 234, 98, -123, 34);
        ArrayEntity array3 = new ArrayEntity();
        array3.setArray(1, 3, 7, 5, 2);
        ArrayEntity array4 = new ArrayEntity();
        array4.setArray(-4, -2, -7);
        ArrayEntity array1answer = new ArrayEntity();
        array1answer.setArray(0, 3, 7, 10);
        ArrayEntity array2answer = new ArrayEntity();
        array2answer.setArray(-123, 34, 98, 234, 547);
        ArrayEntity array3answer = new ArrayEntity();
        array3answer.setArray(1, 2, 3, 5, 7);
        ArrayEntity array4answer = new ArrayEntity();
        array4answer.setArray(-7, -4, -2);
        return new Object[][] { { array1answer, array1},
                {array2answer,array2},
                {array3answer, array3},
                {array4answer, array4}
        };
    }


}
