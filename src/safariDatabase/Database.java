/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemonGame;

import entity.Pokemon;
import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ikmal
 */
public class Database {

    Connection con;

    public Database() {
        connection();
    }

    public void connection() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Pokemon", "postgres", "Haikal-2004");
            System.out.println("Database connect");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void save(String name, String position, List<String> badges, Pokemon pokemon) {
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO POKEMON VALUES(?,?,?,?)");
            stmt.setString(1, name);
            stmt.setString(2, position);
            stmt.setString(3, String.join(",", badges));
            stmt.setArray(4, (Array) pokemon);
            stmt.execute();
            System.out.println("Saving successfull");
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void load() {
        Statement stmt;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM POKEMON");
            while (rs.next()) {
                String name = rs.getString("name");
                String position = rs.getString("position");
                // Convert the stored badges string back to a list
                List<String> badges = Arrays.asList(rs.getString("badges").split(","));
                //add trainer pokemon;

            }
            System.out.println("Load successfull");
            stmt.close();;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
