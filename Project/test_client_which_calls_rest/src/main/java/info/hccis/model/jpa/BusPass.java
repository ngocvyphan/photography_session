package info.hccis.model.jpa;

import info.hccis.student.util.CisUtility;
import java.math.BigDecimal;

public class BusPass {
    private Integer id;
    private String name;
    private String address;
    private String city;
    private String preferredRoute;
    private Integer passType;
    private Boolean validForRuralRoute = false;
    private Integer lengthOfPass;
    private String startDate;
    private BigDecimal cost;

    public void getInformation(){
        id = 0;
        name = CisUtility.getInputString("Name");
        address = CisUtility.getInputString("Address");
        city = CisUtility.getInputString("City");
        preferredRoute = CisUtility.getInputString("Preferred Route");
        passType = CisUtility.getInputInt("Pass Type");
        validForRuralRoute = CisUtility.getInputBoolean("Valid For Rural Route");
        lengthOfPass = CisUtility.getInputInt("Length of Pass");
        startDate = CisUtility.getCurrentDate("yyyy-MM-dd");

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPreferredRoute() {
        return preferredRoute;
    }

    public void setPreferredRoute(String preferredRoute) {
        this.preferredRoute = preferredRoute;
    }

    public Integer getPassType() {
        return passType;
    }

    public void setPassType(Integer passType) {
        this.passType = passType;
    }

    public Boolean getValidForRuralRoute() {
        return validForRuralRoute;
    }

    public void setValidForRuralRoute(Boolean validForRuralRoute) {
        this.validForRuralRoute = validForRuralRoute;
    }

    public Integer getLengthOfPass() {
        return lengthOfPass;
    }

    public void setLengthOfPass(Integer lengthOfPass) {
        this.lengthOfPass = lengthOfPass;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "BusPass: " +
                "\nid=" + id +
                "\nname='" + name + '\'' +
                "\naddress='" + address + '\'' +
                "\ncity='" + city + '\'' +
                "\npreferredRoute='" + preferredRoute + '\'' +
                "\npassType=" + passType +
                "\nvalidForRuralRoute=" + validForRuralRoute +
                "\nlengthOfPass=" + lengthOfPass +
                "\nstartDate='" + startDate + '\'' +
                "\ncost=$" + cost
                +"\n";
    }
}