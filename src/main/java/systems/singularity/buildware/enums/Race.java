package systems.singularity.buildware.enums;

/**
 * Created by pedro on 7/23/16.
 * © 2016 Singularity Systems
 */
public enum Race {
    _0("0", "Branca"),
    _1("1", "Preta"),
    _2("2", "Amarela"),
    _3("3", "Parda"),
    _4("4", "Indígena");

    private final String id;
    private final String name;

    Race(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
