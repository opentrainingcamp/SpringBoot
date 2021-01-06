/*
GNU LESSER GENERAL PUBLIC LICENSE V3.0 
https://www.gnu.org/licenses/lgpl-3.0.fr.html 
 */
package lb.edu.isae;

/**
 * Definition forteent couplé
 * @author Pascal Fares <pascal.fares at cofares.net>
 */
public class ACouple {
    B b;
    
    public ACouple(int x){
        b = new B(x);
    }
    
    public int uneMethode(int n) {
        for (int i=0; i< n; i++) {
            b.inc();
        }
        return b.getX();
    }
}
