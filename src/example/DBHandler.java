package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DB Utility Class
 *
 * @author Richa
 */
public final class DBHandler {

    private static Connection con;
    private static PreparedStatement ps;
    private static final String DB_USERNAME = "practice";
    private static final String DB_PASSWORD = "practice";
    private static final String DB_DRIVER_NAME = "org.h2.Driver";
    private static final String PATH;

    /**
     * To Intialise db Path and run DDL Statements of the project
     */
    static {
        PATH = "jdbc:h2:" + System.getProperty("user.dir") + "/db";
        try {
            createTables();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private DBHandler() {

    }

    /**
     * @return Instance of Connection.
     */
    public static Connection getConnection() {
        if (con == null) {
            try {
                Class.forName(DB_DRIVER_NAME);
                con = DriverManager.getConnection(PATH, DB_USERNAME, DB_PASSWORD);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return con;

    }

    /**
     * Closes Connection.
     */
    public static void closeConnections() {
        try {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
            System.out.println("Closing Connection");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param sql Sql query to be executed
     * @return Instance of PreparedStatement.
     * @throws SQLException raises SQLException
     */
    private static PreparedStatement getPreparedStatement(String sql) throws SQLException {
        PreparedStatement ps = null;
        con = getConnection();
//        if(getGeneratedKey){
//        ps = con.prepareStatement(sql);
//        }else{
        ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
//        }

        return ps;
    }

    /**
     * Creates all tables to be used .
     *
     * @throws SQLException raises SQLException
     */
    public static void createTables() throws SQLException {
        String queries[] = DDL.getDDL();
        for (String query : queries) {
            ps = getPreparedStatement(query);
            ps.executeUpdate();
        }

    }

    /**
     * @param sql Sql query to be executed
     * @param param Parameters in Sql query
     * @return last insert.
     * @throws SQLException raises SQLException
     */
    public static int ins_up_del(String sql, ArrayList param) throws SQLException {
        int rowsAff = -1;
        ps = getPreparedStatement(sql);
        int paramCount = param == null ? 0 : param.size();
        for (int index = 0; index < paramCount; index++) {
            ps.setObject(index + 1, param.get(index));
        }
        rowsAff = ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            rowsAff = rs.getInt(1);
        }
        return rowsAff;
    }

    /**
     * @param sql Sql query to be executed
     * @param param Parameters in Sql query
     * @return instance of ResultSet.
     * @throws SQLException raises SQLException
     */
    public static ResultSet getData(String sql, ArrayList param) throws SQLException {

        ps = getPreparedStatement(sql);
        int paramCount = param == null ? 0 : param.size();
        for (int index = 0; index < paramCount; index++) {
            ps.setObject(index + 1, param.get(index));
        }
        ResultSet rs = ps.executeQuery();

        return rs;
    }

}
