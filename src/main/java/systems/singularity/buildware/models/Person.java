package systems.singularity.buildware.models;

import systems.singularity.buildware.enums.Gender;

import java.util.Date;

public class Person {
    private int id;
    private String name;
    private String cpf;
    private Date birthdate;
    private Gender gender;
    private Address address;

    public Person() {
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCPF() {
        return cpf;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public Gender getGender() {
        return gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Person id(int id) {
        this.id = id;
        return this;
    }

    public Person name(String name) {
        this.name = name;
        return this;
    }

    public Person cpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public Person birthdate(Date birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public Person gender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Person address(Address address) {
        this.address = address;
        return this;
    }
}
