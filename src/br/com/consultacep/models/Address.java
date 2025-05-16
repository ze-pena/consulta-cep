package br.com.consultacep.models;

public class Address {
    private boolean isFound;
    private String cep;
    private String streetName;
    private String complement;
    private String unity;
    private String neighborhood;
    private String local;
    private String uf;
    private String state;
    private String region;
    private Number ibge;
    private Number gia;
    private Number ddd;
    private Number siafi;

    public Address(AddressRecord addressRecord) {
        isFound = true;
        cep = addressRecord.cep();
        streetName = addressRecord.logradouro();
        complement = addressRecord.complemento();
        unity = addressRecord.unidade();
        neighborhood = addressRecord.bairro();
        local = addressRecord.localidade();
        uf = addressRecord.uf();
        state = addressRecord.estado();
        region = addressRecord.regiao();
        ibge = addressRecord.ibge();
        gia = addressRecord.gia();
        ddd = addressRecord.ddd();
        siafi = addressRecord.siafi();
    }

    public Address() {
        isFound = false;
        cep = "";
        streetName = "";
        complement = "";
        unity = "";
        neighborhood = "";
        local = "";
        uf = "";
        state = "";
        region = "";
        ibge = 0;
        gia = 0;
        ddd = 0;
        siafi = 0;
    }

    public boolean getIsFound() {
        return isFound;
    }

    public String getCep() {
        return cep;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getComplement() {
        return complement;
    }

    public String getUnity() {
        return unity;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getLocal() {
        return local;
    }

    public String getUf() {
        return uf;
    }

    public String getState() {
        return state;
    }

    public String getRegion() {
        return region;
    }

    public Number getIbge() {
        return ibge;
    }

    public Number getGia() {
        return gia;
    }

    public Number getDdd() {
        return ddd;
    }

    public Number getSiafi() {
        return siafi;
    }

    @Override
    public String toString() {
        return
                "Cep: " + cep +
                " | Logradouro: " + streetName +
                " | Bairro: " + neighborhood +
                " | UF: " + uf +
                " | Estado: " + state;
    }
}
