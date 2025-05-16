package br.com.consultacep.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void saveJSON(Address address) {
        try {
            FileWriter writer = new FileWriter(address.getCep() + ".json");
            writer.write(gson.toJson(address));
            writer.close();
            System.out.println("Arquivo JSON gerado com sucesso!\n");
        } catch (IOException exception) {
            System.out.println("Houve um erro na criação do arquivo de texto:");
            System.out.println(exception.getMessage());
        }
    }
}
