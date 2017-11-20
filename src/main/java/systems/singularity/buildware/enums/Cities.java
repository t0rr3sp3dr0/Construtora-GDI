package systems.singularity.buildware.enums;

/**
 * Created by lvrma on 07/06/16.
 * © 2016 Singularity Systems
 */
public enum Cities {
    _null(null, null);

    private final String id;
    private final String name;

    Cities(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.equals(Cities._null) ? "" : String.format("%s - %s", getName(), getId());
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
