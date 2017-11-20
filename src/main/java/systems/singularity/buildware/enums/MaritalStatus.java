package systems.singularity.buildware.enums;

public enum MaritalStatus {
    _null(null, null),
    _0("0", "Solteiro"),
    _1("1", "Casado"),
    _2("2", "Divorciado"),
    _3("3", "Viúvo"),
    _4("4", "Separado"),
    _5("5", "Companheiro");

    /**
     * Created by phts on 19/07/16.
     * © 2016 Singularity Systems
     */
    private final String id;
    private final String name;

    MaritalStatus(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.equals(MaritalStatus._null) ? "" : this.name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
