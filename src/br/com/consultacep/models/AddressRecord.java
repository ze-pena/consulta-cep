package br.com.consultacep.models;

public record AddressRecord(
    String cep,
    String logradouro,
    String complemento,
    String unidade,
    String bairro,
    String localidade,
    String uf,
    String estado,
    String regiao,
    Number ibge,
    Number gia,
    Number ddd,
    Number siafi
) {}
