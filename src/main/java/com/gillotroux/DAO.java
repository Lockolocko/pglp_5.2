/**
 * Package de Gillot-Roux.
 */
package com.gillotroux;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
            //Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            connect = DriverManager.getConnection("jdbc:derby://localhost:1527/PersonnelTable;create=true");
            if (existe(connect,"PersonnelTable")) {
            // Création table.
            java.sql.Statement prepare = connect.createStatement();

            //Executing the query
            String query = "CREATE TABLE IF NOT EXISTS PersonnelTable( "
+ "id INT NOT NULL GENERATED ALWAYS AS IDENTITY, "
+ "nom VARCHAR(255), "
+ "prenom VARCHAR(255),"
+ "birth VARCHAR(255), "
+ "numPerso INT,"
+ "numPro INT,"
+ "PRIMARY KEY (id))";
               prepare.execute(query);
               System.out.println("Table du Personnel creer");
            }
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
    /**
     * Verifie si une table existe.
     */
    public static boolean existe(Connection connection, String nomTable)
throws SQLException {
    boolean existe;
    DatabaseMetaData dmd = connection.getMetaData();
    ResultSet tables = dmd.getTables(connection.getCatalog(),null,nomTable,null);
    existe = tables.next();
    tables.close();
    //System.out.println(existe);
    return existe;  
}
}
