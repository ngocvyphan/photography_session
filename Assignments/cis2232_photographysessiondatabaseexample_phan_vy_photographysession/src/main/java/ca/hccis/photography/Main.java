package ca.hccis.photography;

import ca.hccis.photography.dao.PhotographySessionDAO;
import ca.hccis.photography.entity.PhotographySession;
import ca.hccis.photography.thread.ThreadPhotographySession;

import java.util.ArrayList;


/**
 * Main method starts the console and gui threads
 * and controls the flow of the program.
 * @param args Args to main
 * @since 20240929
 * @author Vy Phan
 */
public class Main {



    public static void main(String[] args) {

        PhotographySessionDAO dao = new PhotographySessionDAO();
        ArrayList<PhotographySession> sessions = new ArrayList<PhotographySession>();
        sessions = dao.selectAll();
        for (PhotographySession session : sessions) {
            System.out.println(session.toString());
        }



        ThreadPhotographySession console = new ThreadPhotographySession();
        console.setIsGUI(false);
        console.start();

//        ThreadPhotographySession gui = new ThreadPhotographySession();
//        gui.setIsGUI(true);
//        gui.start();
    }
}