/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel
 */
public class TestMySQLJDBC {
    public static void main(String[] args) {
        var url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            Connection conexion = DriverManager.getConnection(url, "root", "Skull@130187");
            Class.forName("com.mysql.cj.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestMySQLJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TestMySQLJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
