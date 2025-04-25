package info.hccis.photography.session.controllers;

import info.hccis.photography.session.bo.PhotographySessionBO;
import info.hccis.photography.session.bo.PhotographySessionValidationBO;
import info.hccis.photography.session.jpa.entity.PhotographySession;
import info.hccis.photography.session.repositories.CodeValueRepository;
import info.hccis.photography.session.repositories.PhotographySessionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Controller to administer photography session orders. Note that the code was taken from
 * Fred Campos' project from 2021 which also had modifications from Ferhad in
 * 2022.
 *
 * @author Vy Phan
 * @since 20241105
 */
@Controller
@RequestMapping("/photographysession")
public class PhotographySessionController {

    private final PhotographySessionRepository _psr;
    private final CodeValueRepository _cvr;

    @Autowired
    public PhotographySessionController(PhotographySessionRepository psr, CodeValueRepository cvr) {
        _psr = psr;
        _cvr = cvr;
    }

    @Autowired
    private MessageSource messageSource;

    private static final Logger logger = LoggerFactory.getLogger(PhotographySessionController.class);

    @RequestMapping("")
    public String home(Model model, HttpSession session) {
        Iterable<PhotographySession> photographySessions = _psr.findAll();
        model.addAttribute("photographySessions", photographySessions);
        model.addAttribute("photographySession", new PhotographySession());
        return "photographysession/list";
    }

//    private void loadTicketTypeDescriptions(Iterable<TicketOrder> theTickets){
//
//        List<TicketOrder> result = Lists.newArrayList(theTickets);
//
//        for(TicketOrder current: theTickets){
//            Optional<CodeValue> codeValue = _cvr.findById(current.getTicketTypeCode());
//            if(codeValue.isPresent()){
//                CodeValue currentCodeValue = codeValue.get();
//                current.setTicketTypeCodeDescription(currentCodeValue.getEnglishDescription());
//            }else{
//                current.setTicketTypeCodeDescription("Unknown");
//            }
//
//        }
//    }

    /**
     * Page to add new entity. Taken from tutor app from 2022 (which was
     * also derived from class samples)
     *
     * @param model
     * @return add
     * @author Vy Phan
     * @since 2024-10-29
     */
    @RequestMapping("/add")
    public String add(Model model, HttpSession session) {
        PhotographySessionBO.setPackageTypes(_cvr, session);
        PhotographySession photographySession = new PhotographySession();
        PhotographySessionBO.setPhotographySessionDefaults(photographySession);
        model.addAttribute("photographySession", photographySession);
        return "photographysession/add";
    }

    /**
     * Search for photography sessions given a customer name
     *
     * @param model
     * @param photographySession
     * @return view for list
     * @author Vy Phan
     * @since 2024-12-09
     */
    @RequestMapping("/searchForName")
    public String search(Model model, @ModelAttribute("photographySession") PhotographySession photographySession) {

        //**********************************************************************
        //Use repository method created to find any ticket orders which contain
        //the name entered on the list page.
        //**********************************************************************
        model.addAttribute("photographySessions", _psr.findByClientNameContaining(photographySession.getClientName()));
        logger.debug("searched for photographySession name" + photographySession.getClientName());
        return "photographysession/list";
    }

    /**
     * Search for photography sessions given an id
     *
     * @param model
     * @param photographySession
     * @return view for list
     * @author Vy Phan
     * @since 2024-12-09
     */
    @RequestMapping("/searchForId")
    public String searchById(Model model, @ModelAttribute("photographySession") PhotographySession photographySession) {

        //**********************************************************************
        //Use repository method created to find the photography session which matches
        //the id entered on the list page.
        //**********************************************************************
        Optional<PhotographySession> photographySession1 = _psr.findById(photographySession.getId());

        model.addAttribute("photographySessions", photographySession1.get());  // Extract the PhotographySession object


        return "photographysession/list";
    }

    /**
     * Submit method that processes add and edit and any form submission
     *
     * @param model
     * @param request
     * @param photographySession being added or modified
     * @param bindingResult      Result of SQL
     * @return add with errors or photographySession
     * @author Vy Phan
     * @since 20241105
     */
    @RequestMapping("/submit")
    public String submit(Model model, HttpServletRequest request, @Valid @ModelAttribute("photographySession") PhotographySession photographySession, BindingResult bindingResult) {

//        TicketOrderBO ticketOrderBO = new TicketOrderBO();
//
//        boolean valid = ticketOrderBO.processValidation(request, messageSource, ticketOrder);
        boolean valid = true;


        PhotographySessionValidationBO psvbo = new PhotographySessionValidationBO();
        ArrayList<String> validationErrorsBookingDate = psvbo.validateBookingDate(photographySession);
        if (validationErrorsBookingDate.size() > 0) {
            valid = false;
        }

        if (!valid || bindingResult.hasErrors()) {
            System.out.println("--------------------------------------------");
            System.out.println("Validation error - Vy Phan");
            for (ObjectError error : bindingResult.getAllErrors()) {
                System.out.println(error.getObjectName() + "-" + error.toString() + "-" + error.getDefaultMessage());
            }
            System.out.println("--------------------------------------------");
            photographySession.setCost(new BigDecimal(0));
            model.addAttribute("photographySession", photographySession);
            model.addAttribute("businessValidationErrorsBookingDate", validationErrorsBookingDate);
            return "photographysession/add";
        }

        PhotographySessionBO.calculatePhotographySessionCost(photographySession);
        _psr.save(photographySession);

        return "redirect:/photographysession";
    }

    /**
     * Page to edit
     *
     * @param id
     * @param model
     * @author Vy Phan
     * @since 20241030
     */
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model, HttpSession session) {
        PhotographySessionBO.setPackageTypes(_cvr, session);
        Optional photographySession = _psr.findById(id);
        if (photographySession.isPresent()) {
            model.addAttribute("photographySession", photographySession.get());
            return "photographysession/add";
        }
        return "redirect:/photographysession";
    }

    /**
     * Page to delete a photography session
     *
     * @param id ID of photography session
     * @return photography session
     * @author Vy Phan
     * @since 20241105
     */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        _psr.deleteById(id);
        return "redirect:/photographysession";
    }

}
