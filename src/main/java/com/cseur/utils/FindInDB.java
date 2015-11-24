package com.cseur.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jinliang.xue
 */
public class FindInDB extends javax.swing.JFrame {

    private Statement cnst;
    private ResultSet rs;

    /**
     * Creates new form FindInDB
     */
    public FindInDB() {
        initDB_Connection();
    }
    private void initDB_Connection() {
        System.out.println("-------- Oracle JDBC Connection Testing ------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;

        }

        System.out.println("Oracle JDBC Driver Registered!");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(""
);

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
        try {
            cnst = connection.createStatement();
            rs = cnst.executeQuery("select * from cd_user where CODE='ADMIN.DEHAM'");
            rs.setFetchSize(8);
            while (rs.next()) {
                String code = rs.getString("CODE");
                String pwd = rs.getString("PASSWORD");
//            int supplierID = rs.getInt("SUP_ID");
//            float price = rs.getFloat("PRICE");
//            int sales = rs.getInt("SALES");
//            int total = rs.getInt("TOTAL");
                System.out.println(code + "\t" + pwd);
//            System.out.println(coffeeName + "\t" + supplierID +
//                               "\t" + price + "\t" + sales +
//                               "\t" + total);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FindInDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
