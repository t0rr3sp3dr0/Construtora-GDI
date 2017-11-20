package systems.singularity.buildware.enums.brazil.cities;

/**
 * Created by lvrma on 07/06/16.
 * © 2016 Singularity Systems
 */
public enum AM {
    _null(null, null),
    _219("219", "Alvarães"),
    _220("220", "Amaturá"),
    _221("221", "Anamã"),
    _222("222", "Anori"),
    _223("223", "Apuí"),
    _224("224", "Atalaia do Norte"),
    _225("225", "Autazes"),
    _226("226", "Barcelos"),
    _227("227", "Barreirinha"),
    _228("228", "Benjamin Constant"),
    _229("229", "Beruri"),
    _230("230", "Boa Vista do Ramos"),
    _231("231", "Boca do Acre"),
    _232("232", "Borba"),
    _233("233", "Caapiranga"),
    _234("234", "Canutama"),
    _235("235", "Carauari"),
    _236("236", "Careiro"),
    _237("237", "Careiro da Várzea"),
    _238("238", "Coari"),
    _239("239", "Codajás"),
    _240("240", "Eirunepé"),
    _241("241", "Envira"),
    _242("242", "Fonte Boa"),
    _243("243", "Guajará"),
    _244("244", "Humaitá"),
    _245("245", "Ipixuna"),
    _246("246", "Iranduba"),
    _247("247", "Itacoatiara"),
    _248("248", "Itamarati"),
    _249("249", "Itapiranga"),
    _250("250", "Japurá"),
    _251("251", "Juruá"),
    _252("252", "Jutaí"),
    _253("253", "Lábrea"),
    _254("254", "Manacapuru"),
    _255("255", "Manaquiri"),
    _256("256", "Manaus"),
    _257("257", "Manicoré"),
    _258("258", "Maraã"),
    _259("259", "Maués"),
    _260("260", "Nhamundá"),
    _261("261", "Nova Olinda do Norte"),
    _262("262", "Novo Airão"),
    _263("263", "Novo Aripuanã"),
    _264("264", "Parintins"),
    _265("265", "Pauini"),
    _266("266", "Presidente Figueiredo"),
    _267("267", "Rio Preto da Eva"),
    _268("268", "Santa Isabel do Rio Negro"),
    _269("269", "Santo Antônio do Içá"),
    _270("270", "São Gabriel da Cachoeira"),
    _271("271", "São Paulo de Olivença"),
    _272("272", "São Sebastião do Uatumã"),
    _273("273", "Silves"),
    _274("274", "Tabatinga"),
    _275("275", "Tapauá"),
    _276("276", "Tefé"),
    _277("277", "Tonantins"),
    _278("278", "Uarini"),
    _279("279", "Urucará"),
    _280("280", "Urucurituba");

    private final String id;
    private final String name;

    AM(String id, String name) {
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
        return this.equals(AM._null) ? "" : String.format("%s - %s", getId(), getName());
    }
}
