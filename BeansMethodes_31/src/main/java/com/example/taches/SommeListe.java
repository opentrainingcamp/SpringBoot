package com.example.taches;

import com.example.Tache;
import org.springframework.stereotype.Component;

/**
 *
 * @author Pascal Fares
 */
@Component
public class SommeListe implements Tache {

    @Override
    public boolean gere(String nomTache) {
        return nomTache.equals("msomme");
    }

    @Override
    public Object lance(Object ... args) {
        int res=0;
        for (Object arg : args) {
            res += (Integer) arg;
        }
        return res;
    }
    
}
