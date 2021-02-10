package by.epam.xml.entity;

public class ParameterGem {
    private String color;
    private Integer transparency;
    private Integer edges;

    public ParameterGem(String color, Integer transparency, Integer edges) {
        this.color = color;
        this.transparency = transparency;
        this.edges = edges;
    }

    public ParameterGem() {

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getTransparency() {
        return transparency;
    }

    public void setTransparency(String transparency) {
        this.transparency = Integer.parseInt(transparency);
    }

    public Integer getEdges() {
        return edges;
    }

    public void setEdges(String edges) {
        this.edges = Integer.parseInt(edges);
    }


    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Parameters{");
        stringBuilder.append("\nparameters=").append(color);
        stringBuilder.append("\nvalue=").append(transparency.toString());
        stringBuilder.append("\npreciousness=").append(edges.toString()).append("};");
        return stringBuilder.toString();
    }
}
