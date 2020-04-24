package com.example;

import java.util.Collection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Créeation de Beans a partir d'annotoation de méthodes @Bean
 *
 * @author Pascal Fares
 */
@SpringBootApplication
public class BasicApplication {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(BasicApplication.class, args);
        var lt = ctx.getBean(LanceurDeTache.class);
        System.out.print("Fact 5: ");
        lt.afficherResultat("!", (long) 5);
        System.out.print("2 + 4 = ");
        lt.afficherResultat("somme", (Integer) 2, (Integer) 4);
    }


}
