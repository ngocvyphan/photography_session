package ca.hccis.photography.dao;



import ca.hccis.photography.db.ConnectionUtils;
import ca.hccis.photography.entity.PhotographySession;

import java.sql.*;
import java.util.ArrayList;

/**
 * Student database class for student
 *
 * @author bjmaclean
 * @since 20210924
 */
public class PhotographySessionDAO {

    private static ResultSet rs;
    private static Statement stmt = null;
    private static Connection conn = null;

    public PhotographySessionDAO() {
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            System.out.println("Error getting connection");
        }

    }

    /**
     * Select all students
     *
     * @since 20210924
     * @author BJM
     */
    public ArrayList<PhotographySession> selectAll() {
        ArrayList<PhotographySession> sessions = null;

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
                photographySession.setHourlyRate(rs.getDouble("hourlyRate"));
                photographySession.setAddedPhotoAlbum(rs.getBoolean("addedPhotoAlbum"));
                photographySession.setAddedVideo(rs.getBoolean("addedVideo"));
                photographySession.setAddedExtraEditing(rs.getBoolean("addedExtraEditing"));
                photographySession.setNumberOfExtraPrints(rs.getInt("numberOfExtraPrints"));
                photographySession.setCost(rs.getDouble("cost"));
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

//    /**
//     * Select a student by name
//     *
//     * @since 20210924
//     * @author BJM
//     */
//    public Student selectByName(String name) {
//        Student student = null;
//        Statement stmt = null;
//        try {
//            stmt = conn.createStatement();
//            String query = "select * from Student where name='" + name + "';";
//            System.out.println(query);
//            rs = stmt.executeQuery(query);
//        } catch (SQLException ex) {
//            System.out.println("Error");
//            ex.printStackTrace();
//        }
//
//        try {
//            while (rs.next()) {
//                student = new Student(rs.getString("name"),
//                        rs.getInt("studentId"),
//                        rs.getString("program"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return student;
//    }
//
    /**
     * Insert a student
     *
     * @since 20230921
     * @author BJM
     */
    public void insert(PhotographySession photographySession) {
        PreparedStatement ps = null;
        try {
            //**************************************
            //Now can use the getters to get the info from the student object to be
            //passed into the executeUpdate method of the stmt object.
            //**************************************
            String sql = "INSERT INTO PhotographySession(clientName, packageNumber, date,"+
                    "sessionNotes, numberOfHoursBooked, hourlyRate, addedPhotoAlbum, addedVideo, " +
                    "addedExtraEditing, addedExtraPrints, numberOfExtraPrints, cost) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
            ps = conn.prepareStatement(sql);
            ps.setString(1, photographySession.getClientName());
            ps.setInt(2, photographySession.getPackageNumber());
            ps.setString(3, photographySession.getDate());
            ps.setString(4, photographySession.getSessionNotes());
            ps.setInt(5, photographySession.getNumberOfHoursBooked());
            ps.setDouble(6, photographySession.getHourlyRate());
            ps.setBoolean(7, photographySession.isAddedPhotoAlbum());
            ps.setBoolean(8, photographySession.isAddedVideo());
            ps.setBoolean(9, photographySession.isAddedExtraEditing());
            ps.setBoolean(10, photographySession.isAddedExtraPrints());
            ps.setInt(11, photographySession.getNumberOfExtraPrints());
            ps.setDouble(12, photographySession.calculateCost());

            ps.executeUpdate();
            System.out.println(sql);

        } catch (SQLException ex) {
            System.out.println("Error creating statement");
            ex.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                System.out.println("Couldn't close something.  ");
            }
        }

    }

//    /**
//     * Update a student program based on their id
//     *
//     * @since 20210924
//     * @author BJM
//     */
//    public void updateProgramById(int newId, String newProgram) {
//        try {
//            PreparedStatement ps = conn.prepareStatement("UPDATE `student` SET program=? WHERE studentId=?");
//            ps.setString(1, newProgram);
//            ps.setInt(2, newId);
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println("Error updating");
//        }
//
//    }
//
//    /**
//     * Select student name by their id
//     *
//     * @since 20210924
//     * @author BJM
//     */
//    public String selectNameById(int idToLookUp) {
//        //**************************************
//        //Use a procedure
//        //Try a callable statement
//        //**************************************
//        String nameBack = null;
//        System.out.println("");
//        System.out.println("Try to use a callable statement to lookup a student");
//        CallableStatement cstmt = null;
//        try {
//            String SQL = "{call getName (?, ?)}";
//            cstmt = conn.prepareCall(SQL);
//            cstmt.setInt(1, idToLookUp);
//            cstmt.execute();
//            nameBack = cstmt.getString(2);
//
//        } catch (SQLException e) {
//
//            System.out.println("error");
//            e.printStackTrace();
//        } finally {
//            System.out.println("end");
//        }
//        return nameBack;
//
//    }

}
