package systems.singularity.buildware.enums.brazil.cities;

/**
 * Created by lvrma on 07/06/16.
 * © 2016 Singularity Systems
 */
public enum AC {
    _null(null, null),
    _79("79", "Acrelândia"),
    _80("80", "Assis Brasil"),
    _81("81", "Brasiléia"),
    _82("82", "Bujari"),
    _83("83", "Capixaba"),
    _84("84", "Cruzeiro do Sul"),
    _85("85", "Epitaciolândia"),
    _86("86", "Feijó"),
    _87("87", "Jordão"),
    _88("88", "Mâncio Lima"),
    _89("89", "Manoel Urbano"),
    _90("90", "Marechal Thaumaturgo"),
    _91("91", "Plácido de Castro"),
    _92("92", "Porto Acre"),
    _93("93", "Porto Walter"),
    _94("94", "Rio Branco"),
    _95("95", "Rodrigues Alves"),
    _96("96", "Santa Rosa do Purus"),
    _97("97", "Sena Madureira"),
    _98("98", "Senador Guiomard"),
    _99("99", "Tarauacá"),
    _100("100", "Xapuri");

    private final String id;
    private final String name;

    AC(String id, String name) {
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
        return this.equals(AC._null) ? "" : String.format("%s - %s", getId(), getName());
    }
}
