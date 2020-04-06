/**
 * Package de Gillot-Roux.
 */
package com.gillotroux;
/**
 * Fabrique DAO.
 * @author Lockolocko
 */
public final class DAOFactory implements java.io.Serializable {
   /**
     * ID serialization.
     */
    private static final long serialVersionUID = 3L;
    /**
     * Construteur privée.
     */
    private DAOFactory() {
    }
/**
 * Fabrique DAO<Personnel>.
 * @return DAO<Personnel>
 */
 public static DAO<Personnel> getPersonnelDAO() {
        return new PersonnelDAO();
    }
}
