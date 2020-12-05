/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Acer
 */
@Component
public class MyApp {

    @Autowired
    BComponentIntf b;
    
    public String uneMeth() {
        return String.format("Dans Demo App appel d'un bean %s", b.uneMeth());
    }

}
