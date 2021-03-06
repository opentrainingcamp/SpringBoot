package com.example;

import java.util.Collection;
import java.util.Optional;
import org.springframework.stereotype.Component;

/**
 * En rempleacement de la methode annoté Bean
 * ici le composant possédant un seul contructeur fera la même chose
 * @author Acer
 */

@Component
public class LanceurDeTache {
    private final Collection<Tache> taches;
    
    public LanceurDeTache(Collection<Tache> taches) {
        this.taches = taches;
    }
    public <T> void afficherResultat(String nomTache, T ...params) {
        Optional<Tache> st = taches.stream().filter(t -> t.gere(nomTache)).findAny();
        if (st.isPresent()){
            System.out.println(st.get().lance(params).toString());
        }
    }
}
