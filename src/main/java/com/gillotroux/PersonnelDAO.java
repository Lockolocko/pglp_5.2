/**
 * Package de Gillot-Roux.
 */
package com.gillotroux;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class PersonnelDAO extends DAO<Personnel>
implements Serializable {
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
        try {
            PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO PersonnelTable "
                    + "(nom,prenom,birth,numPerso,numPro) VALUES(?,?,?,?,?)");
            prepare.setString(1,obj.getNom());
            prepare.setString(2, obj.getPrenom());
            prepare.setString(3, obj.getDate().toString());
            prepare.setInt(4,obj.getNumPerso());
            prepare.setInt(5, obj.getNumPro());
            int result =  prepare.executeUpdate();
            assert result == 1;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }
    /**
     * Trouve Personnel en SGBD.
     * @param id
     * @return Personnel
     */
    public Personnel find(final String id) {
        Personnel p = null;
        try {
            PreparedStatement prepare = this.connect.prepareStatement("SELECT * FROM PersonnelTable"
                    + "WHERE nom = ?");
            prepare.setString(1, id);
            ResultSet result = prepare.executeQuery();
            
            if (result.first()) {
                p = new Personnel.Builder(result.getString("nom"), result.getString("prenom"),LocalDate.parse(result.getString("birth"))).build();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
    /**
     * Update Personnel en SGBD.
     * @param obj
     * @return Personnel
     */
    public Personnel update(final Personnel obj) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("UPDATE PersonnelTable "
                    + "SET prenom = ?, birth = ?, numPerso = ? ,numPro = ?"
                    + "WHERE nom = ?");
            prepare.setString(5,obj.getNom());
            prepare.setString(1, obj.getPrenom());
            prepare.setString(2, obj.getDate().toString());
            prepare.setInt(3,obj.getNumPerso());
            prepare.setInt(4, obj.getNumPro());
            int result =  prepare.executeUpdate();
            assert result == 1;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }
    /**
     * Supprime Personnel en SGBD.
     * @param obj
     */
    public void delete(final Personnel obj) {
        try {
            PreparedStatement prepare = this.connect.prepareStatement("DELETE FROM PersonnelTable "
                    + "WHERE nom = ?");
            prepare.setString(1,obj.getNom());
            int result =  prepare.executeUpdate();
            if (result == 1) {
                System.out.println("\n Personnel supprimé");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
