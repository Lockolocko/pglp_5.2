/**
 * Package de Gillot-Roux.
 */
package com.gillotroux;

import java.io.Serializable;
import java.sql.Connection;
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
            final int un = 1;
            final int deux = 2;
            final int trois = 3;
            final int quatre = 4;
            final int cinq = 5;
            Connection connect = super.getConnection();
            PreparedStatement prepare = connect.prepareStatement("INSERT INTO "
                    + "PersonnelTable "
                    + "(nom,prenom,birth,numPerso,numPro) VALUES(?,?,?,?,?)");
            prepare.setString(un, obj.getNom());
            prepare.setString(deux, obj.getPrenom());
            prepare.setString(trois, obj.getDate().toString());
            prepare.setInt(quatre, obj.getNumPerso());
            prepare.setInt(cinq, obj.getNumPro());
            int result =  prepare.executeUpdate();
            assert result == 1;
        } catch (SQLException e) {
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
            final int un = 1;
            Connection connect = super.getConnection();
            PreparedStatement prepare = connect.prepareStatement("SELECT *"
                    + " FROM PersonnelTable "
                    + "WHERE nom = ?");
            prepare.setString(un, id);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                p = new Personnel.Builder(result.getString("nom"),
result.getString("prenom"), LocalDate.parse(result.getString("birth"))).build();
            }

        } catch (SQLException e) {
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
            final int un = 1;
            final int deux = 2;
            final int trois = 3;
            final int quatre = 4;
            final int cinq = 5;
            Connection connect = super.getConnection();
            PreparedStatement prepare = connect.prepareStatement("UPDATE"
                    + " PersonnelTable "
                    + "SET prenom = ?, birth = ?, numPerso = ? ,numPro = ? "
                    + "WHERE nom = ?");
            prepare.setString(cinq, obj.getNom());
            prepare.setString(un, obj.getPrenom());
            prepare.setString(deux, obj.getDate().toString());
            prepare.setInt(trois, obj.getNumPerso());
            prepare.setInt(quatre, obj.getNumPro());
            int result =  prepare.executeUpdate();
            assert result == 1;
        } catch (SQLException e) {
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
            final int un = 1;
            Connection connect = super.getConnection();
            PreparedStatement prepare = connect.prepareStatement("DELETE"
                    + " FROM PersonnelTable "
                    + "WHERE nom = ?");
            prepare.setString(un, obj.getNom());
            int result =  prepare.executeUpdate();
            if (result == 1) {
                System.out.println("Personnel supprimé");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
