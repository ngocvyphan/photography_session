package info.hccis.photography.session.controllers;

import info.hccis.photography.session.bo.PhotographySessionBO;
import info.hccis.photography.session.repositories.CodeValueRepository;
import info.hccis.photography.session.util.CisUtility;

import javax.servlet.http.HttpSession;

import info.hccis.photography.session.util.CisUtilityNetwork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Base controller which control general functionality in the app.
 *
 * @since 20241105
 * @author Vy Phan
 */
@Controller
public class BaseController {

    private final CodeValueRepository _cvr;

    @Autowired
    public BaseController(CodeValueRepository cvr) {
        _cvr = cvr;
    }

    /**
     * Send the user to the welcome view
     *
     * @since 20241105
     * @author Vy Phan
     */
    @RequestMapping("/")
    public String home(HttpSession session) {


        //BJM 20200602 Issue#1 Set the current date in the session
        String currentDate = CisUtility.getCurrentDate("yyyy-MM-dd");
        session.setAttribute("currentDate", currentDate);

        PhotographySessionBO.setPackageTypes(_cvr, session);
        return "index";
    }

    /**
     * Send the user to the about view.
     *
     * @since 20241105
     * @author Vy Phan
     */
    @RequestMapping("/about")
    public String about() {
        return "other/about";
    }
}
