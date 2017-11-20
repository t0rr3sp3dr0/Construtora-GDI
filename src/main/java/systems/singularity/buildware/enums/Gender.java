package systems.singularity.buildware.enums;

/**
 * Created by pedro on 7/25/16.
 * © 2016 Singularity Systems
 */
public enum Gender {
    _null(null, null),
    _0("0", "Masculino"),
    _1("1", "Feminino");

    private final String id;
    private final String name;

    Gender(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.equals(Gender._null) ? "" : this.name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
