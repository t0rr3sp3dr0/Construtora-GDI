package systems.singularity.buildware.models;

/**
 * Created by pedro on 5/2/16.
 * © 2016 Singularity Systems
 */
public class Address {
    private int id;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String zipCode;

    public Address() {
        this.id = -1;
    }

    public Address id(int id) {
        this.id = id;
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address street(String street) {
        this.street = street;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Address number(String number) {
        this.number = number;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Address complement(String complement) {
        this.complement = complement;
        return this;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public Address neighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
        return this;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public Address city(String city) {
        this.city = city;
        return this;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address state(String state) {
        this.state = state;
        return this;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Address zipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return String.format("%s, %s - %s - %s - %s - %s\n%s", street, number, complement, neighborhood, city, state, zipCode);
    }
}
