package systems.singularity.buildware.enums.brazil.cities;

/**
 * Created by lvrma on 07/06/16.
 * © 2016 Singularity Systems
 */
public enum DF {
    _null(null, null),
    _882("882", "Brasília");

    private final String id;
    private final String name;

    DF(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.equals(DF._null) ? "" : String.format("%s - %s", getId(), getName());
    }
}
