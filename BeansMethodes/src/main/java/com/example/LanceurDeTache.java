/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.Collection;
import java.util.Optional;

/**
 *
 * @author Acer
 */
public class LanceurDeTache {
    private final Collection<Tache> taches;
    
    public LanceurDeTache(Collection<Tache> taches) {
        this.taches = taches;
    }
    public void afficherResultat(String nomTache, Object ...params) {
        Optional<Tache> st = taches.stream().filter(t -> t.gere(nomTache)).findAny();
        if (st.isPresent()){
            System.out.println(st.get().lance(params).toString());
        }
    }
}
