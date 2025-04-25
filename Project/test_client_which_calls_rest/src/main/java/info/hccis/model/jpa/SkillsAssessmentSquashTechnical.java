package info.hccis.model.jpa;

import info.hccis.student.util.CisUtility;
import java.io.Serializable;

/**
 *
 * @author bjmaclean
 */
public class SkillsAssessmentSquashTechnical implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String assessmentDate;
    private String createdDateTime;
    private String athleteName;
    private String assessorName;
    private Integer forehandDrives;
    private Integer backhandDrives;
    private Integer forehandVolleyMax;
    private Integer forehandVolleySum;
    private Integer backhandVolleyMax;
    private Integer backhandVolleySum;
    private Integer technicalScore;

    public SkillsAssessmentSquashTechnical() {
    }

    public SkillsAssessmentSquashTechnical(Integer id) {
        this.id = id;
    }

    public SkillsAssessmentSquashTechnical(Integer id, String assessmentDate, String createdDateTime, String athleteName, String assessorName) {
        this.id = id;
        this.assessmentDate = assessmentDate;
        this.createdDateTime = createdDateTime;
        this.athleteName = athleteName;
        this.assessorName = assessorName;
    }

    public void getInformation(){
        athleteName = CisUtility.getInputString("Athlete name");
        assessorName = CisUtility.getInputString("Assessor name");
        assessmentDate = CisUtility.getInputString("Assessment date: yyyy-MM-dd");
        createdDateTime = CisUtility.getCurrentDate("yyyy-MM-dd");
        forehandDrives = CisUtility.getInputInt("FH Drives");
        backhandDrives = CisUtility.getInputInt("BH Drives");
        forehandVolleyMax = CisUtility.getInputInt("FH Volley Max");
        backhandVolleyMax = CisUtility.getInputInt("BH Volley Max");
        forehandVolleySum = CisUtility.getInputInt("FH Volley Sum");
        backhandVolleySum = CisUtility.getInputInt("BH Volley Sum");
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(String assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    public String getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(String createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public String getAssessorName() {
        return assessorName;
    }

    public void setAssessorName(String assessorName) {
        this.assessorName = assessorName;
    }

    public Integer getForehandDrives() {
        return forehandDrives;
    }

    public void setForehandDrives(Integer forehandDrives) {
        this.forehandDrives = forehandDrives;
    }

    public Integer getBackhandDrives() {
        return backhandDrives;
    }

    public void setBackhandDrives(Integer backhandDrives) {
        this.backhandDrives = backhandDrives;
    }

    public Integer getForehandVolleyMax() {
        return forehandVolleyMax;
    }

    public void setForehandVolleyMax(Integer forehandVolleyMax) {
        this.forehandVolleyMax = forehandVolleyMax;
    }

    public Integer getForehandVolleySum() {
        return forehandVolleySum;
    }

    public void setForehandVolleySum(Integer forehandVolleySum) {
        this.forehandVolleySum = forehandVolleySum;
    }

    public Integer getBackhandVolleyMax() {
        return backhandVolleyMax;
    }

    public void setBackhandVolleyMax(Integer backhandVolleyMax) {
        this.backhandVolleyMax = backhandVolleyMax;
    }

    public Integer getBackhandVolleySum() {
        return backhandVolleySum;
    }

    public void setBackhandVolleySum(Integer backhandVolleySum) {
        this.backhandVolleySum = backhandVolleySum;
    }

    public Integer getTechnicalScore() {
        return technicalScore;
    }

    public void setTechnicalScore(Integer technicalScore) {
        this.technicalScore = technicalScore;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SkillsAssessmentSquashTechnical)) {
            return false;
        }
        SkillsAssessmentSquashTechnical other = (SkillsAssessmentSquashTechnical) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    //Keep in mind this will disappear if I regenerate the class
    @Override
    public String toString() {
        String output = "Assessment Details: Athlete: " + getAthleteName() + " Date: " + getAssessmentDate() + " Score: " + getTechnicalScore();
        return output;
    }
    
}
