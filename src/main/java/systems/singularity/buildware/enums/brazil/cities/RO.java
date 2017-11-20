package systems.singularity.buildware.enums.brazil.cities;

/**
 * Created by lvrma on 07/06/16.
 * © 2016 Singularity Systems
 */
public enum RO {
    _null(null, null),
    _4346("4346", "Alta Floresta d`Oeste"),
    _4347("4347", "Alto Alegre dos Parecis"),
    _4348("4348", "Alto Paraíso"),
    _4349("4349", "Alvorada d`Oeste"),
    _4350("4350", "Ariquemes"),
    _4351("4351", "Buritis"),
    _4352("4352", "Cabixi"),
    _4353("4353", "Cacaulândia"),
    _4354("4354", "Cacoal"),
    _4355("4355", "Campo Novo de Rondônia"),
    _4356("4356", "Candeias do Jamari"),
    _4357("4357", "Castanheiras"),
    _4358("4358", "Cerejeiras"),
    _4359("4359", "Chupinguaia"),
    _4360("4360", "Colorado do Oeste"),
    _4361("4361", "Corumbiara"),
    _4362("4362", "Costa Marques"),
    _4363("4363", "Cujubim"),
    _4364("4364", "Espigão d`Oeste"),
    _4365("4365", "Governador Jorge Teixeira"),
    _4366("4366", "Guajará-Mirim"),
    _4367("4367", "Itapuã do Oeste"),
    _4368("4368", "Jaru"),
    _4369("4369", "Ji-Paraná"),
    _4370("4370", "Machadinho d`Oeste"),
    _4371("4371", "Ministro Andreazza"),
    _4372("4372", "Mirante da Serra"),
    _4373("4373", "Monte Negro"),
    _4374("4374", "Nova Brasilândia d`Oeste"),
    _4375("4375", "Nova Mamoré"),
    _4376("4376", "Nova União"),
    _4377("4377", "Novo Horizonte do Oeste"),
    _4378("4378", "Ouro Preto do Oeste"),
    _4379("4379", "Parecis"),
    _4380("4380", "Pimenta Bueno"),
    _4381("4381", "Pimenteiras do Oeste"),
    _4382("4382", "Porto Velho"),
    _4383("4383", "Presidente Médici"),
    _4384("4384", "Primavera de Rondônia"),
    _4385("4385", "Rio Crespo"),
    _4386("4386", "Rolim de Moura"),
    _4387("4387", "Santa Luzia d`Oeste"),
    _4388("4388", "São Felipe d`Oeste"),
    _4389("4389", "São Francisco do Guaporé"),
    _4390("4390", "São Miguel do Guaporé"),
    _4391("4391", "Seringueiras"),
    _4392("4392", "Teixeirópolis"),
    _4393("4393", "Theobroma"),
    _4394("4394", "Urupá"),
    _4395("4395", "Vale do Anari"),
    _4396("4396", "Vale do Paraíso"),
    _4397("4397", "Vilhena");


    private final String id;
    private final String name;

    RO(String id, String name) {
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
        return this.equals(RO._null) ? "" : String.format("%s - %s", getId(), getName());
    }
}
