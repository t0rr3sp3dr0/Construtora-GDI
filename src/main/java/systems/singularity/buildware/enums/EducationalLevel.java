package systems.singularity.buildware.enums;

/**
 * Created by pedro on 7/23/16.
 * © 2016 Singularity Systems
 */
public enum EducationalLevel {
    _00("00", "Analfabeto"),
    _01("01", "Fundamental - Incompleto"),
    _02("02", "Fundamental - Completo"),
    _03("03", "Médio - Incompleto"),
    _04("04", "Médio - Completo"),
    _05("05", "Superior - Incompleto"),
    _06("06", "Superior - Completo"),
    _07("07", "Pós-graduação (Lato senso) - Incompleto"),
    _08("08", "Pós-graduação (Lato senso) - Completo"),
    _09("09", "Pós-graduação (Stricto sensu, nível mestrado) - Incompleto"),
    _10("10", "Pós-graduação (Stricto sensu, nível mestrado) - Completo"),
    _11("11", "Pós-graduação (Stricto sensu, nível doutor) - Incompleto"),
    _12("12", "Pós-graduação (Stricto sensu, nível doutor) - Completo");

    private final String id;
    private final String name;

    EducationalLevel(String id, String name) {
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
