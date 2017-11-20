package systems.singularity.buildware.enums.brazil.cities;

/**
 * Created by lvrma on 07/06/16.
 * © 2016 Singularity Systems
 */
public enum MS {
    _null(null, null),
    _1487("1487", "Água Clara"),
    _1488("1488", "Alcinópolis"),
    _1489("1489", "Amambaí"),
    _1490("1490", "Anastácio"),
    _1491("1491", "Anaurilândia"),
    _1492("1492", "Angélica"),
    _1493("1493", "Antônio João"),
    _1494("1494", "Aparecida do Taboado"),
    _1495("1495", "Aquidauana"),
    _1496("1496", "Aral Moreira"),
    _1497("1497", "Bandeirantes"),
    _1498("1498", "Bataguassu"),
    _1499("1499", "Bataiporã"),
    _1500("1500", "Bela Vista"),
    _1501("1501", "Bodoquena"),
    _1502("1502", "Bonito"),
    _1503("1503", "Brasilândia"),
    _1504("1504", "Caarapó"),
    _1505("1505", "Camapuã"),
    _1506("1506", "Campo Grande"),
    _1507("1507", "Caracol"),
    _1508("1508", "Cassilândia"),
    _1509("1509", "Chapadão do Sul"),
    _1510("1510", "Corguinho"),
    _1511("1511", "Coronel Sapucaia"),
    _1512("1512", "Corumbá"),
    _1513("1513", "Costa Rica"),
    _1514("1514", "Coxim"),
    _1515("1515", "Deodápolis"),
    _1516("1516", "Dois Irmãos do Buriti"),
    _1517("1517", "Douradina"),
    _1518("1518", "Dourados"),
    _1519("1519", "Eldorado"),
    _1520("1520", "Fátima do Sul"),
    _1521("1521", "Figueirão"),
    _1522("1522", "Glória de Dourados"),
    _1523("1523", "Guia Lopes da Laguna"),
    _1524("1524", "Iguatemi"),
    _1525("1525", "Inocência"),
    _1526("1526", "Itaporã"),
    _1527("1527", "Itaquiraí"),
    _1528("1528", "Ivinhema"),
    _1529("1529", "Japorã"),
    _1530("1530", "Jaraguari"),
    _1531("1531", "Jardim"),
    _1532("1532", "Jateí"),
    _1533("1533", "Juti"),
    _1534("1534", "Ladário"),
    _1535("1535", "Laguna Carapã"),
    _1536("1536", "Maracaju"),
    _1537("1537", "Miranda"),
    _1538("1538", "Mundo Novo"),
    _1539("1539", "Naviraí"),
    _1540("1540", "Nioaque"),
    _1541("1541", "Nova Alvorada do Sul"),
    _1542("1542", "Nova Andradina"),
    _1543("1543", "Novo Horizonte do Sul"),
    _1544("1544", "Paranaíba"),
    _1545("1545", "Paranhos"),
    _1546("1546", "Pedro Gomes"),
    _1547("1547", "Ponta Porã"),
    _1548("1548", "Porto Murtinho"),
    _1549("1549", "Ribas do Rio Pardo"),
    _1550("1550", "Rio Brilhante"),
    _1551("1551", "Rio Negro"),
    _1552("1552", "Rio Verde de Mato Grosso"),
    _1553("1553", "Rochedo"),
    _1554("1554", "Santa Rita do Pardo"),
    _1555("1555", "São Gabriel do Oeste"),
    _1556("1556", "Selvíria"),
    _1557("1557", "Sete Quedas"),
    _1558("1558", "Sidrolândia"),
    _1559("1559", "Sonora"),
    _1560("1560", "Tacuru"),
    _1561("1561", "Taquarussu"),
    _1562("1562", "Terenos"),
    _1563("1563", "Três Lagoas"),
    _1564("1564", "Vicentina");

    private final String id;
    private final String name;

    MS(String id, String name) {
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
        return this.equals(MS._null) ? "" : String.format("%s - %s", getId(), getName());
    }
}
