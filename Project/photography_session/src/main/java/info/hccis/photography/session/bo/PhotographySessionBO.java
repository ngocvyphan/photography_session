package info.hccis.photography.session.bo;

import info.hccis.photography.session.dao.PhotographySessionDAO;
//import info.hccis.photography.session.entity.PhotographySession;
import info.hccis.photography.session.jpa.entity.CodeValue;
import info.hccis.photography.session.repositories.CodeValueRepository;
import info.hccis.photography.session.util.CisUtility;
import info.hccis.photography.session.util.CisUtilityFile;
import info.hccis.photography.session.jpa.entity.PhotographySession;


import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PhotographySessionBO {
    public static ArrayList<PhotographySession> processDateOfBookingReport(String date){
//**********************************************************************
        // This could be done using the repository but there will be times when
        // jdbc will be useful.  For the reports, the requirements state that you
        // are to use jdbc to obtain the data for the report.
        //**********************************************************************
        PhotographySessionDAO photographySessionDAO = new PhotographySessionDAO();

        ArrayList<PhotographySession> photographySessions = photographySessionDAO.selectAllByDateOfBooking(date);

        //Also write the report to a file
        CisUtilityFile.writeReportToFile("dateOfBookingReport", photographySessions);
        return photographySessions;

    }

    public static ArrayList<PhotographySession> processCostRangeReport(double lowerCostLimit, double upperCostLimit){
//**********************************************************************
        // This could be done using the repository but there will be times when
        // jdbc will be useful.  For the reports, the requirements state that you
        // are to use jdbc to obtain the data for the report.
        //**********************************************************************
        PhotographySessionDAO photographySessionDAO = new PhotographySessionDAO();

        ArrayList<PhotographySession> photographySessions = photographySessionDAO.selectAllByCostRange(lowerCostLimit, upperCostLimit);

        //Also write the report to a file
        CisUtilityFile.writeReportToFile("costRangeReport", photographySessions);
        return photographySessions;

    }

    /**
     * Calculate the cost of the photography session and set it's value in the photography session object.
     * @param photographySession
     * @return the cost
     * @since 20241030
     * @author Vy Phan
     */
    public static double calculatePhotographySessionCost( PhotographySession photographySession){
        BigDecimal cost;
        double tempCost = 0;
        switch(photographySession.getPackageNumber()){
            //package number 1: Basic
            case 1:
                tempCost = 150;
                break;
            //package number 2: standard
            case 2:
                tempCost = 300;
                break;
            //package number 3: premium
            case 3:
                tempCost = 600;
                break;
            //package number 4: event
            case 4:
                tempCost = 1200;
                break;
            //package number 5: custom
            case 5:
                tempCost = (photographySession.getHourlyRate().multiply(new BigDecimal(photographySession.getNumberOfHoursBooked()))).doubleValue();
                break;
        }

        if (photographySession.getAddedPhotoAlbum()){
            tempCost += 50;
        }

        if (photographySession.getAddedVideo()){
            tempCost += 500;
        }

        if(photographySession.getAddedExtraEditing()){
            tempCost += 100;
        }

        if (photographySession.getAddedExtraPrints()){
            tempCost += photographySession.getNumberOfExtraPrints() * 3;
        }
        cost = new BigDecimal(tempCost);

        photographySession.setCost(cost);

        return tempCost;
    }

    /**
     * Set default values
     * @param photographySession
     * @since 20241030
     * @author Vy Phan
     */
    public static void setPhotographySessionDefaults(PhotographySession photographySession){
        photographySession.setPackageNumber(1);
        photographySession.setHourlyRate(new BigDecimal(150));
        photographySession.setNumberOfHoursBooked(1);
        photographySession.setCost(new BigDecimal(150));
        photographySession.setNumberOfExtraPrints(0);
        photographySession.setDate(CisUtility.getCurrentDate("yyyy-MM-dd"));

    }

    public static void setPackageTypes(CodeValueRepository _cvr, HttpSession session){
        List<CodeValue> packageTypes = (List) session.getAttribute("packageTypes");
        if(packageTypes == null) {
            packageTypes = _cvr.findByCodeTypeId(2);
            session.setAttribute("packageTypes", packageTypes);
        }
    }
}
