package by.epam.xml.entity;

public class Gem {
    private String name;
    private String id;
    private String origin;
    private ParameterGem parameters;
    private Integer value;
    private String preciousness;

    public Gem(String name, String id, String origin, ParameterGem parameters, Integer value) {
        this.name = name;
        this.id = id;
        this.origin = origin;
        this.parameters = parameters;
        this.value = value;
    }

    public Gem() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public ParameterGem getParameters() {
        return parameters;
    }

    public void setParameters(ParameterGem parameters) {
        this.parameters = parameters;
    }

    public String getValue() {
        return value.toString();
    }

    public void setValue(String value) {
        this.value = Integer.parseInt(value);
    }

    public String getPreciousness() {
        return preciousness;
    }

    public void setPreciousness(String preciousness) {
        this.preciousness = preciousness;
    }


    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Gem{");
        stringBuilder.append("\nname=").append(name);
        stringBuilder.append("\nid=").append(id);
        stringBuilder.append("\norigin=").append(origin);
        stringBuilder.append("\nparameters=").append(parameters.toString());
        stringBuilder.append("\nvalue=").append(value);
        stringBuilder.append("\npreciousness=").append(preciousness).append("};");
        return stringBuilder.toString();
    }

}
