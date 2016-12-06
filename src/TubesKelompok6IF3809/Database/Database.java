/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TubesKelompok6IF3809.Database;

import TubesKelompok6IF3809.Model.*;
import TubesKelompok6IF3809.View.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author A_CITRA
 */
public class Database {

    private Connection c;

    public void buatKoneksi() {
        try {
            String url = "jdbc:mysql://localhost:3306";
            String hostname = "root";
            String password = "y";
            //Class.forName("com.mysql.jdbc.Drivers");
            c = DriverManager.getConnection(url, hostname, password);
        } catch (SQLException exception) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

}
