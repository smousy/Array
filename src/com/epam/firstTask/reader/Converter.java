package com.epam.firstTask.reader;

import com.epam.firstTask.validation.Validator;

import java.util.ArrayList;
import java.util.Vector;

public class Converter {
    public int[] convertToInt(ArrayList<String> arrays) {
        Vector<Integer> array = new Vector<>();
        Validator validator = new Validator();
        for (String oneArray : arrays) {
            if(validator.checkString(oneArray)) {
                String[] arrayString = oneArray.split(" "); //может быть сделать табы?
                for (String value : arrayString) {
                    Integer intValue = Integer.parseInt(value);
                    array.add(intValue);
                }
                //добавить лог
            }else{
                continue;
            }
        }
        return array.stream().mapToInt(i -> i).toArray(); //разобраться что значит строка
    }

}
