package br.com.consultacep.main;

import br.com.consultacep.models.Address;
import br.com.consultacep.models.AddressRecord;
import br.com.consultacep.models.FileGenerator;
import br.com.consultacep.models.SearchCep;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SearchCep searchCep = new SearchCep();
        FileGenerator fileGenerator = new FileGenerator();
        String cep = "";

        while(!cep.contentEquals("Q")) {
            System.out.println("Digite o CEP da busca (ou digite \"Q\" para sair):");
            cep = scanner.next();

            if (cep.contentEquals("Q")) {
                break;
            }

            try {
                Address address = searchCep.request(cep);

                if (address.getIsFound()) {
                    System.out.println("\nEndereço encontrado:");
                    System.out.println(address);
                    fileGenerator.saveJSON(address);
                }
            } catch (RuntimeException exception) {
                System.out.println("Houve um erro na busca do cep:");
                System.out.println(exception.getMessage());
            }
        }
    }
}
