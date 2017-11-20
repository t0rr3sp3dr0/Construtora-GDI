package systems.singularity.buildware.models;

public class Phone {
    private int id;
    private Person person;
    private String number;

    public Phone() {
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public String getNumber() {
        return number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Phone id(int id) {
        this.id = id;
        return this;
    }

    public Phone person(Person person) {
        this.person = person;
        return this;
    }

    public Phone number(String number) {
        this.number = number;
        return this;
    }
}
