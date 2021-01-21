package com.epam;

import com.epam.firstTask.creator.ArrayCreator;
import com.epam.firstTask.entity.ArrayEntity;
import com.epam.firstTask.service.Edit;
import com.epam.firstTask.service.Finding;

public class Main {

    public static void main(String[] args) {
        ArrayCreator creator = new ArrayCreator();
        ArrayEntity array = creator.createArray();
        Finding finding = new Finding();
        System.out.println("min");
        System.out.println(finding.findMinElement(array));
        System.out.println("max");
        System.out.println(finding.findMaxElement(array));
        System.out.println("average");
        System.out.println(finding.findAverage(array));
        System.out.println("sum");
        System.out.println(finding.findSum(array));
        System.out.println("pos");
        System.out.println(finding.findNumberOfPositiveElements(array));
        System.out.println("neg");
        System.out.println(finding.findNumberOfNegativeElements(array));
        Edit edit = new Edit();
        System.out.println("prime");
        array=edit.changePrimeASCIICodeToNull(array);
        String[] arr = array.getArray();
        for (String s : arr) {
            System.out.println(s);
        }

    }
}
