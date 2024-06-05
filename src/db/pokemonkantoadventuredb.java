package src.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class pokemonkantoadventuredb {
    
    public static void main(String[] args){
        createConnection();

    }

    static void createConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pkadb", "root", "root");
            System.out.println("Connection established!");
            Statement ex = con.createStatement();
            ResultSet rs = ex.executeQuery("SELECT * from pokemon");
            while(rs.next()){
                String name = rs.getString(2);
                System.out.println(name);
            }
        } catch(SQLException e){Logger.getLogger(pokemonkantoadventuredb.class.getName()).log(Level.SEVERE,null,e);}
        catch(ClassNotFoundException e){Logger.getLogger(pokemonkantoadventuredb.class.getName()).log(Level.SEVERE,null,e);}
    }
}
