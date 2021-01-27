package com.epam;

import com.epam.firstTask.creator.ArrayCreator;
import com.epam.firstTask.entity.ArrayEntity;
import com.epam.firstTask.service.Edit;
import com.epam.firstTask.service.Finding;
import com.epam.firstTask.service.Sort;

public class Main {

    public static void main(String[] args) {
        ArrayCreator creator = new ArrayCreator();
        ArrayEntity array = creator.createArray();
        Finding finding = new Finding();
        /*System.out.println("min");
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
        array=edit.changePrimeElementToNull(array);
        System.out.println(array.toString());
        */
        System.out.println(array.toString());
        Sort sort = new Sort();
        sort.shakerSort(array);
        sort.gnomeSort(array);
        sort.shellSort(array);
        System.out.println(array.toString());


    }
}
