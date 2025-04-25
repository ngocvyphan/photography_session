package info.hccis.photography.session.entity;

import info.hccis.photography.session.jpa.entity.PhotographySession;

import java.util.ArrayList;

/**
 * Entity class to hold the attributes of the photography session order related reports.
 *
 * @author Vy Phan
 * @since 20241018
 */
public class ReportPhotographySession {
    private String date;
    private double costLowerLimit;
    private double costUpperLimit;

    private ArrayList<PhotographySession> photographySessions;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public double getCostLowerLimit() {
        return costLowerLimit;
    }

    public void setCostLowerLimit(double costLowerLimit) {
        this.costLowerLimit = costLowerLimit;
    }

    public double getCostUpperLimit() {
        return costUpperLimit;
    }

    public void setCostUpperLimit(double costUpperLimit) {
        this.costUpperLimit = costUpperLimit;
    }

    public ArrayList<PhotographySession> getPhotographySessions() {
        return photographySessions;
    }

    public void setPhotographySessions(ArrayList<PhotographySession> photographySessions) {
        this.photographySessions = photographySessions;
    }
}
