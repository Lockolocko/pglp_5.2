/**
 * Package de Gillot-Roux.
 */
package com.gillotroux;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  * Interface DAO.
 * @author Lockolocko
 * @param <T>
 */
public abstract class DAO<T> {
    /**
     * Permet la connection à Derby plus tard.
     */
    protected Connection connect;
    /**
     * Constructeur explicit.
     */
    public DAO() {
        try {
            connect = DriverManager.getConnection("jdbc:derby:PersonnelTable;create=true");
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
    }
    /**
     * Permet la création d'un objet en SGBD.
     * @param obj
     * @return T
     */
    public abstract T create(T obj);
    /**
     * Trouver.
     * @param id
     * @return T
     */
    public abstract T find(String id);
    /**
     * Update.
     * @param obj
     * @return T
     */
    public abstract T update(T obj);
    /**
     * Supprimer.
     * @param obj
     */
    public abstract void delete(T obj);
}
