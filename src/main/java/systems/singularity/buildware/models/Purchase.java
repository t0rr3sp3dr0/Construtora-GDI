package systems.singularity.buildware.models;

import java.util.Date;

public class Purchase {
    private int id;
    private Customer customer;
    private Unit unit;
    private Date date;

    public Purchase() {
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Unit getUnit() {
        return unit;
    }

    public Date getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Purchase id(int id) {
        this.id = id;
        return this;
    }

    public Purchase customer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Purchase unit(Unit unit) {
        this.unit = unit;
        return this;
    }

    public Purchase date(Date date) {
        this.date = date;
        return this;
    }
}
