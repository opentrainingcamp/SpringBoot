/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.taches;

import com.example.Tache;
import org.springframework.stereotype.Component;

/**
 *
 * @author Acer
 */
@Component
public class Fact implements Tache {

    @Override
    public boolean gere(String nomTache) {
        return nomTache.equals("!");
    }

    private long _fact(long n) {
        if (n==0) return 1;
        else return n*_fact(n-1);
    }
    @Override
    public Object lance(Object... args) {
        return (Long) _fact((Long)args[0]);
    }
    
}
