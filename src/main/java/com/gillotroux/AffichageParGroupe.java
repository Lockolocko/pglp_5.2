/**
 * Package de Gillot-Roux.
 */
package com.gillotroux;

import java.util.ArrayList;

/**
 * Affichage par groupe.
 * @author Lockolocko
 */
public class AffichageParGroupe implements java.io.Serializable {
    /**
     * ArrayList.
     */
    private ArrayList<InterfacePersonnels> arr =
new ArrayList<InterfacePersonnels>();
    /**
     * Version de classe.
     */
    private static final long serialVersionUID = 1;
    /**
     * Constructeur.
     * @param root
     */
    public AffichageParGroupe(final InterfacePersonnels root) {
        arr.add(root);
    }

    /**
     * Groupe iterateur.
     * @author Lockolocko
     */
    private class GrpIterator implements Iterator {
        /**
         * Indice d'indexation.
         */
        private int verifie = 0;

        /**
         * Création de l'arrayList.
         */
        GrpIterator() {
            while (verifie < arr.size()) {
                // "Instance of" pour savoir si c'est un composite:
                // on ajoute tous les éléments du composite
                // ou un Personnel: on ne fait rien
                if (arr.get(verifie) instanceof CompositePersonnels) {
                    CompositePersonnels composite =
(CompositePersonnels) arr.get(verifie);
                    arr.remove(verifie);
                    for (Personnel p1 : composite.getListe()) {
                        arr.add(p1);
                    }
                }
                verifie++;
            }
            verifie = 0;
        }

        /**
         * Vérifie si il y a un élément suivant.
         * @return boolean
         */
        public boolean hasNext() {
            if (verifie < arr.size()) {
                return true;
            }
            return false;
        }

        /**
         * Retourne l'élément suivant.
         * @return Personnel
         */
        public InterfacePersonnels next() {
            if (this.hasNext()) {
                InterfacePersonnels perso = arr.get(verifie++);
                return perso;
            }
            return null;
        }
    }

    /**
     * Donne un accès à hasNext() et next().
     * @return Iterator
     */
    public Iterator getIterator() {
        return new GrpIterator();
    }
}
