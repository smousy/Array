package by.epam.xml.handler;

import by.epam.xml.entity.ParameterGem;

public enum GemXmlTag {
    GEMS("gems"),
    NAME("name"),
    ID("id"),
    ORIGIN("origin"),
    GEM("gem"),
    PARAMETERS("parameters"),
    VALUE("value"),
    PRECIOUSNESS("preciiousness"),
    COLOR("color"),
    TRANSPARENCY("transparency"),
    EDGES("edges");
    private String value;

    GemXmlTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
