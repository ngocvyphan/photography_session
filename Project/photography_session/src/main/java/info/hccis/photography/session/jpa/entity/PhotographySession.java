package info.hccis.photography.session.jpa.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "photographysession")
public class PhotographySession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 20)
    @NotNull
    @Column(name = "clientName", nullable = false, length = 20)
    private String clientName;

    @NotNull
    @Column(name = "packageNumber", nullable = false)
    private Integer packageNumber;

    @Size(max = 10)
    @NotNull
    @Column(name = "date", nullable = false, length = 10)
    private String date;

    @Size(max = 20)
    @NotNull
    @Column(name = "sessionNotes", nullable = false, length = 20)
    private String sessionNotes;

    @NotNull
    @Column(name = "numberOfHoursBooked", nullable = false)
    private Integer numberOfHoursBooked;

    @NotNull
    @Column(name = "hourlyRate", nullable = false, precision = 6, scale = 2)
    private BigDecimal hourlyRate;

    @NotNull
    @Column(name = "addedPhotoAlbum", nullable = false)
    private Boolean addedPhotoAlbum = false;

    @NotNull
    @Column(name = "addedVideo", nullable = false)
    private Boolean addedVideo = false;

    @NotNull
    @Column(name = "addedExtraEditing", nullable = false)
    private Boolean addedExtraEditing = false;

    @NotNull
    @Column(name = "addedExtraPrints", nullable = false)
    private Boolean addedExtraPrints = false;

    @NotNull
    @Column(name = "numberOfExtraPrints", nullable = false)
    private Integer numberOfExtraPrints;

    @NotNull
    @Column(name = "cost", nullable = false, precision = 6, scale = 2)
    private BigDecimal cost;

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

}