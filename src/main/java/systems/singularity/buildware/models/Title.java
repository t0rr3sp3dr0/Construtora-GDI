package systems.singularity.buildware.models;

public class Title {
    private int id;
    private String name;
    private double salary;

    public Title() {
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Title id(int id) {
        this.id = id;
        return this;
    }

    public Title name(String name) {
        this.name = name;
        return this;
    }

    public Title salary(double salary) {
        this.salary = salary;
        return this;
    }
}
