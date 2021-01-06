/*
GNU LESSER GENERAL PUBLIC LICENSE V3.0 
https://www.gnu.org/licenses/lgpl-3.0.fr.html 
 */
package lb.edu.isae;

/**
 * Un exemple quelconque
 *
 * @author Pascal Fares <pascal.fares at cofares.net>
 */
public class B implements Bintf {

    private int _x;

    public B(int x) {
        _x = x;
    }

    public int inc() {
        setX(getX() + 1);
        return getX();
    }

    public int dec() {
        setX(getX() - 1);
        return getX();
    }

    /**
     * @return the _x
     */
    public int getX() {
        return _x;
    }

    /**
     * @param _x the _x to set
     */
    public void setX(int _x) {
        this._x = _x;
    }
}
