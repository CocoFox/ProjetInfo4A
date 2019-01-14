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
import java.util.ArrayList;

/**
 *
 * @author pacomebondetdelabernardie
 */
public class SQLGameBuilder {

// JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/ProjetINFO4A";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "info4APOLY";

    public static void print(String s) {
        System.out.println(s);
    }

    public ArrayList<Game> loadGamesFromDataBase() {
        Connection conn = null;
        Statement stmt = null;
        Statement stmt2 = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statements...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Games";
            ResultSet rs = stmt.executeQuery(sql);
            int id;
            String gameName = null;
            Company company;
            Price price;
            ESRB_Rating rating;
            ReleaseDate releaseDate;
            Boolean available;
            Console console;
            Categories categories = null;
            
            ArrayList<Game> games = new ArrayList<>();
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name

                id = rs.getInt("id");
                gameName = rs.getString("gamename");
                company = new Company(rs.getString("company"));
                price = new Price(rs.getFloat("price"));
                rating = new ESRB_Rating(rs.getString("ESRB_rating"));
                releaseDate = new ReleaseDate(rs.getDate("release_date"));
                available = rs.getBoolean("available");
                console = new Console(rs.getString("console"));

                categories = new Categories();

                //print(releaseDate.toString());

                sql = "SELECT C.category_name\n"
                        + "FROM Games G, Category C, CategoryBelong B\n"
                        + "WHERE G.id = B.game_id\n"
                        + "AND C.id = B.category_id \n"
                        + "AND G.gamename = \"" + gameName + "\";";

                stmt2 = conn.createStatement();

                ResultSet rs2 = stmt2.executeQuery(sql);
                while (rs2.next()) {
                    categories.addCategory(rs2.getString("category_name"));
                    //print(rs2.getString("category_name"));
                }
                
                games.add(new Game(id,gameName,company,price,rating,releaseDate,available,console,categories));
            }

            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();

            // STEP 7: Return Objects
            return games;
            
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        return null;
    }//end main
}//end FirstExample
