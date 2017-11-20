package systems.singularity.buildware.models;

import java.util.Date;

public class Building {
    private int id;
    private String name;
    private String cei;
    private Date beginDate;
    private Date endDate;
    private Address address;
    private Employee manager;

    public Building() {
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCEI() {
        return cei;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Address getAddress() {
        return address;
    }

    public Employee getManager() {
        return manager;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCei(String cei) {
        this.cei = cei;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Building id(int id) {
        this.id = id;
        return this;
    }

    public Building name(String name) {
        this.name = name;
        return this;
    }

    public Building cei(String cei) {
        this.cei = cei;
        return this;
    }

    public Building beginDate(Date beginDate) {
        this.beginDate = beginDate;
        return this;
    }

    public Building endDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public Building address(Address address) {
        this.address = address;
        return this;
    }

    public Building manager(Employee manager) {
        this.manager = manager;
        return this;
    }
}
