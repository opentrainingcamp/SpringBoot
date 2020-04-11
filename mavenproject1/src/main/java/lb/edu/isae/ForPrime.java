/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lb.edu.isae;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Acer
 */
@Named(value = "forPrime")
@SessionScoped
public class ForPrime {

    private String text;
 
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    /**
     * Creates a new instance of ForPrime
     */
    public ForPrime() {
    }
    
}
