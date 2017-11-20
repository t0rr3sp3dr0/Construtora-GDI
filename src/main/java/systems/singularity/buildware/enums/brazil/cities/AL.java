package systems.singularity.buildware.enums.brazil.cities;

/**
 * Created by lvrma on 07/06/16.
 * © 2016 Singularity Systems
 */
public enum AL {
    _null(null, null),
    _101("101", "Água Branca"),
    _102("102", "Anadia"),
    _103("103", "Arapiraca"),
    _104("104", "Atalaia"),
    _105("105", "Barra de Santo Antônio"),
    _106("106", "Barra de São Miguel"),
    _107("107", "Batalha"),
    _108("108", "Belém"),
    _109("109", "Belo Monte"),
    _110("110", "Boca da Mata"),
    _111("111", "Branquinha"),
    _112("112", "Cacimbinhas"),
    _113("113", "Cajueiro"),
    _114("114", "Campestre"),
    _115("115", "Campo Alegre"),
    _116("116", "Campo Grande"),
    _117("117", "Canapi"),
    _118("118", "Capela"),
    _119("119", "Carneiros"),
    _120("120", "Chã Preta"),
    _121("121", "Coité do Nóia"),
    _122("122", "Colônia Leopoldina"),
    _123("123", "Coqueiro Seco"),
    _124("124", "Coruripe"),
    _125("125", "Craíbas"),
    _126("126", "Delmiro Gouveia"),
    _127("127", "Dois Riachos"),
    _128("128", "Estrela de Alagoas"),
    _129("129", "Feira Grande"),
    _130("130", "Feliz Deserto"),
    _131("131", "Flexeiras"),
    _132("132", "Girau do Ponciano"),
    _133("133", "Ibateguara"),
    _134("134", "Igaci"),
    _135("135", "Igreja Nova"),
    _136("136", "Inhapi"),
    _137("137", "Jacaré dos Homens"),
    _138("138", "Jacuípe"),
    _139("139", "Japaratinga"),
    _140("140", "Jaramataia"),
    _141("141", "Jequiá da Praia"),
    _142("142", "Joaquim Gomes"),
    _143("143", "Jundiá"),
    _144("144", "Junqueiro"),
    _145("145", "Lagoa da Canoa"),
    _146("146", "Limoeiro de Anadia"),
    _147("147", "Maceió"),
    _148("148", "Major Isidoro"),
    _149("149", "Mar Vermelho"),
    _150("150", "Maragogi"),
    _151("151", "Maravilha"),
    _152("152", "Marechal Deodoro"),
    _153("153", "Maribondo"),
    _154("154", "Mata Grande"),
    _155("155", "Matriz de Camaragibe"),
    _156("156", "Messias"),
    _157("157", "Minador do Negrão"),
    _158("158", "Monteirópolis"),
    _159("159", "Murici"),
    _160("160", "Novo Lino"),
    _161("161", "Olho d`Água das Flores"),
    _162("162", "Olho d`Água do Casado"),
    _163("163", "Olho d`Água Grande"),
    _164("164", "Olivença"),
    _165("165", "Ouro Branco"),
    _166("166", "Palestina"),
    _167("167", "Palmeira dos Índios"),
    _168("168", "Pão de Açúcar"),
    _169("169", "Pariconha"),
    _170("170", "Paripueira"),
    _171("171", "Passo de Camaragibe"),
    _172("172", "Paulo Jacinto"),
    _173("173", "Penedo"),
    _174("174", "Piaçabuçu"),
    _175("175", "Pilar"),
    _176("176", "Pindoba"),
    _177("177", "Piranhas"),
    _178("178", "Poço das Trincheiras"),
    _179("179", "Porto Calvo"),
    _180("180", "Porto de Pedras"),
    _181("181", "Porto Real do Colégio"),
    _182("182", "Quebrangulo"),
    _183("183", "Rio Largo"),
    _184("184", "Roteiro"),
    _185("185", "Santa Luzia do Norte"),
    _186("186", "Santana do Ipanema"),
    _187("187", "Santana do Mundaú"),
    _188("188", "São Brás"),
    _189("189", "São José da Laje"),
    _190("190", "São José da Tapera"),
    _191("191", "São Luís do Quitunde"),
    _192("192", "São Miguel dos Campos"),
    _193("193", "São Miguel dos Milagres"),
    _194("194", "São Sebastião"),
    _195("195", "Satuba"),
    _196("196", "Senador Rui Palmeira"),
    _197("197", "Tanque d`Arca"),
    _198("198", "Taquarana"),
    _199("199", "Teotônio Vilela"),
    _200("200", "Traipu"),
    _201("201", "União dos Palmares"),
    _202("202", "Viçosa");

    private final String id;
    private final String name;

    AL(String id, String name) {
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
        return this.equals(AL._null) ? "" : String.format("%s - %s", getId(), getName());
    }
}
