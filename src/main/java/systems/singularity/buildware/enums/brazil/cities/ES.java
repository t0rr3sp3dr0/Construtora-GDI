package systems.singularity.buildware.enums.brazil.cities;

/**
 * Created by lvrma on 07/06/16.
 * © 2016 Singularity Systems
 */
public enum ES {
    _null(null, null),
    _1("1", "Afonso Cláudio"),
    _2("2", "Água Doce do Norte"),
    _3("3", "Águia Branca"),
    _4("4", "Alegre"),
    _5("5", "Alfredo Chaves"),
    _6("6", "Alto Rio Novo"),
    _7("7", "Anchieta"),
    _8("8", "Apiacá"),
    _9("9", "Aracruz"),
    _10("10", "Atilio Vivacqua"),
    _11("11", "Baixo Guandu"),
    _12("12", "Barra de São Francisco"),
    _13("13", "Boa Esperança"),
    _14("14", "Bom Jesus do Norte"),
    _15("15", "Brejetuba"),
    _16("16", "Cachoeiro de Itapemirim"),
    _17("17", "Cariacica"),
    _18("18", "Castelo"),
    _19("19", "Colatina"),
    _20("20", "Conceição da Barra"),
    _21("21", "Conceição do Castelo"),
    _22("22", "Divino de São Lourenço"),
    _23("23", "Domingos Martins"),
    _24("24", "Dores do Rio Preto"),
    _25("25", "Ecoporanga"),
    _26("26", "Fundão"),
    _27("27", "Governador Lindenberg"),
    _28("28", "Guaçuí"),
    _29("29", "Guarapari"),
    _30("30", "Ibatiba"),
    _31("31", "Ibiraçu"),
    _32("32", "Ibitirama"),
    _33("33", "Iconha"),
    _34("34", "Irupi"),
    _35("35", "Itaguaçu"),
    _36("36", "Itapemirim"),
    _37("37", "Itarana"),
    _38("38", "Iúna"),
    _39("39", "Jaguaré"),
    _40("40", "Jerônimo Monteiro"),
    _41("41", "João Neiva"),
    _42("42", "Laranja da Terra"),
    _43("43", "Linhares"),
    _44("44", "Mantenópolis"),
    _45("45", "Marataízes"),
    _46("46", "Marechal Floriano"),
    _47("47", "Marilândia"),
    _48("48", "Mimoso do Sul"),
    _49("49", "Montanha"),
    _50("50", "Mucurici"),
    _51("51", "Muniz Freire"),
    _52("52", "Muqui"),
    _53("53", "Nova Venécia"),
    _54("54", "Pancas"),
    _55("55", "Pedro Canário"),
    _56("56", "Pinheiros"),
    _57("57", "Piúma"),
    _58("58", "Ponto Belo"),
    _59("59", "Presidente Kennedy"),
    _60("60", "Rio Bananal"),
    _61("61", "Rio Novo do Sul"),
    _62("62", "Santa Leopoldina"),
    _63("63", "Santa Maria de Jetibá"),
    _64("64", "Santa Teresa"),
    _65("65", "São Domingos do Norte"),
    _66("66", "São Gabriel da Palha"),
    _67("67", "São José do Calçado"),
    _68("68", "São Mateus"),
    _69("69", "São Roque do Canaã"),
    _70("70", "Serra"),
    _71("71", "Sooretama"),
    _72("72", "Vargem Alta"),
    _73("73", "Venda Nova do Imigrante"),
    _74("74", "Viana"),
    _75("75", "Vila Pavão"),
    _76("76", "Vila Valério"),
    _77("77", "Vila Velha"),
    _78("78", "Vitória");

    private final String id;
    private final String name;

    ES(String id, String name) {
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
        return this.equals(ES._null) ? "" : String.format("%s - %s", getId(), getName());
    }
}
