/*
GNU LESSER GENERAL PUBLIC LICENSE V3.0 
https://www.gnu.org/licenses/lgpl-3.0.fr.html 
 */
package lb.edu.isae;

/**
 *
 * @author Pascal Fares <pascal.fares at cofares.net>
 */
public class App {

    public static void m(int v2) {
        boolean condition = true;
        Bintf b;
        // Lire les donnees
        int v1 = new DataAccess().getData();

        //A l'extérieur on creer une instance de l'interface B
        
        //Un algorithme qui décide si il utilise B ou B1
        if (condition) {
                 b = new B(v1);
        } else {
             Bintf b = new B1();
        }
        //On la donne à A Faire les traitements
        A a = new A(b);

        //Afficher les résultat
        System.out.printf("la methode donne %s", a.uneMethode(v2));
    }
}
