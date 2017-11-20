package systems.singularity.buildware.models;

public class Bonus {
    private int id;
    private String description;
    private Purchase purchase;

    public Bonus() {
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Bonus id(int id) {
        this.id = id;
        return this;
    }

    public Bonus description(String description) {
        this.description = description;
        return this;
    }

    public Bonus purchase(Purchase purchase) {
        this.purchase = purchase;
        return this;
    }
}
