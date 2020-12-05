/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares;

import org.springframework.stereotype.Component;

/**
 *
 * @author Acer
 */
@Component("A")
public class AComponent implements AComponentIntf {
    
    private String data;

    /**
     * Get the value of data
     *
     * @return the value of data
     */
    @Override
    public String getData() {
        return data;
    }

    /**
     * Set the value of data
     *
     * @param data new value of data
     */
    @Override
    public void setData(String data) {
        this.data = data;
    }

}
