package systems.singularity.buildware.enums;

/**
 * Created by pedro on 7/23/16.
 * © 2016 Singularity Systems
 */
public enum Tribute {
    _0("0", "IRPJ"),
    _1("1", "CSLL"),
    _2("2", "PIS"),
    _3("3", "COFINS"),
    _4("4", "Simples Nacional"),
    _5("5", "ISS");

    private final String id;
    private final String name;

    Tribute(String id, String name) {
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
