/*
GNU LESSER GENERAL PUBLIC LICENSE V3.0 
https://www.gnu.org/licenses/lgpl-3.0.fr.html 
 */
package lb.edu.isae;

/**
 *
 * @author Pascal Fares <pascal.fares at cofares.net>
 */
public class A {
    Bintf b;
    
    //solution 1
    public A(Bintf b){
        this.b = b;
    }
    
    //solution2
    public void setB(Bintf b){
        this.b=b;
    }
    
    public int uneMethode(int n) {
        for (int i=0; i< n; i++) {
            b.inc();
        }
        return b.getX();
    }
}
