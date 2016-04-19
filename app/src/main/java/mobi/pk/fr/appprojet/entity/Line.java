package mobi.pk.fr.appprojet.entity;

import java.util.Map;
import java.util.List;

public class Line {

    private String id;
    private String name;
    private String destination;
    private Mode mode;
    private Type type;
    private List<Map<Station, List<Integer>>> mappedSchedules;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Map<Station, List<Integer>>> getMappedSchedules() {
        return mappedSchedules;
    }

    public void setMappedSchedules(List<Map<Station, List<Integer>>> mappedSchedules) {
        this.mappedSchedules = mappedSchedules;
    }
}
