package systems.singularity.buildware.enums.brazil.cities;

/**
 * Created by lvrma on 07/06/16.
 * © 2016 Singularity Systems
 */
public enum RJ {
    _null(null, null),
    _3591("3591", "Angra dos Reis"),
    _3592("3592", "Aperibé"),
    _3593("3593", "Araruama"),
    _3594("3594", "Areal"),
    _3595("3595", "Armação dos Búzios"),
    _3596("3596", "Arraial do Cabo"),
    _3597("3597", "Barra do Piraí"),
    _3598("3598", "Barra Mansa"),
    _3599("3599", "Belford Roxo"),
    _3600("3600", "Bom Jardim"),
    _3601("3601", "Bom Jesus do Itabapoana"),
    _3602("3602", "Cabo Frio"),
    _3603("3603", "Cachoeiras de Macacu"),
    _3604("3604", "Cambuci"),
    _3605("3605", "Campos dos Goytacazes"),
    _3606("3606", "Cantagalo"),
    _3607("3607", "Carapebus"),
    _3608("3608", "Cardoso Moreira"),
    _3609("3609", "Carmo"),
    _3610("3610", "Casimiro de Abreu"),
    _3611("3611", "Comendador Levy Gasparian"),
    _3612("3612", "Conceição de Macabu"),
    _3613("3613", "Cordeiro"),
    _3614("3614", "Duas Barras"),
    _3615("3615", "Duque de Caxias"),
    _3616("3616", "Engenheiro Paulo de Frontin"),
    _3617("3617", "Guapimirim"),
    _3618("3618", "Iguaba Grande"),
    _3619("3619", "Itaboraí"),
    _3620("3620", "Itaguaí"),
    _3621("3621", "Italva"),
    _3622("3622", "Itaocara"),
    _3623("3623", "Itaperuna"),
    _3624("3624", "Itatiaia"),
    _3625("3625", "Japeri"),
    _3626("3626", "Laje do Muriaé"),
    _3627("3627", "Macaé"),
    _3628("3628", "Macuco"),
    _3629("3629", "Magé"),
    _3630("3630", "Mangaratiba"),
    _3631("3631", "Maricá"),
    _3632("3632", "Mendes"),
    _3633("3633", "Mesquita"),
    _3634("3634", "Miguel Pereira"),
    _3635("3635", "Miracema"),
    _3636("3636", "Natividade"),
    _3637("3637", "Nilópolis"),
    _3638("3638", "Niterói"),
    _3639("3639", "Nova Friburgo"),
    _3640("3640", "Nova Iguaçu"),
    _3641("3641", "Paracambi"),
    _3642("3642", "Paraíba do Sul"),
    _3643("3643", "Parati"),
    _3644("3644", "Paty do Alferes"),
    _3645("3645", "Petrópolis"),
    _3646("3646", "Pinheiral"),
    _3647("3647", "Piraí"),
    _3648("3648", "Porciúncula"),
    _3649("3649", "Porto Real"),
    _3650("3650", "Quatis"),
    _3651("3651", "Queimados"),
    _3652("3652", "Quissamã"),
    _3653("3653", "Resende"),
    _3654("3654", "Rio Bonito"),
    _3655("3655", "Rio Claro"),
    _3656("3656", "Rio das Flores"),
    _3657("3657", "Rio das Ostras"),
    _3658("3658", "Rio de Janeiro"),
    _3659("3659", "Santa Maria Madalena"),
    _3660("3660", "Santo Antônio de Pádua"),
    _3661("3661", "São Fidélis"),
    _3662("3662", "São Francisco de Itabapoana"),
    _3663("3663", "São Gonçalo"),
    _3664("3664", "São João da Barra"),
    _3665("3665", "São João de Meriti"),
    _3666("3666", "São José de Ubá"),
    _3667("3667", "São José do Vale do Rio Pret"),
    _3668("3668", "São Pedro da Aldeia"),
    _3669("3669", "São Sebastião do Alto"),
    _3670("3670", "Sapucaia"),
    _3671("3671", "Saquarema"),
    _3672("3672", "Seropédica"),
    _3673("3673", "Silva Jardim"),
    _3674("3674", "Sumidouro"),
    _3675("3675", "Tanguá"),
    _3676("3676", "Teresópolis"),
    _3677("3677", "Trajano de Morais"),
    _3678("3678", "Três Rios"),
    _3679("3679", "Valença"),
    _3680("3680", "Varre-Sai"),
    _3681("3681", "Vassouras"),
    _3682("3682", "Volta Redonda");

    private final String id;
    private final String name;

    RJ(String id, String name) {
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
        return this.equals(RJ._null) ? "" : String.format("%s - %s", getId(), getName());
    }
}
