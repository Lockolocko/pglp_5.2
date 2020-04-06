/**
 * Package de Gillot-Roux.
 */
package com.gillotroux;

import java.io.Serializable;

public class PersonnelDAO implements DAO<Personnel>,
Serializable {
    /**
     * Serialisation id.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Creer Personnel en SGBD.
     * @param obj
     * @return Personnel
     */
    public Personnel create(final Personnel obj) {
        // TODO Auto-generated method stub
        return obj;
    }
    /**
     * Trouve Personnel en SGBD.
     * @param id
     * @return Personnel
     */
    public Personnel find(final String id) {
        Personnel p;
        // TODO Auto-generated method stub
        return null;
    }
    /**
     * Update Personnel en SGBD.
     * @param obj
     * @return Personnel
     */
    public Personnel update(final Personnel obj) {
        // TODO Auto-generated method stub
        return obj;
    }
    /**
     * Supprime Personnel en SGBD.
     * @param obj
     */
    public void delete(final Personnel obj) {
        // TODO Auto-generated method stub
    }

}
