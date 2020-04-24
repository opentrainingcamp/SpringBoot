package com.example;

/**
 * Une tache définie par un nom et une activité
 * @author Pascal Fares
 */
public interface Tache {
    public boolean gere(String nomTache);
    public Object lance(Object ...args);
    
}
