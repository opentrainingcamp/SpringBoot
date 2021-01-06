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
public class DataAccess {
    public int getData() {
        Scanner myInput = new Scanner( System.in );
        System.out.print( "Saisir un entier: " );
        int v1 = myInput.nextInt();
        return v1;
    }
}
