package systems.singularity.buildware.models;

import java.util.Date;

public class Employee {
    private int id;
    private Person person;
    private Employee manager;
    private Title title;
    private Date hiringDate;
    private Date terminationDate;

    public Employee() {
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public Employee getManager() {
        return manager;
    }

    public Title getTitle() {
        return title;
    }

    public Date getHiringDate() {
        return hiringDate;
    }

    public Date getTerminationDate() {
        return terminationDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public void setHiringDate(Date hiringDate) {
        this.hiringDate = hiringDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    public Employee id(int id) {
        this.id = id;
        return this;
    }

    public Employee person(Person person) {
        this.person = person;
        return this;
    }

    public Employee manager(Employee manager) {
        this.manager = manager;
        return this;
    }

    public Employee title(Title title) {
        this.title = title;
        return this;
    }

    public Employee hiringDate(Date hiringDate) {
        this.hiringDate = hiringDate;
        return this;
    }

    public Employee terminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
        return this;
    }
}
