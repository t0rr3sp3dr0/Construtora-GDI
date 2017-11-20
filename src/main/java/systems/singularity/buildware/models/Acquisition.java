package systems.singularity.buildware.models;

public class Acquisition {
    private int id;
    private Material material;
    private Provider provider;
    private Building building;

    public Acquisition() {
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public Material getMaterial() {
        return material;
    }

    public Provider getProvider() {
        return provider;
    }

    public Building getBuilding() {
        return building;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Acquisition id(int id) {
        this.id = id;
        return this;
    }

    public Acquisition material(Material material) {
        this.material = material;
        return this;
    }

    public Acquisition provider(Provider provider) {
        this.provider = provider;
        return this;
    }

    public Acquisition building(Building building) {
        this.building = building;
        return this;
    }
}