package ca.hccis.photography.entity;

import java.util.Scanner;

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
    private String sessionType; // String Type of session (eg. wedding, event, portrait, fashion, pet)
    private String date; // String Date that the session was booked
    private String sessionNotes; //String Additional information
    private double hourlyRate; // double The hourly rate depends on each session
    private int numberOfHoursBooked; // int The number of hours booked for that session
    private double cost;

    /**
     * The getInformation() method will prompt the users to enter
     * all the information needed for a photography session
     *
     * @author Vy Phan
     * @since 20240917
     */
    public void getInformation(){
        Scanner input = new Scanner(System.in);
        System.out.println("Name: ");
        clientName = input.nextLine();
        System.out.println("Session Type: ");
        sessionType = input.nextLine();
        System.out.println("Date: ");
        date = input.nextLine();
        System.out.println("Session Notes: ");
        sessionNotes = input.nextLine();
        System.out.println("The hourly rate for that session: ");
        hourlyRate = input.nextDouble();
        input.nextLine();
        System.out.println("Number of hours booked: ");
        numberOfHoursBooked = input.nextInt();
        input.nextLine();
    }

    //Getters and Setters
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getSessionType() {
        return sessionType;
    }

    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
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

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getNumberOfHoursBooked() {
        return numberOfHoursBooked;
    }

    public void setNumberOfHoursBooked(int numberOfHoursBooked) {
        this.numberOfHoursBooked = numberOfHoursBooked;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
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
                "sessionType: " + sessionType + System.lineSeparator() +
                "Date: " + date + System.lineSeparator() +
                "Session Notes: " + sessionNotes + System.lineSeparator() +
                "hourlyRate: " + hourlyRate + System.lineSeparator() +
                "Number of hours booked: " + numberOfHoursBooked + System.lineSeparator() +
                "Cost: " + cost + System.lineSeparator();
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
        return  clientName + "," + sessionType + "," + date + "," + sessionNotes + "," + hourlyRate + "," + numberOfHoursBooked + "," + cost;
    }
}
