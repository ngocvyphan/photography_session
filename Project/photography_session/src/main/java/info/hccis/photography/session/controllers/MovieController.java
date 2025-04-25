package info.hccis.photography.session.controllers;

import info.hccis.photography.session.entity.Movie;
import info.hccis.photography.session.util.CisUtilityNetwork;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Controller to administer call to api for the list of movies based on the genre input
 *
 * @author Vy Phan
 * @since 20241110
 */
@Controller
@RequestMapping("/movie")
public class MovieController {

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

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

        model.addAttribute("movie", new Movie());
        return "/movie/keyword";
    }

    /**
     * Process the report of date of booking
     *
     * @param model
     * @param movie
     * @return list of movies based on the genre inputs
     * @author Vy Phan
     * @since 2024-11-10
     */
    @RequestMapping("/submit")
    public String submitKeyword(Model model, @ModelAttribute("movie") Movie movie) {
        String movieTitle = "";
        String textToSend = "";
        ArrayList<String> titles = new ArrayList<>();
        try {
            textToSend = URLEncoder.encode(
                    movie.getKeyword(),
                    StandardCharsets.UTF_8.toString()
            );
        } catch (UnsupportedEncodingException e) {
            logger.error("Error encoding"+e.getMessage());
        }
        //Put object in model so it can be used on the view (html)
        String result = CisUtilityNetwork.connectToApi("https://www.omdbapi.com/?s="+textToSend+"&apikey=1c86efd8");
        System.out.println(result);

        JSONObject jsonObject = new JSONObject(result);
        JSONArray searchArray = jsonObject.getJSONArray("Search");
        for (int i = 0; i < searchArray.length(); i++) {
            JSONObject item = searchArray.getJSONObject(i);
            movieTitle = item.getString("Title");
            titles.add(movieTitle);
            System.out.println(movieTitle); // Print the title
        }


        movie.setTitleLists(titles);

        model.addAttribute("movie", movie);



        return "movie/keyword";
    }



}
