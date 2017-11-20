package systems.singularity.buildware.enums.brazil.cities;

/**
 * Created by lvrma on 07/06/16.
 * © 2016 Singularity Systems
 */
public enum RR {
    _null(null, null),
    _4398("4398", "Alto Alegre"),
    _4399("4399", "Amajari"),
    _4400("4400", "Boa Vista"),
    _4401("4401", "Bonfim"),
    _4402("4402", "Cantá"),
    _4403("4403", "Caracaraí"),
    _4404("4404", "Caroebe"),
    _4405("4405", "Iracema"),
    _4406("4406", "Mucajaí"),
    _4407("4407", "Normandia"),
    _4408("4408", "Pacaraima"),
    _4409("4409", "Rorainópolis"),
    _4410("4410", "São João da Baliza"),
    _4411("4411", "São Luiz"),
    _4412("4412", "Uiramutã");

    private final String id;
    private final String name;

    RR(String id, String name) {
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
        return this.equals(RR._null) ? "" : String.format("%s - %s", getId(), getName());
    }
}
