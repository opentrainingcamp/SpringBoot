/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Acer
 */
@Component("B")
public class BComponent implements BComponentIntf {
    @Autowired
    AComponentIntf Acomp;
    
    @PostConstruct
    public void after() {
        Acomp.setData("Bonjour");
    }
    @Override
    public String uneMeth() {
        return Acomp.getData();
    }
}
