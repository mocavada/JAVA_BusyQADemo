package com.busyqa.javademo.purejdbc.inclass;

import java.sql.*;

public class DBUtility {
    protected static final String USERNAME = "root";
    protected static final String PWD = "mysql";
    protected static final String CONN_STRING = "jdbc:mysql://localhost:3306/busyqademo?useSSL=false";
    // jdbc:mysql://[host1][:port1][,[host2][:port2]]...[/[database]] »

    public static void read_prep(String cityName) {

        try (Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PWD);) {

            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT * FROM city WHERE Name LIKE ?");
            stmt.setString(1, cityName);

//            System.out.println("SQLException: " + stmt.toString());

            ResultSet rs = stmt.executeQuery();

            while (rs.next())
                System.out.println(rs.getInt(1) + "  " +
                        rs.getString(2) + "  " +
                        rs.getString(3));

        } catch (SQLException e) {
            sqlErrorLog(e);
        }

    }

    public static void sqlErrorLog(SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
        System.out.println("SQLState: " + e.getSQLState());
        System.out.println("VendorError: " + e.getErrorCode());
    }

    public static void showCityResult(ResultSet rs) throws SQLException {
        while (rs.next())
            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
    }
}
