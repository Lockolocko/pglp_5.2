/**
 * Package de Gillot-Roux.
 */
package com.gillotroux;
/**
 *  * Interface DAO.
 * @author Lockolocko
 * @param <T>
 */
public interface DAO<T> {
    //protected Connection connect = /* ... */;
    /**
     * Permet la création d'un objet en SGBD.
     * @param obj
     * @return T
     */
    T create(T obj);
    /**
     * Trouver.
     * @param id
     * @return T
     */
    T find(String id);
    /**
     * Update.
     * @param obj
     * @return T
     */
    T update(T obj);
    /**
     * Supprimer.
     * @param obj
     */
    void delete(T obj);
}
