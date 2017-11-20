package systems.singularity.buildware.enums.brazil.cities;

/**
 * Created by lvrma on 07/06/16.
 * © 2016 Singularity Systems
 */
public enum SE {
    _null(null, null),
    _5351("5351", "Amparo de São Francisco"),
    _5352("5352", "Aquidabã"),
    _5353("5353", "Aracaju"),
    _5354("5354", "Arauá"),
    _5355("5355", "Areia Branca"),
    _5356("5356", "Barra dos Coqueiros"),
    _5357("5357", "Boquim"),
    _5358("5358", "Brejo Grande"),
    _5359("5359", "Campo do Brito"),
    _5360("5360", "Canhoba"),
    _5361("5361", "Canindé de São Francisco"),
    _5362("5362", "Capela"),
    _5363("5363", "Carira"),
    _5364("5364", "Carmópolis"),
    _5365("5365", "Cedro de São João"),
    _5366("5366", "Cristinápolis"),
    _5367("5367", "Cumbe"),
    _5368("5368", "Divina Pastora"),
    _5369("5369", "Estância"),
    _5370("5370", "Feira Nova"),
    _5371("5371", "Frei Paulo"),
    _5372("5372", "Gararu"),
    _5373("5373", "General Maynard"),
    _5374("5374", "Gracho Cardoso"),
    _5375("5375", "Ilha das Flores"),
    _5376("5376", "Indiaroba"),
    _5377("5377", "Itabaiana"),
    _5378("5378", "Itabaianinha"),
    _5379("5379", "Itabi"),
    _5380("5380", "Itaporanga d`Ajuda"),
    _5381("5381", "Japaratuba"),
    _5382("5382", "Japoatã"),
    _5383("5383", "Lagarto"),
    _5384("5384", "Laranjeiras"),
    _5385("5385", "Macambira"),
    _5386("5386", "Malhada dos Bois"),
    _5387("5387", "Malhador"),
    _5388("5388", "Maruim"),
    _5389("5389", "Moita Bonita"),
    _5390("5390", "Monte Alegre de Sergipe"),
    _5391("5391", "Muribeca"),
    _5392("5392", "Neópolis"),
    _5393("5393", "Nossa Senhora Aparecida"),
    _5394("5394", "Nossa Senhora da Glória"),
    _5395("5395", "Nossa Senhora das Dores"),
    _5396("5396", "Nossa Senhora de Lourdes"),
    _5397("5397", "Nossa Senhora do Socorro"),
    _5398("5398", "Pacatuba"),
    _5399("5399", "Pedra Mole"),
    _5400("5400", "Pedrinhas"),
    _5401("5401", "Pinhão"),
    _5402("5402", "Pirambu"),
    _5403("5403", "Poço Redondo"),
    _5404("5404", "Poço Verde"),
    _5405("5405", "Porto da Folha"),
    _5406("5406", "Propriá"),
    _5407("5407", "Riachão do Dantas"),
    _5408("5408", "Riachuelo"),
    _5409("5409", "Ribeirópolis"),
    _5410("5410", "Rosário do Catete"),
    _5411("5411", "Salgado"),
    _5412("5412", "Santa Luzia do Itanhy"),
    _5413("5413", "Santa Rosa de Lima"),
    _5414("5414", "Santana do São Francisco"),
    _5415("5415", "Santo Amaro das Brotas"),
    _5416("5416", "São Cristóvão"),
    _5417("5417", "São Domingos"),
    _5418("5418", "São Francisco"),
    _5419("5419", "São Miguel do Aleixo"),
    _5420("5420", "Simão Dias"),
    _5421("5421", "Siriri"),
    _5422("5422", "Telha"),
    _5423("5423", "Tobias Barreto"),
    _5424("5424", "Tomar do Geru"),
    _5425("5425", "Umbaúba");

    private final String id;
    private final String name;

    SE(String id, String name) {
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
        return this.equals(SE._null) ? "" : String.format("%s - %s", getId(), getName());
    }
}
