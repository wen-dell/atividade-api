package com.mycompany.atividadeapi;

import java.util.Scanner;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 *
 * @author Wendell
 */
public class Aplicacao {
    
    public static String acessarAPI(String mensagem){
        mensagem = Aplicacao.tratarString(mensagem);
        try {
            HttpResponse<String> response = Unirest.get("https://yoda.p.mashape.com/yoda?sentence=" + mensagem)
                    .header("X-Mashape-Key", "2oFoGI8iDWmshtDyWfMA6hn4P3AZp1tI60djsnNR2MRgAIqu35")
                    .header("Accept", "text/plain")
                    .asString();
            return response.getBody();
        } catch (UnirestException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        return null;
    }
    
    private static String tratarString(String mensagem){
        mensagem = mensagem.replace(" ", "+");
        return mensagem;
    }

}
