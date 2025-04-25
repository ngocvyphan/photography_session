package ca.hccis.photography.entity;

import ca.hccis.photography.exception.PhotographySessionException;
import ca.hccis.photography.util.CisUtility;

import java.io.*;

/**
 * The PhotographySession class has a method getInformation() where users can input the data for each attribute.
 * It also has the getter and setter methods for each attribute. The toString() method will be used to display
 * all the inputs the users enter. And finally, the toCSV will be used to display all the inputs in a CSV format.
 *
 * @author Vy Phan
 * @since 20240917
 */
public class PhotographySession {
    // Attributes
    private String clientName; // String Person’s name
    private int packageNumber; // int the package number 1 (Basic), 2 (Standard), 3(Premium), 4(Event), 5(Custom)
    private String date; // String Date that the session was booked
    private String sessionNotes; //String Additional information
    private int numberOfHoursBooked; // int The number of hours booked for that session
    private boolean addedPhotoAlbum; // boolean if the client wants to add photo album or not for extra $50
    private boolean addedVideo; // boolean if the client wants to add video or not for extra $500
    private boolean addedExtraEditing; // boolean if the client wants to add extra editing or not for extra $100
    private boolean addedExtraPrints; // boolean if the client wants to add extra prints for $3 each
    private int numberOfExtraPrints; // int The number of extra prints the client wants to add
    private double cost;
    private static int accumulator = loadAccumulator();


    public static final String FILE_NAME = "C:\\CIS2232\\accumulator.txt";
    public static final double COST_BASE_EXTRA_PRINT = 3;
    public static final double HOURLY_RATE = 150;
    public static final int MAX_PACKAGE_NUMBER = 5;
    public static final int MIN_PACKAGE_NUMBER = 1;
    public static final int MAX_NUMBER_OF_HOURS_BOOKED = 10;


    private CisUtility cisUtility = new CisUtility();
    public PhotographySession(boolean isGUI) {
        cisUtility.setIsGUI(isGUI);
        accumulator++;
        saveAccumulator();
    }

    /**
     * The getInformation() method will prompt the users to enter
     * all the information needed for a photography session
     *
     * @author Vy Phan
     * @since 20240917
     */
    public void getInformation(){
        clientName = cisUtility.getInputString("Name: ");
        packageNumber = cisUtility.getInputInt("Package Number: ");
        date = cisUtility.getInputString("Date: ");
        sessionNotes = cisUtility.getInputString("Session Notes: ");
        if (packageNumber == 5) {
            numberOfHoursBooked = cisUtility.getInputInt("Number of hours booked: ");
        }
        addedPhotoAlbum = cisUtility.getInputBoolean("Add PhotoAlbum: ");
        addedVideo = cisUtility.getInputBoolean("Add Video: ");
        addedExtraEditing = cisUtility.getInputBoolean("Add ExtraEditing: ");
        addedExtraPrints = cisUtility.getInputBoolean("Add ExtraPrints: ");
        if (addedExtraPrints){
            numberOfExtraPrints = cisUtility.getInputInt("Number of extra prints: ");
        }
    }

    //Getters and Setters
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getPackageNumber() {
        return packageNumber;
    }

    public void setPackageNumber(int packageNumber) throws PhotographySessionException {
        if (packageNumber < MIN_PACKAGE_NUMBER || packageNumber > MAX_PACKAGE_NUMBER){
            throw new PhotographySessionException("Invalid package number");
        }
        this.packageNumber = packageNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSessionNotes() {
        return sessionNotes;
    }

    public void setSessionNotes(String sessionNotes) {
        this.sessionNotes = sessionNotes;
    }

    public int getNumberOfHoursBooked() {
        return numberOfHoursBooked;
    }

    public void setNumberOfHoursBooked(int numberOfHoursBooked) {
        if (numberOfHoursBooked > MAX_NUMBER_OF_HOURS_BOOKED){
            throw new PhotographySessionException("Number of hours booked exceeds 10");
        }
        this.numberOfHoursBooked = numberOfHoursBooked;
    }

    public boolean isAddedPhotoAlbum() {
        return addedPhotoAlbum;
    }

    public void setAddedPhotoAlbum(boolean addedPhotoAlbum) {
        this.addedPhotoAlbum = addedPhotoAlbum;
    }

    public boolean isAddedVideo() {
        return addedVideo;
    }

    public void setAddedVideo(boolean addedVideo) {
        this.addedVideo = addedVideo;
    }

    public boolean isAddedExtraEditing() {
        return addedExtraEditing;
    }

    public void setAddedExtraEditing(boolean addedExtraEditing) {
        this.addedExtraEditing = addedExtraEditing;
    }

    public boolean isAddedExtraPrints() {
        return addedExtraPrints;
    }

    public void setAddedExtraPrints(boolean addedExtraPrints) {
        this.addedExtraPrints = addedExtraPrints;
    }

    public int getNumberOfExtraPrints() {
        return numberOfExtraPrints;
    }

    public void setNumberOfExtraPrints(int numberOfExtraPrints) {
        this.numberOfExtraPrints = numberOfExtraPrints;
    }

    public double getCost() {
        return cost;
    }



    public void setCost(double cost) {
        this.cost = cost;
    }

    public static void saveAccumulator() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME,false))) {
            writer.write(String.valueOf(accumulator));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int loadAccumulator() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            return Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            return 0;  // Return 0 if file not found or if there's an error
        }
    }


    /**
     * The calculateCost() method will calculate the cost for the package number the customer
     * chooses and add extra money for the add-ons
     *
     * @author Vy Phan
     * @since 20240926
     */
    public double calculateCost(){
        double cost = 0;
        switch(packageNumber){
            //package number 1: Basic
            case 1:
                cost = 150;
                break;
            //package number 2: standard
            case 2:
                cost = 300;
                break;
            //package number 3: premium
            case 3:
                cost = 600;
                break;
            //package number 4: event
            case 4:
                cost = 1200;
                break;
            //package number 5: custom
            case 5:
                cost = HOURLY_RATE* numberOfHoursBooked;
                break;
        }

        if (addedPhotoAlbum){
            cost += 50;
        }

        if (addedVideo){
            cost += 500;
        }

        if(addedExtraEditing){
            cost += 100;
        }

        if (addedExtraPrints){
            cost += numberOfExtraPrints*COST_BASE_EXTRA_PRINT;
        }

        return cost;
    }
    /**
     * The toString() method will generate a string with all the inputs that
     * the user has entered for a photography session.
     *
     * @author Vy Phan
     * @since 20240917
     */
    public String toString() {
        return "Photography Session" + System.lineSeparator() +
                "clientName: " + clientName + System.lineSeparator() +
                "packageNumber: " + packageNumber + System.lineSeparator() +
                "Date: " + date + System.lineSeparator() +
                "Session Notes: " + sessionNotes + System.lineSeparator() +
                "Number of hours booked: " + numberOfHoursBooked + System.lineSeparator() +
                "Added PhotoAlbum: " + addedPhotoAlbum + System.lineSeparator() +
                "Added Video: " + addedVideo + System.lineSeparator() +
                "Added ExtraEditing: " + addedExtraEditing + System.lineSeparator() +
                "Added ExtraPrints: " + addedExtraPrints + System.lineSeparator() +
                "Number of extra prints: " + numberOfExtraPrints + System.lineSeparator() +
                "Cost: " + calculateCost() + System.lineSeparator()+
                "The total number of entries that has been added combined in both threads: " + loadAccumulator() + System.lineSeparator();

    }

    /**
     * The toCSV() method will generate a string with all the inputs that
     * the user has entered for a photography session and will be used to
     * generate inputs in a CSV file.
     *
     * @author Vy Phan
     * @since 20240917
     */
    public String toCSV() {
        return  clientName + "," + packageNumber + "," + date + "," + sessionNotes + "," + "," + numberOfHoursBooked + "," + cost;
    }
}
