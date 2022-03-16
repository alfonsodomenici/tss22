/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tss.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author tss
 */
public class Main {

    public static void main(String[] args) {
        try {
            String url = "jdbc:mariadb://localhost:3307";
            try ( Connection connection = DriverManager.getConnection(url, "root", "root")) {
                System.out.println("connessione ok...");
                connection.setCatalog("DBScuola");
                Statement cmd = connection.createStatement();
                try ( ResultSet rs = cmd.executeQuery("select * from t_corsi")) {
                    while (rs.next()) {
                        System.out.println(rs.getInt(1));
                    }
                }
                String createTable = "CREATE TABLE `DBScuola`.`xx` (\n"
                        + "  `id` INT NOT NULL AUTO_INCREMENT,\n"
                        + "  `testo` VARCHAR(45) NULL,\n"
                        + "  PRIMARY KEY (`id`));";
                
                String dropTable = "drop table xx;";
                
                cmd.executeUpdate(dropTable);
            }
        } catch (SQLException ex) {
            System.out.println("errore..." + ex);
        }
    }
}
