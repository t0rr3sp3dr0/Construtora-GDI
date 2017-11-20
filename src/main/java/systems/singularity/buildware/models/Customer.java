package systems.singularity.buildware.models;

import systems.singularity.buildware.enums.CBO;
import systems.singularity.buildware.enums.MaritalStatus;

public class Customer {
    private int id;
    private Person person;
    private String email;
    private String job;
    private MaritalStatus maritalStatus;

    public Customer() {
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public String getEmail() {
        return email;
    }

    public String getJob() {
        return job;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Customer id(int id) {
        this.id = id;
        return this;
    }

    public Customer person(Person person) {
        this.person = person;
        return this;
    }

    public Customer email(String email) {
        this.email = email;
        return this;
    }

    public Customer job(String job) {
        this.job = job;
        return this;
    }

    public Customer maritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        return getId() == customer.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }
}
