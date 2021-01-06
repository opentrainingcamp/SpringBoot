/*
GNU LESSER GENERAL PUBLIC LICENSE V3.0 
https://www.gnu.org/licenses/lgpl-3.0.fr.html 
 */
package lb.edu.isae;

import java.util.Scanner;

/**
 *
 * @author Pascal Fares <pascal.fares at cofares.net>
 */
public class appCouple {
    public static void m(int v2) {
        // Lire les donnees
        int v1 = new DataAccess().getData();
        
        //Faire les traitements
        ACouple a = new ACouple(v1);
        
        //Afficher les résultat
        System.out.printf("la methode donne %s", a.uneMethode(v2));
    } 
}
