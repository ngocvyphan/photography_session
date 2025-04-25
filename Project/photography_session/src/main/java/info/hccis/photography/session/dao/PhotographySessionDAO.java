package info.hccis.photography.session.dao;

import info.hccis.photography.session.jpa.entity.PhotographySession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * DAO class to access photography session.
 *
 * @author bjmaclean
 * @since 20220621
 */
public class PhotographySessionDAO {

    private static ResultSet rs;
    private static Connection conn = null;
    private static final Logger logger = LoggerFactory.getLogger(PhotographySessionDAO.class);

    public PhotographySessionDAO() {

        String propFileName = "application";
        ResourceBundle rb = ResourceBundle.getBundle(propFileName);
        String connectionString = rb.getString("spring.datasource.url");
        String userName = rb.getString("spring.datasource.username");
        String password = rb.getString("spring.datasource.password");

        try {
            conn = DriverManager.getConnection(connectionString, userName, password);
        } catch (SQLException e) {
            logger.error(e.toString());
        }

    }


    /**
     * Select all photography sessions
     *
     * @since 20241015
     * @author Vy Phan
     */
    public ArrayList<PhotographySession> selectAll() {
        ArrayList<PhotographySession> sessions = null;
        Statement stmt = null;
        //******************************************************************
        //Use the DriverManager to get a connection to our MySql database.  Note
        //that in the dependencies, we added the Java connector to MySql which 
        //will allow us to connect to a MySql database.
        //******************************************************************
        //******************************************************************
        //Create a statement object using our connection to the database.  This 
        //statement object will allow us to run sql commands against the database.
        //******************************************************************
        try {

            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from PhotographySession;");

            //******************************************************************
            //Loop through the result set using the next method.  
            //******************************************************************
            sessions = new ArrayList();

            while (rs.next()) {

                PhotographySession photographySession = new PhotographySession();
                photographySession.setId(rs.getInt(1));
                photographySession.setClientName(rs.getString("clientName"));
                photographySession.setPackageNumber(rs.getInt("packageNumber"));
                photographySession.setDate(rs.getString("date"));
                photographySession.setSessionNotes(rs.getString("sessionNotes"));
                photographySession.setNumberOfHoursBooked(rs.getInt("numberOfHoursBooked"));
                photographySession.setHourlyRate(rs.getBigDecimal("hourlyRate"));
                photographySession.setAddedPhotoAlbum(rs.getBoolean("addedPhotoAlbum"));
                photographySession.setAddedVideo(rs.getBoolean("addedVideo"));
                photographySession.setAddedExtraEditing(rs.getBoolean("addedExtraEditing"));
                photographySession.setNumberOfExtraPrints(rs.getInt("numberOfExtraPrints"));
                photographySession.setCost(rs.getBigDecimal("cost"));
                sessions.add(photographySession);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            try {
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("There was an error closing");
            }
        }
        return sessions;
    }

    /**
     * Select all by date of booking
     *
     * @since 20241015
     * @author Vy Phan
     */
    public ArrayList<PhotographySession> selectAllByDateOfBooking(String dateOfBooking) {
        ArrayList<PhotographySession> sessions = null;
        Statement stmt = null;
        //******************************************************************
        //Use the DriverManager to get a connection to our MySql database.  Note
        //that in the dependencies, we added the Java connector to MySql which
        //will allow us to connect to a MySql database.
        //******************************************************************
        //******************************************************************
        //Create a statement object using our connection to the database.  This
        //statement object will allow us to run sql commands against the database.
        //******************************************************************
        try {

            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from PhotographySession ps " +
                            "where ps.date = '"+dateOfBooking+"' ;");

            //******************************************************************
            //Loop through the result set using the next method.
            //******************************************************************
            sessions = new ArrayList();

            while (rs.next()) {

                PhotographySession photographySession = new PhotographySession();
                photographySession.setId(rs.getInt(1));
                photographySession.setClientName(rs.getString("clientName"));
                photographySession.setPackageNumber(rs.getInt("packageNumber"));
                photographySession.setDate(rs.getString("date"));
                photographySession.setSessionNotes(rs.getString("sessionNotes"));
                photographySession.setNumberOfHoursBooked(rs.getInt("numberOfHoursBooked"));
                photographySession.setHourlyRate(rs.getBigDecimal("hourlyRate"));
                photographySession.setAddedPhotoAlbum(rs.getBoolean("addedPhotoAlbum"));
                photographySession.setAddedVideo(rs.getBoolean("addedVideo"));
                photographySession.setAddedExtraEditing(rs.getBoolean("addedExtraEditing"));
                photographySession.setAddedExtraPrints(rs.getBoolean("addedExtraPrints"));
                photographySession.setNumberOfExtraPrints(rs.getInt("numberOfExtraPrints"));
                photographySession.setCost(rs.getBigDecimal("cost"));
                sessions.add(photographySession);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            try {
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("There was an error closing");
            }
        }
        return sessions;
    }

    /**
     * Select all by cost range
     *
     * @since 20241015
     * @author Vy Phan
     */
    public ArrayList<PhotographySession> selectAllByCostRange(double costLowerLimit, double costUpperLimit) {
        ArrayList<PhotographySession> sessions = null;
        Statement stmt = null;
        //******************************************************************
        //Use the DriverManager to get a connection to our MySql database.  Note
        //that in the dependencies, we added the Java connector to MySql which
        //will allow us to connect to a MySql database.
        //******************************************************************
        //******************************************************************
        //Create a statement object using our connection to the database.  This
        //statement object will allow us to run sql commands against the database.
        //******************************************************************
        try {

            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from PhotographySession ps "
                    +"where ps.cost >= "+costLowerLimit+" " +
                    "AND ps.cost <= "+costUpperLimit+" ;");

            //******************************************************************
            //Loop through the result set using the next method.
            //******************************************************************
            sessions = new ArrayList();

            while (rs.next()) {

                PhotographySession photographySession = new PhotographySession();
                photographySession.setId(rs.getInt(1));
                photographySession.setClientName(rs.getString("clientName"));
                photographySession.setPackageNumber(rs.getInt("packageNumber"));
                photographySession.setDate(rs.getString("date"));
                photographySession.setSessionNotes(rs.getString("sessionNotes"));
                photographySession.setNumberOfHoursBooked(rs.getInt("numberOfHoursBooked"));
                photographySession.setHourlyRate(rs.getBigDecimal("hourlyRate"));
                photographySession.setAddedPhotoAlbum(rs.getBoolean("addedPhotoAlbum"));
                photographySession.setAddedVideo(rs.getBoolean("addedVideo"));
                photographySession.setAddedExtraEditing(rs.getBoolean("addedExtraEditing"));
                photographySession.setAddedExtraPrints(rs.getBoolean("addedExtraPrints"));
                photographySession.setNumberOfExtraPrints(rs.getInt("numberOfExtraPrints"));
                photographySession.setCost(rs.getBigDecimal("cost"));
                sessions.add(photographySession);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {

            try {
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("There was an error closing");
            }
        }
        return sessions;
    }


}
