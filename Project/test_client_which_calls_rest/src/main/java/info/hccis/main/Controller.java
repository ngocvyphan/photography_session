package info.hccis.main;

import com.google.gson.Gson;
import info.hccis.model.jpa.BusPass;
import info.hccis.model.jpa.PhotographySession;
import info.hccis.model.jpa.SkillsAssessmentSquashTechnical;
import info.hccis.student.util.UtilityRest;
import java.util.Scanner;
import org.json.JSONArray;

public class Controller {

    final public static String MENU = "\nMain Menu \nA) Add\n"
            + "U) Update (FUTURE)\n"
            + "V) View\n"
            + "D) Delete\n"
            + "X) eXit";
    final static Scanner input = new Scanner(System.in);
    private static final String URL_STRING = "http://localhost:8080/api/PhotographySessionService/photographySessions/";

    public static void main(String[] args) {
        boolean endProgram = false;
        do {
            System.out.println(MENU);
            String choice = input.nextLine();
            PhotographySession photographySession;
            String url;
            switch (choice.toUpperCase()) {
                case "A":
                    photographySession = create();
                    url = URL_STRING;
                    System.out.println("Url=" + url);
                    PhotographySession photographySessionReturned = (PhotographySession) UtilityRest.addUsingRest(url, photographySession);
                    if(photographySessionReturned  != null) {
                        System.out.println("Added new entity:" + photographySessionReturned.toString());
                    }
                    break;
//                case "U":
//                    photographySession = create();
//                    url = URL_STRING;
//                    System.out.println("Url="+url);
//                    UtilityRest.updateUsingRest(url, photographySession);
//                    break;
                case "D":
                    System.out.println("Enter id to delete");
                    Scanner input = new Scanner(System.in);
                    int id = input.nextInt();
                    input.nextLine();  //burn
                    UtilityRest.deleteUsingRest(URL_STRING, id);
                    break;
                case "V":
                    String jsonReturned = UtilityRest.getJsonFromRest(URL_STRING);
                    //**************************************************************
                    //Based on the json string passed back, loop through each json
                    //object which is a json string in an array of json strings.
                    //*************************************************************
                    JSONArray jsonArray = new JSONArray(jsonReturned);
                    //**************************************************************
                    //For each json object in the array, show the first and last names
                    //**************************************************************
                    System.out.println("Here are the rows");
                    Gson gson = new Gson();
                    for (int currentIndex = 0; currentIndex < jsonArray.length(); currentIndex++) {
                        PhotographySession current = gson.fromJson(jsonArray.getJSONObject(currentIndex).toString(), PhotographySession.class);
                        System.out.println(current.toString());
                    }
                    break;

                case "X":
                    endProgram = true;
                    break;
                default:
                    System.out.println("INVALID OPTION");
            }
        } while (!endProgram);
    }

    /**
     * Create an object by passing asking user for input.
     *
     * @return object
     * @since 20241115
     * @author Vy Phan
     */
    public static PhotographySession create() {
        PhotographySession photographySession = new PhotographySession();
        photographySession.getInformation();
        return photographySession;
    }

}
