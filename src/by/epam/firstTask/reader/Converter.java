package by.epam.firstTask.reader;

import by.epam.firstTask.validation.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Vector;


public class Converter {
    static Logger logger = LogManager.getLogger();

    public int[] convertToInt(ArrayList<String> arrays) {
        Vector<Integer> array = new Vector<>();
        Validator validator = new Validator();
        for (String oneArray : arrays) {
            if (validator.checkString(oneArray)) {
                String[] arrayString = oneArray.split(" "); //может быть сделать табы?
                for (String value : arrayString) {
                    Integer intValue = Integer.parseInt(value);
                    array.add(intValue);
                }
                logger.info("valid array find");
            } else {
                continue;
            }
        }
        return array.stream().mapToInt(i -> i).toArray(); //разобраться что значит строка
    }

}
