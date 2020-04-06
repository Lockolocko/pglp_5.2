/**
 * Package de Gillot-Roux.
 */

package com.gillotroux;

import java.time.LocalDate;

/**
 * Création d'un personnel.
 * @author Lockolocko
 *
 */
public final class Personnel implements InterfacePersonnels,
java.io.Serializable {
/**
 * Nom du personnel.
 */
    private final String nom;
/**
 * Prenom du personnel.
 */
    private final String prenom;
/**
 * Date de naissance du personnel.
 */
    private final LocalDate dateDeNaissance;
/**
 * Numéro fixe professionnel.
 */
    private final int numeroFixPro;
/**
 * Numéro fixe personnel.
 */
    private final int numeroFixPer;
    /**
     * Version de classe.
     */
    private static final long serialVersionUID = 3;
/**
 * Constructeur de la classe.
 * @param builder
 */
    private Personnel(final Builder builder) {
        // Required parameters
        nom = builder.nom;
        prenom = builder.prenom;
        dateDeNaissance = builder.dateDeNaissance;

        // Optionnal parameters
        numeroFixPro = builder.numeroFixPro;
        numeroFixPer = builder.numeroFixPer;
    }

/**
 * Classe permettant la structure Builder.
 * @author Lockolocko
 *
 */
    public static class Builder {
        // Required parameters
/**
 * Nom.
 */
        private final String nom;
/**
 * Prenom.
 */
        private final String prenom;
/**
 * Date de naissance.
 */
        private final LocalDate dateDeNaissance;

        // Optionnal parameters
        /**
         * Numero fixe professionnel.
         */
        private int numeroFixPro = 0;
        /**
         * Numero fixe personnel.
         */
        private int numeroFixPer = 0;
/**
 * Constructeur de la classe builder.
 * @param nom2
 * @param prenom2
 * @param dateDeNaissance2
 */
        public Builder(final String nom2,
final String prenom2, final LocalDate dateDeNaissance2) {
            this.nom = nom2;
            this.prenom = prenom2;
            this.dateDeNaissance = dateDeNaissance2;
        }
/**
 * Permet d'ajouter un numero fixe professionnel.
 * @param numero
 * @return {@link Builder}
 */
        // Fonction des parameters optionnal
        public Builder numeroFixPro(final int numero) {
            numeroFixPro = numero;
            return this;
        }
/**
 * Permet d'ajouter un numero fixe personnel.
 * @param numero
 * @return {@link Builder}
 */
        public Builder numeroFixPer(final int numero) {
            numeroFixPer = numero;
            return this;
        }
/**
 * Permet de recast en Peronnel.
 * @return {@link Personnel}
 */
        public Personnel build() {
           return new Personnel(this);
        }
    }
/**
 * Fonction d'affichage.
 */
    public void print() {
        System.out.println(nom + " " + prenom);
    }
}
