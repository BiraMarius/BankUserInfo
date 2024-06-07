package lists;

public enum CountyCodeList {
    ALBA("ALBA","1"),
    ARAD("ARAD","2"),
    ARGES("ARGES","3"),
    BACAU("BACAU","4"),
    BIHOR("BIHOR","5"),
    BISTRITA_NASAUD("BISTRITA NASAUD","6"),
    BOTOSANI("BOTOSANI","7"),
    BRASOV("BRASOV","8"),
    BRAILA("BRAILA","9"),
    BUZAU("BUZAU","10"),
    CARAS_SEVERIN("CARAS_SEVERIN","11"),
    CLUJ("CLUJ","12"),
    CONSTANTA("CONSTANTA","13"),
    COVASNA("COVASNA","14"),
    DAMBOVITA("DAMBOVITA","15"),
    DOLJ("DOLJ","16"),
    GALATI("GALATI","17"),
    GORJ("GORJ","18"),
    HARGHITA("HARGHITA","19"),
    HUNEDOARA("HUNEDOARA","20"),
    IALOMITA("IALOMITA","21"),
    IASI("IASI","22"),
    ILFOV("ILFOV","23"),
    MARAMURES("MARAMURES","24"),
    MEHEDINTI("MEHEDINTI","25"),
    MURES("MURES","26"),
    NEAMT("NEAMT","27"),
    OLT("OLT","28"),
    PRAHOVA("PRAHOVA","29"),
    SATU_MARE("SATU_MARE","30"),
    SALAJ("SALAJ","31"),
    SIBIU("SIBIU","32"),
    SUCEAVA("SUCEAVA","33"),
    TELEORMAN("TELEORMAN","34"),
    TIMIS("TIMIS","35"),
    TULCEA("TULCEA","36"),
    VASLUI("VASLUI","37"),
    VALCEA("VALCEA","38"),
    VRANCEA("VRANCEA","39"),
    BUCHAREST("BUCHAREST","40"),
    BUCHAREST_SECTOR_1("SECTOR 1","41"),
    BUCHAREST_SECTOR_2("SECTOR 2","42"),
    BUCHAREST_SECTOR_3("SECTOR 3","43"),
    BUCHAREST_SECTOR_4("SECTOR 4","44"),
    BUCHAREST_SECTOR_5("SECTOR 5","45"),
    BUCHAREST_SECTOR_6("SECTOR 6","46"),
    CALARASI("CALARASI","51"),
    GIURGIU("GIURGIU","52");
    private String name;
    private String countyCode;

    CountyCodeList(String name, String countyCode) {
        this.name = name;
        this.countyCode = countyCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }
}
