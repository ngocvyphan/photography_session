package info.hccis.photography.session.controllers;

import info.hccis.photography.session.bo.PhotographySessionBO;
import info.hccis.photography.session.entity.ReportPhotographySession;
import info.hccis.photography.session.jpa.entity.PhotographySession;
import info.hccis.photography.session.util.CisUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Controller to administer reports of the project.
 *
 * @author Vy Phan
 * @since 20241018
 */
@Controller
@RequestMapping("/report")
public class ReportController {

    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);

    /**
     * Send the user to list of reports view.
     *
     * @param model
     * @param session
     * @return To the appropriate view
     * @author BJM
     * @since 20220624
     */
    @RequestMapping("")
    public String home(Model model, HttpSession session) {

        //BJM 20200602 Issue#1 Set the current date in the session
        logger.info("Running the reports controller base method");
        return "report/list";
    }

    /**
     * Method to send user to the date of booking.
     *
     * @param model
     * @return view for list
     * @author Vy Phan
     * @since 2024-10-14
     */
    @RequestMapping("/photographysession/dateofbooking")
    public String reportDateOfBooking(Model model, HttpSession session) {
        String currentDate = CisUtility.getCurrentDate("yyyy-MM-dd");
        session.setAttribute("currentDate", currentDate);
        //**********************************************************************
        // Put the photography session order object in the model and send the user
        // to the report input view.
        //**********************************************************************
        ReportPhotographySession reportPhotographySession = new ReportPhotographySession();
        String offSetDate = CisUtility.getCurrentDate(-30, "yyyy-MM-dd");
        reportPhotographySession.setDate(offSetDate);
        model.addAttribute("reportInput", reportPhotographySession);
        return "report/reportPhotographySessionDateOfBooking";
    }

    /**
     * Method to send user to the cost range report
     *
     * @param model
     * @return view for list
     * @author Vy Phan
     * @since 2024-10-18
     */
    @RequestMapping("/photographysession/costrange")
    public String reportCostRange(Model model) {

        //**********************************************************************
        // Put the ticket order object in the model and send the user
        // to the report input view.
        //**********************************************************************
        model.addAttribute("reportInput", new ReportPhotographySession());
        return "report/reportPhotographySessionCostRange";
    }

    /**
     * Process the report of date of booking
     *
     * @param model
     * @param reportPhotographySession
     * @return view to show report
     * @author Vy Phan
     * @since 2024-10-18
     */
    @RequestMapping("/photographysession/dateofbooking/submit")
    public String reportOrderDateOfOrderSubmit(Model model, @ModelAttribute("reportInput") ReportPhotographySession reportPhotographySession) {
        //Call BO method to process the report
        ArrayList<PhotographySession> photographySessions = PhotographySessionBO.processDateOfBookingReport(reportPhotographySession.getDate());

        //Put the list in the Java object
        reportPhotographySession.setPhotographySessions(photographySessions);

        if (photographySessions != null && photographySessions.isEmpty()) {
            model.addAttribute("message", "No data found");
            System.out.println("Vy Phan - no data found");
        }

        //Put object in model so it can be used on the view (html)
        model.addAttribute("reportInput", reportPhotographySession);

        return "report/reportPhotographySessionDateOfBooking";
    }

    /**
     * Process the report of cost range
     *
     * @param model
     * @param reportPhotographySession
     * @return view to show report
     * @author BJM
     * @since 2024-10-18
     */
    @RequestMapping("/photographysession/costrange/submit")
    public String reportOrderCustomerNameSubmit(Model model, @ModelAttribute("reportInput") ReportPhotographySession reportPhotographySession) {

        //**********************************************************************
        // This could be done using the repository but there will be times when
        // jdbc will be useful.  For the reports, the requirements state that you
        // are to use jdbc to obtain the data for the report.
        //**********************************************************************

        ArrayList<PhotographySession> photographySessions = PhotographySessionBO.processCostRangeReport(reportPhotographySession.getCostLowerLimit(), reportPhotographySession.getCostUpperLimit());
        reportPhotographySession.setPhotographySessions(photographySessions);

        if (photographySessions != null && photographySessions.isEmpty()) {
            model.addAttribute("message", "No data found");
            System.out.println("Vy Phan - no data found");
        }

        model.addAttribute("reportInput", reportPhotographySession);

        return "report/reportPhotographySessionCostRange";
    }

}
