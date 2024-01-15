package org.voiculescu.siit.temawk15.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This class handles all the connection request to the database
 */
public class Database {

    public static final String TYPE = "mysql";
    public static final String HOSTNAME = "localhost";
    public static final int PORT = 3306;
    public static final String DB_NAME = "booking";
    public static final String USER = "root";
    public static final String PW = "Administr@tor";

    private static final String SQL_INSERT_ACCOMMODATION = "INSERT INTO accommodation (id, type, bed_type, max_guests, description) "
            + "VALUES (?,?,?,?,?)";
    private static final String SQL_INSERT_ROOM_FAIR = "INSERT INTO room_fair (id, value, season)"
            + "VALUES (?,?,?)";
    private static final String SQL_INSERT_RELATION = "INSERT INTO accommodation_fair_relation (id, id_accommodation, id_room_fair)"
            + "VALUES (?,?,?)";

    /**
     * makes the Database class fully static
     */
    private Database() {
    }

    /**
     * Sql connector to the database. See the constants for defining the connection
     *
     * @param type     SQL database type
     * @param hostname location of the SQL server
     * @param port     of the SQL server
     * @param dbName   database name
     * @param user     connecting user
     * @param password connecting password
     * @return a Connection to the SQL server ot <b>null</b> if the connection was not possible
     */
    private static Connection connect(String type, String hostname, int port, String dbName, String user, String password) {
        DriverManager.setLoginTimeout(60);
        try {
            String url = "jdbc:" + type + "://" + hostname + ":" + port + "/" + dbName +
                    "?user=" + user + "&password=" + password;
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database: " + e.getMessage());
        }
        return null;
    }

    /**
     * inserts a new entry into Accommodation table
     *
     * @param pKeyAccommodation primary key of the entry
     * @param type              the Accommodation <b>type</b>
     * @param bed_type          the types of <b>beds</b> the accommodation hols
     * @param max_guests        the maximum amount of quest which the accommodation holds
     * @param description       a detailed description for accommodation
     */
    public static void insertRecordIntoAccommodation(int pKeyAccommodation, String type, String bed_type, int max_guests, String description) {
        try {
            Connection conn = connect(TYPE, HOSTNAME, PORT, DB_NAME, USER, PW);
            PreparedStatement psAccommodation = conn.prepareStatement(SQL_INSERT_ACCOMMODATION);
            psAccommodation.setInt(1, pKeyAccommodation);
            psAccommodation.setString(2, type);
            psAccommodation.setString(3, bed_type);
            psAccommodation.setInt(4, max_guests);
            psAccommodation.setString(5, description);
            psAccommodation.executeUpdate();
            psAccommodation.close();
            conn.close();
        } catch (NullPointerException e) {
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    /**
     * insert a new RoomFair entry into <b>Room_Fair</b> table
     *
     * @param pKeyRoomFair primary key of the <b>Room Fair</b>
     * @param value        the <b>price</b> for the fair
     * @param season       the <b>season</b> when the price to be applied
     */
    public static void insertRecordIntoRoomFair(int pKeyRoomFair, double value, Season season) {
        try {
            Connection conn = connect(TYPE, HOSTNAME, PORT, DB_NAME, USER, PW);
            PreparedStatement psRoomFair = conn.prepareStatement(SQL_INSERT_ROOM_FAIR);
            psRoomFair.setInt(1, pKeyRoomFair);
            psRoomFair.setDouble(2, value);
            psRoomFair.setString(3, season.toString());
            psRoomFair.executeUpdate();
            psRoomFair.close();
            conn.close();
        } catch (NullPointerException e) {
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    /**
     * insert records into <B>accommodation_fair_relation</B> table
     *
     * @param pKeyRelation      primary key of the relation
     * @param fKeyAccommodation primary key of the accommodation
     * @param fKeyRoomFair      primary key of the room fair
     */
    public static void insertRecordIntoRelationTable(int pKeyRelation, int fKeyAccommodation, int fKeyRoomFair) {
        try {
            Connection conn = connect(TYPE, HOSTNAME, PORT, DB_NAME, USER, PW);
            PreparedStatement psRelation = conn.prepareStatement(SQL_INSERT_RELATION);
            psRelation.setInt(1, pKeyRelation);
            psRelation.setInt(2, fKeyAccommodation);
            psRelation.setInt(3, fKeyRoomFair);
            psRelation.executeUpdate();
            psRelation.close();
        } catch (NullPointerException e) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
