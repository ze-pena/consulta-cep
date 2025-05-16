package br.com.consultacep.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SearchCep {
    private HttpClient client = HttpClient.newHttpClient();
    Gson gson = new GsonBuilder().create();

    public Address request(String cep) {
        URI uri = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

        try {
            HttpRequest request = HttpRequest.newBuilder(uri).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                AddressRecord addressRecord = gson.fromJson(response.body(), AddressRecord.class);
                return new Address(addressRecord);
            } else {
                System.out.println("\nEndereço de cep não encontrado ou inválido!");
                System.out.println("Por favor, tente novamente:\n");
                return new Address();
            }
        } catch (JsonSyntaxException exception) {
            System.out.println("Aconteceu um erro no tratamento de retorno:");
            System.out.println(exception.getMessage());
        } catch (Exception exception) {
            System.out.println("Ocorreu uma excessão inesperada:");
            System.out.println(exception.getMessage());
        }

        return new Address();
    }
}
