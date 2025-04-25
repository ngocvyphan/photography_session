package ca.hccis.photography;

import ca.hccis.photography.thread.ThreadPhotographySession;


/**
 * Main method starts the console and gui threads
 * and controls the flow of the program.
 * @param args Args to main
 * @since 20240929
 * @author Vy Phan
 */
public class Main {



    public static void main(String[] args) {
        ThreadPhotographySession console = new ThreadPhotographySession();
        console.setIsGUI(false);
        console.start();

        ThreadPhotographySession gui = new ThreadPhotographySession();
        gui.setIsGUI(true);
        gui.start();
    }
}