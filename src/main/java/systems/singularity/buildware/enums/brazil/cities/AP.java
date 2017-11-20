package systems.singularity.buildware.enums.brazil.cities;

/**
 * Created by lvrma on 07/06/16.
 * © 2016 Singularity Systems
 */
public enum AP {
    _null(null, null),
    _203("203", "Amapá"),
    _204("204", "Calçoene"),
    _205("205", "Cutias"),
    _206("206", "Ferreira Gomes"),
    _207("207", "Itaubal"),
    _208("208", "Laranjal do Jari"),
    _209("209", "Macapá"),
    _210("210", "Mazagão"),
    _211("211", "Oiapoque"),
    _212("212", "Pedra Branca do Amaparí"),
    _213("213", "Porto Grande"),
    _214("214", "Pracuúba"),
    _215("215", "Santana"),
    _216("216", "Serra do Navio"),
    _217("217", "Tartarugalzinho"),
    _218("218", "Vitória do Jari");

    private final String id;
    private final String name;

    AP(String id, String name) {
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
        return this.equals(AP._null) ? "" : String.format("%s - %s", getId(), getName());
    }
}
