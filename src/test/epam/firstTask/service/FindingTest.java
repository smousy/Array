package test.epam.firstTask.service;

import by.epam.firstTask.entity.ArrayEntity;
import by.epam.firstTask.exeption.InvalidCharacterExeption;
import by.epam.firstTask.service.Finding;
import by.epam.firstTask.service.FindingStream;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FindingTest {
    Finding finding = new Finding();

    @Test(dataProvider = "arraysForMin")
    public void findMinElementTestTest(int expected, ArrayEntity testArray) throws InvalidCharacterExeption {
        int actual = finding.findMinElement(testArray);
        Assert.assertEquals(expected,actual);
    }

    @DataProvider(name = "arraysForMin")
    public Object[] createArraysForMin() {
        ArrayEntity array1 = new ArrayEntity();
        array1.setArray(10, 7, 3, 0);
        ArrayEntity array2 = new ArrayEntity();
        array2.setArray(547, 234, 98, -123, 34);
        ArrayEntity array3 = new ArrayEntity();
        array3.setArray(1, 3, 7, 5, 2);
        ArrayEntity array4 = new ArrayEntity();
        array4.setArray(-4, -2, -7);
        return new Object[][] { { 0, array1},
                {-123,array2},
                {1, array3},
                {-7, array4}
        };
    }

    @Test(dataProvider = "arraysForMax")
    public void findMaxElementTest(int expected, ArrayEntity testArray) throws InvalidCharacterExeption {
        int actual = finding.findMaxElement(testArray);
        Assert.assertEquals(expected,actual);
    }

    @DataProvider(name = "arraysForMax")
    public Object[] createArraysForMax() {
        ArrayEntity array1 = new ArrayEntity();
        array1.setArray(10, 7, 3, 0);
        ArrayEntity array2 = new ArrayEntity();
        array2.setArray(547, 234, 98, -123, 34);
        ArrayEntity array3 = new ArrayEntity();
        array3.setArray(1, 3, 7, 5, 2);
        ArrayEntity array4 = new ArrayEntity();
        array4.setArray(-4, -2, -7);
        return new Object[][] { { 10, array1},
                {547,array2},
                {7, array3},
                {-2, array4}
        };
    }

    @Test(dataProvider = "arraysForfindAverage")
    public void findAverageTest(double expected, ArrayEntity testArray) throws InvalidCharacterExeption {
        double actual = finding.findAverage(testArray);
        Assert.assertEquals(expected,actual);
    }

    @DataProvider(name = "arraysForfindAverage")
    public Object[] createArraysForfindAverage() {
        ArrayEntity array1 = new ArrayEntity();
        array1.setArray(10, 7, 3, 0);
        ArrayEntity array2 = new ArrayEntity();
        array2.setArray(547, 234, 98, -123, 34);
        ArrayEntity array3 = new ArrayEntity();
        array3.setArray(1, 3, 7, 5, 2);
        ArrayEntity array4 = new ArrayEntity();
        array4.setArray(-4, -2, -7);
        return new Object[][] { { 5.0, array1},
                {158.0,array2},
                {3.6, array3},
                {-4.333333333333333333, array4}
        };
    }

    @Test(dataProvider = "arraysForFindSum")
    public void findSumTest(double expected, ArrayEntity testArray) throws InvalidCharacterExeption {
        double actual = finding.findSum(testArray);
        Assert.assertEquals(expected,actual);
    }

    @DataProvider(name = "arraysForFindSum")
    public Object[] createArraysForFindSum() {
        ArrayEntity array1 = new ArrayEntity();
        array1.setArray(10, 7, 3, 0);
        ArrayEntity array2 = new ArrayEntity();
        array2.setArray(547, 234, 98, -123, 34);
        ArrayEntity array3 = new ArrayEntity();
        array3.setArray(1, 3, 7, 5, 2);
        ArrayEntity array4 = new ArrayEntity();
        array4.setArray(-4, -2, -7);
        return new Object[][] { { 20, array1},
                {790,array2},
                {18, array3},
                {-13, array4}
        };
    }

    @Test(dataProvider = "arraysForFindNumberOfPositiveElements")
    public void findNumberOfPositiveElementsTest(double expected, ArrayEntity testArray) throws InvalidCharacterExeption {
        double actual = finding.findNumberOfPositiveElements(testArray);
        Assert.assertEquals(expected,actual);
    }

    @DataProvider(name = "arraysForFindNumberOfPositiveElements")
    public Object[] createArraysForFindNumberOfPositiveElements() {
        ArrayEntity array1 = new ArrayEntity();
        array1.setArray(10, 7, 3, 0);
        ArrayEntity array2 = new ArrayEntity();
        array2.setArray(547, 234, 98, -123, 34);
        ArrayEntity array3 = new ArrayEntity();
        array3.setArray(1, 3, 7, 5, 2);
        ArrayEntity array4 = new ArrayEntity();
        array4.setArray(-4, -2, -7);
        return new Object[][] { {3, array1},
                {4,array2},
                {5, array3},
                {0, array4}
        };
    }

    @Test(dataProvider = "arraysForFindNumberOfNegativeElements")
    public void findNumberOfNegativeElementsTest(double expected, ArrayEntity testArray) throws InvalidCharacterExeption {
        double actual = finding.findNumberOfNegativeElements(testArray);
        Assert.assertEquals(expected,actual);
    }

    @DataProvider(name = "arraysForFindNumberOfNegativeElements")
    public Object[] createArraysForNumberOfNegativeElements() {
        ArrayEntity array1 = new ArrayEntity();
        array1.setArray(10, 7, 3, 0);
        ArrayEntity array2 = new ArrayEntity();
        array2.setArray(547, 234, 98, -123, 34);
        ArrayEntity array3 = new ArrayEntity();
        array3.setArray(1, 3, 7, 5, 2);
        ArrayEntity array4 = new ArrayEntity();
        array4.setArray(-4, -2, -7);
        return new Object[][] { {0, array1},
                {1,array2},
                {0, array3},
                {3, array4}
        };
    }

}
