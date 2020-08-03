/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoPgSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class DatabaseConnection {
    public static String url="jdbc:postgresql://localhost:5432/postgres";
        public static String username="postgres";
        public static String password="12345";
        
        public static Connection getConnection(){
            Connection cnn = null;
            try{
                cnn = DriverManager.getConnection(url,username,password);
                return cnn;
            }catch(SQLException e){
                System.err.println("Loi ket noi SQL : "+e);
                return null;
            }
        }
}
