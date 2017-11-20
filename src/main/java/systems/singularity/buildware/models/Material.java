package systems.singularity.buildware.models;

public class Material {
    private int id;
    private String name;
    private String manufacturer;
    private double price;
    private Provider provider;

    public Material() {
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Material id(int id) {
        this.id = id;
        return this;
    }

    public Material name(String name) {
        this.name = name;
        return this;
    }

    public Material manufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public Material price(double price) {
        this.price = price;
        return this;
    }

    public Material provider(Provider provider) {
        this.provider = provider;
        return this;
    }
}
