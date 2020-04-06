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
     * Retourne vrai si la liste contient un élément suivant.
     * @return boolean
     */
    boolean hasNext();
    /**
     * Retourne l'élément suivant.
     * @return InterfacePersonnels;
     */
    InterfacePersonnels next();
}
