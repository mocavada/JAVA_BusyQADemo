package com.busyqa.javademo.purejdbc.inclass;

import java.sql.*;

public class MainInclass extends DBUtility {


    public static void main(String args[]) {

//        read_pureSql("'%'");
//        read_pureSql("'A%'");

        // example of sql injection
//        read_pureSql("'A%' OR Name LIKE 'T%'");
//        read_pureSql("'lweijflwejf' OR 1=1");

        // prepare statement
        read_prep("A%");
//        read_prep("'A%' OR Name LIKE 'T%'");

//        jdbc_insert("James Town");

//         jdbc_update("James Town", "busyQA Town");
//         jdbc_delete("%Town%");
    }

    public static void jdbc_insert(String cityName) {

        try (Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PWD)) {

            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO city(Name, Population) " +
                            "VALUES(?, '4')");
            stmt.setString(1, cityName);

            stmt.execute();
        } catch (SQLException e) {
            sqlErrorLog(e);
        }

        read_prep(cityName);
    }

    public static void jdbc_update(String oriName, String newName) {
        System.out.println("Before Update:");
        read_prep(oriName);

        try (Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PWD)) {

            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE city SET Name = ? WHERE Name = ?");
            stmt.setString(1, newName);
            stmt.setString(2, oriName);

            stmt.execute();

        } catch (SQLException e) {
            sqlErrorLog(e);
        }

        System.out.println("\nAfter Update:");
        read_prep(newName);
    }

    public static void jdbc_delete(String cityName) {
        System.out.println("\nBefore Delete:");
        read_prep(cityName);

        try (Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PWD);) {

            PreparedStatement stmt = conn.prepareStatement("DELETE FROM city WHERE Name LIKE ?");
            stmt.setString(1, cityName);

            stmt.execute();

        } catch (SQLException e) {
            sqlErrorLog(e);
        }

        System.out.println("\nAfter Delete:");
        read_prep(cityName);
    }

    public static void read_pureSql(String cityName) {
        try (Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PWD);) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM city WHERE Name LIKE " + cityName);


            // display data row by row
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " +
                        rs.getString(2) + "  " +
                        rs.getString(3));

            // try scroll courser
//            rs.first();
//            System.out.println("current row:" + rs.getRow());
//            rs.last();
//            System.out.println("current row:" + rs.getRow());
        } catch (SQLException e) {
            sqlErrorLog(e);
        }
    }


}
