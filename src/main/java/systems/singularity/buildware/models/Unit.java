package systems.singularity.buildware.models;

public class Unit {
    private int id;
    private Building building;
    private String description;

    public Unit() {
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public Building getBuilding() {
        return building;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Unit id(int id) {
        this.id = id;
        return this;
    }

    public Unit building(Building building) {
        this.building = building;
        return this;
    }

    public Unit description(String description) {
        this.description = description;
        return this;
    }
}
