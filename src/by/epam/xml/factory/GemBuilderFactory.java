package by.epam.xml.factory;

import by.epam.xml.builders.AbstractGemsBuilder;
import by.epam.xml.builders.GemsDomBuilder;
import by.epam.xml.builders.GemsSaxBuilder;
import by.epam.xml.builders.GemsStaxBuilder;

public class GemBuilderFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }

    public static AbstractGemsBuilder createMedicineBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        AbstractGemsBuilder builder;
        switch (type) {
            case DOM:
                builder = new GemsDomBuilder();
                break;
            case SAX:
                builder = new GemsSaxBuilder();
                break;
            case STAX:
                builder = new GemsStaxBuilder();
                break;
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
        return builder;
    }

}
