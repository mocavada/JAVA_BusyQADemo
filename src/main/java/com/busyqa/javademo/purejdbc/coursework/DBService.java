package com.busyqa.javademo.purejdbc.coursework;

import com.busyqa.javademo.purejdbc.inclass.DBUtility;

import java.sql.*;

public class DBService extends DBUtility {

    public static void jdbc_insert(String cityName, String cityPopulation) {
        try (Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PWD)) {

            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO city(Name, CountryCode, District, Population) VALUES(?, 'CAN', 'District 9', ?)");
            stmt.setString(1, cityName);
            stmt.setInt(2, Integer.parseInt(cityPopulation));
            stmt.execute();
        } catch (SQLException e) {
            sqlErrorLog(e);
        } catch (Exception e) {

        }

        read_prep(cityName);
    }

    public static void jdbc_update(int id, int population) {
        System.out.println("Before Update");
        searchCityByID(id);
        try (Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PWD);) {

            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE city SET Population = ? WHERE ID = ?");
            stmt.setInt(1, population);
            stmt.setInt(2, id);
            stmt.execute();

        } catch (SQLException e) {
            sqlErrorLog(e);
        }
        System.out.println("After Update");
        searchCityByID(id);
    }

    public static void jdbc_delete(int id) {
        try (Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PWD);) {

            PreparedStatement stmt = conn.prepareStatement("DELETE FROM city WHERE ID = ?");
            stmt.setInt(1, id);
            stmt.execute();

        } catch (SQLException e) {
            sqlErrorLog(e);
        }
        System.out.println("After Delete");
        searchCityByID(id);
    }

    // ========
    public static void searchCityByID(int id) {
        try (Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PWD);) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM city WHERE ID = ?");
            stmt.setInt(1, id);
            // System.out.println(stmt.toString());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                do {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                            + "  " + rs.getString(3) + "  " + rs.getString(5));
                } while (rs.next());
            } else {
                System.out.println("No data found.");
            }

        } catch (SQLException e) {
            sqlErrorLog(e);
        }
    }

}
