package com.example;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Créeation de Beans a partir d'annotoation Component et contructeur unique
 * et injection ApplicationRunner
 *
 * @author Pascal Fares
 */
@SpringBootApplication
public class BasicApplication {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(BasicApplication.class, args);
        /* Ne pas initialiser manuellement!
                var lt = ctx.getBean(LanceurDeTache.class);
                System.out.print("Fact 5:");
                lt.afficherResultat("!", (long) 5);
                System.out.print("2 + 4");
                lt.afficherResultat("somme", (Integer) 2, (Integer) 4);
         */
    }

    @Bean
    public ApplicationRunner lanceurDuLanceurDeTache(LanceurDeTache lt,
        @Value("${op}") String op, @Value("${op.a}") Integer[] iargs) {
        
        return args -> {
           System.out.printf("%s", op);
           for (int i=0; i< iargs.length; i++ )System.out.printf("%d ",iargs[i]);
           lt.afficherResultat(op, (Object[]) iargs);
        };
    }

}
