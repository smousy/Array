package test.epam.firstTask.service;

import by.epam.firstTask.entity.ArrayEntity;
import by.epam.firstTask.exeption.ArrayActionExeption;
import by.epam.firstTask.exeption.InvalidCharacterExeption;
import by.epam.firstTask.service.Edit;
import by.epam.firstTask.service.Finding;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditTest {
    Edit edit = new Edit();

    @Test(dataProvider = "arraysForChangePrimeElementToNull")
    public void changePrimeElementToNullTest(ArrayEntity expected, ArrayEntity testArray) throws InvalidCharacterExeption, ArrayActionExeption {
        ArrayEntity actual = edit.changePrimeElementToNull(testArray);
        Assert.assertEquals(expected.getArray(),actual.getArray());
    }

    @DataProvider(name = "arraysForChangePrimeElementToNull")
    public Object[] createArraysForChangePrimeElementToNull() {
        ArrayEntity array1 = new ArrayEntity();
        array1.setArray(10, 7, 3, 0);
        ArrayEntity array2 = new ArrayEntity();
        array2.setArray(547, 234, 98, -123, 34);
        ArrayEntity array3 = new ArrayEntity();
        array3.setArray(1, 3, 7, 5, 2);
        ArrayEntity array4 = new ArrayEntity();
        array4.setArray(-4, -2, -7);
        ArrayEntity array1answer = new ArrayEntity();
        array1answer.setArray(10, 0, 0, 0);
        ArrayEntity array2answer = new ArrayEntity();
        array2answer.setArray(0, 234, 98, -123, 34);
        ArrayEntity array3answer = new ArrayEntity();
        array3answer.setArray(0, 0, 0, 0, 0);
        ArrayEntity array4answer = new ArrayEntity();
        array4answer.setArray(-4, -2, -7);
        return new Object[][] { { array1answer, array1},
                {array2answer,array2},
                {array3answer, array3},
                {array4answer, array4}
        };
    }
}
