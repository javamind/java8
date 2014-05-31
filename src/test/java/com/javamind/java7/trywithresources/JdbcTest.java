package com.javamind.java7.trywithresources;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ninja_squad.dbsetup.Operations.deleteAllFrom;
import static com.ninja_squad.dbsetup.Operations.sequenceOf;

/**
 * En java 7 l'API JDBC a été retouchée pour acceptée le try with resources
 * http://docs.oracle.com/javase/7/docs/technotes/guides/jdbc/
 */
public class JdbcTest {

    public static final String DB_SERVER = "localhost";
    public static final String DB_NAME = "devoxx2014";
    public static final String DB_USER = "devoxx2014";
    public static final String DB_PASSWORD = "devoxx2014";
    public static final int DB_PORT = 5432;




    /**
     * Utilsiation de JDBC pour se connecter à la base de données sans try with resource
     */
    @Test
    public void connectToDatabaseJava6() throws SQLException {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(String.format("trywithresources:postgresql://%s:%d/%s", DB_SERVER, DB_PORT, DB_NAME), DB_USER, DB_PASSWORD);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from COUNTRY");
            while(rs.next()){
                System.out.println(String.format("CODE=[%s] LABEL=[%s]", rs.getString("Code"), rs.getString("Label")));
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println(String.format("Erreur %d occured %s ", e.getErrorCode(), e.getMessage()));
        } finally {
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println(String.format("Erreur %d occured when we tried to close statement : %s ", e.getErrorCode(), e.getMessage()));
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.err.println(String.format("Erreur %d occured when we tried to close database : %s ", e.getErrorCode(), e.getMessage()));
                }
            }
        }

        Assertions.assertThat(stmt.isClosed()).isEqualTo(true);
        Assertions.assertThat(conn.isClosed()).isEqualTo(true);

    }

    /**
     * Utilsiation de JDBC pour se connecter à la base de données sans try with resource
     */
    @Test
    public void connectToDatabaseJava7() throws SQLException{
        Connection conn1= null;
        Statement stmt1 = null;

        try(Connection conn=DriverManager.getConnection(String.format("trywithresources:postgresql://%s:%d/%s", DB_SERVER, DB_PORT, DB_NAME), DB_USER, DB_PASSWORD);
            Statement stmt = conn.createStatement();){
            ResultSet rs = stmt.executeQuery("select * from COUNTRY");
            while(rs.next()){
                System.out.println(String.format("CODE=[%s] LABEL=[%s]", rs.getString("Code"), rs.getString("Label")));
            }
            rs.close();
            conn1 = conn;
            stmt1 = stmt;
        } catch (SQLException e) {
            System.err.println(String.format("Erreur %d occured %s ", e.getErrorCode(), e.getMessage()));
        }

        Assertions.assertThat(stmt1.isClosed()).isEqualTo(true);
        Assertions.assertThat(conn1.isClosed()).isEqualTo(true);

    }

}
