/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.taches;

import com.example.Tache;
import static java.lang.Integer.sum;
import java.util.Arrays;
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
    public Object lance(Object... args) {
        int res=0;
        for (Object arg : args) {
            res += (Integer) arg;
        }
        return res;
    }
    
}
