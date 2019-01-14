/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Editor;

import java.sql.*;
import Model.*;
import Model.criteria.Categories;
import Model.criteria.Company;
import Model.criteria.Console;
import Model.criteria.ESRB_Rating;
import Model.criteria.Price;
import Model.criteria.ReleaseDate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author pacomebondetdelabernardie
 */
public class SQLGameAdder {

// JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/ProjetINFO4A";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "info4APOLY";

    public static void print(String s) {
        System.out.println(s);
    }
    public java.sql.Date parseDate(String dateString) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        java.util.Date utilDate = null;
        java.sql.Date sqlDate = null;
        try {
            utilDate = formatter.parse(dateString);
            sqlDate = new java.sql.Date(utilDate.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sqlDate;
    }

    // insert with primitive Types
    public void insertGameIntoDatabase(
            String gameName,
            String company,
            Float price,
            String rating,
            String releaseDate,
            Boolean available,
            String console,
            ArrayList<String> categories
    ) {
        Connection conn = null;
        
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statements...");
            String sql;
            sql = "INSERT INTO Games (gamename,company,price,ESRB_rating,release_date,available,console) VALUES (?,?,?,?,?,?,?);";
            PreparedStatement prest = conn.prepareStatement(sql);

            prest.setString(1, gameName);
            prest.setString(2, company);
            prest.setFloat(3, price);
            prest.setString(4, rating);
            prest.setDate(5,parseDate(releaseDate)); 
            prest.setBoolean(6, available);
            prest.setString(7, console);
            
            int row = prest.executeUpdate();
            System.out.println(row + " row(s) affected)");
            
            Iterator<String> stringIterator = categories.iterator();
            String sql2;
            PreparedStatement prest2 = null;
            while(stringIterator.hasNext()){
                sql2 =  "INSERT INTO CategoryBelong\n" +
                        "SELECT G.id, C.id\n" +
                        "FROM Games G, Category C\n" +
                        "WHERE G.gamename = ?\n" +
                        "AND C.category_name = ?;";
                prest2 = conn.prepareStatement(sql2);
                prest2.setString(1, gameName);
                prest2.setString(2, stringIterator.next());
                
                int row2 = prest2.executeUpdate();
            System.out.println(row2 + " row(s) affected)");
                
                
                
            }
            
            
            //STEP 6: Clean-up environment
            prest.close();
            prest2.close();
            conn.close();

  
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }//end try
        System.out.println("Added Game!");
    }
}//end FirstExample
