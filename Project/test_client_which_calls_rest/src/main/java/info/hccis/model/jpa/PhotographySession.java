package info.hccis.model.jpa;


import info.hccis.student.util.CisUtility;

import java.math.BigDecimal;


public class PhotographySession {


    private Integer id;


    private String clientName;


    private Integer packageNumber;


    private String date;


    private String sessionNotes;


    private Integer numberOfHoursBooked;


    private BigDecimal hourlyRate;


    private Boolean addedPhotoAlbum = false;


    private Boolean addedVideo = false;


    private Boolean addedExtraEditing = false;


    private Boolean addedExtraPrints = false;


    private Integer numberOfExtraPrints;


    private BigDecimal cost;

    public void getInformation(){
        id = 0;
        clientName = CisUtility.getInputString("Client Name: ");
        packageNumber=CisUtility.getInputInt("Package Number: ");
        date = CisUtility.getInputString("Date: (YYYY-MM-DD) ");
        sessionNotes = CisUtility.getInputString("Session Notes: ");
        numberOfHoursBooked = CisUtility.getInputInt("Number of Hours Booked: ");
        hourlyRate = BigDecimal.valueOf(CisUtility.getInputDouble("Hourly Rate: "));
        addedPhotoAlbum = CisUtility.getInputBoolean("Added Photo Album: ");
        addedVideo = CisUtility.getInputBoolean("Added Video: ");
        addedExtraEditing = CisUtility.getInputBoolean("Added Extra Editing: ");
        addedExtraPrints = CisUtility.getInputBoolean("Added Extra Prints: ");
        numberOfExtraPrints = CisUtility.getInputInt("Number of Extra Prints: ");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Integer getPackageNumber() {
        return packageNumber;
    }

    public void setPackageNumber(Integer packageNumber) {
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

    public Integer getNumberOfHoursBooked() {
        return numberOfHoursBooked;
    }

    public void setNumberOfHoursBooked(Integer numberOfHoursBooked) {
        this.numberOfHoursBooked = numberOfHoursBooked;
    }

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public Boolean getAddedPhotoAlbum() {
        return addedPhotoAlbum;
    }

    public void setAddedPhotoAlbum(Boolean addedPhotoAlbum) {
        this.addedPhotoAlbum = addedPhotoAlbum;
    }

    public Boolean getAddedVideo() {
        return addedVideo;
    }

    public void setAddedVideo(Boolean addedVideo) {
        this.addedVideo = addedVideo;
    }

    public Boolean getAddedExtraEditing() {
        return addedExtraEditing;
    }

    public void setAddedExtraEditing(Boolean addedExtraEditing) {
        this.addedExtraEditing = addedExtraEditing;
    }

    public Boolean getAddedExtraPrints() {
        return addedExtraPrints;
    }

    public void setAddedExtraPrints(Boolean addedExtraPrints) {
        this.addedExtraPrints = addedExtraPrints;
    }

    public Integer getNumberOfExtraPrints() {
        return numberOfExtraPrints;
    }

    public void setNumberOfExtraPrints(Integer numberOfExtraPrints) {
        this.numberOfExtraPrints = numberOfExtraPrints;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "PhotographySession" +
                "\nid=" + id +
                "\nclientName='" + clientName + '\'' +
                "\npackageNumber=" + packageNumber +
                "\ndate='" + date + '\'' +
                "\nsessionNotes='" + sessionNotes + '\'' +
                "\nnumberOfHoursBooked=" + numberOfHoursBooked +
                "\nhourlyRate=" + hourlyRate +
                "\naddedPhotoAlbum=" + addedPhotoAlbum +
                "\naddedVideo=" + addedVideo +
                "\naddedExtraEditing=" + addedExtraEditing +
                "\naddedExtraPrints=" + addedExtraPrints +
                "\nnumberOfExtraPrints=" + numberOfExtraPrints +
                "\ncost=" + cost +
                "\n";
    }
}