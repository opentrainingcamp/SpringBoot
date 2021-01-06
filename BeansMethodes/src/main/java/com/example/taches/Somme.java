package com.example.taches;

import com.example.Tache;
import org.springframework.stereotype.Component;

/**
 * @author Pascal Fares
 */
@Component
public class Somme implements Tache {

    @Override
    public boolean gere(String nomTache) {
        return nomTache.equals("somme");
    }

    @Override
    public Object lance(Object... args) {
       Integer v1= (Integer) args[0];
       Integer v2= (Integer) args[1];
       
       return (v1 + v2);
    }
    
}
