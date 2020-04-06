/**
 * Package de Gillot-Roux.
 * @since 1.0
 * @author Lockolocko
 */
package com.gillotroux;
/**
 * Iterateur.
 * @author Lockolocko
 */
public interface Iterator {
    /**
     * Retourne vrai si la liste contient un �l�ment suivant.
     * @return boolean
     */
    boolean hasNext();
    /**
     * Retourne l'�l�ment suivant.
     * @return InterfacePersonnels;
     */
    InterfacePersonnels next();
}
