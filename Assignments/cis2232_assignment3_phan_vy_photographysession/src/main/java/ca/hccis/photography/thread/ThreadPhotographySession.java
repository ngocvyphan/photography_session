package ca.hccis.photography.thread;

import ca.hccis.photography.entity.PhotographySession;
import ca.hccis.photography.settings.Config;
import ca.hccis.photography.util.CisUtility;
import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * ThreadPhotographySession class
 *
 * @author Vy Phan
 * @since 20240929
 */
public class ThreadPhotographySession extends Thread implements Config {

    public boolean isGUI = false;
    private CisUtility cisUtility = new CisUtility();


    public void setIsGUI(boolean isGUI) {
        this.isGUI = isGUI;
    }


    @Override
    public void run() {
        String menuOption;
        //    CisUtility cisUtility = new CisUtility();

        cisUtility.setIsGUI(isGUI);
        cisUtility.display("Photography Session Application\n\n");

        //https://stackoverflow.com/questions/3634853/how-to-create-a-directory-in-java
        //https://www.geeksforgeeks.org/how-to-create-a-directory-in-java/
        // Check if the folder CIS2232 exists in the C drive, if not create the folder CIS2232
        File directory = new File(FOLDER_NAME);
        if (!directory.exists()) {
            // if file.mkdir() is true, directory created successfully
            // can assign boolean directoryCreated = file.mkdir();
            if (directory.mkdir()) {
                cisUtility.display("Directory is created!");
                // if file.mkdir() is false, failed to create directory, it may already exist
            } else {
                cisUtility.display("Failed to create directory!");
            }
        }

        do {
            menuOption = cisUtility.getInputString("Menu option:\n" + MENU
                    + "Choose the above options");

            switch (menuOption.toUpperCase()) {
                case "A":
                    addAPhotographySession();
                    break;
                case "V":
                    viewAllPhotographySessions();
                    break;
                case "E":
                    cisUtility.display(MESSAGE_EXIT);
                    break; //Break out of the loop as we're finished.
                default:
                    cisUtility.display(MESSAGE_ERROR);
                    break;
            }
        } while (!menuOption.equalsIgnoreCase(EXIT));
    }


    /**
     * The addAPhotographySession() method will allow users to add a photography session
     * by entering the entity inputs when users chooses option A and
     * all the entity inputs will be written into files (text, csv, and json)
     *
     * @author Vy Phan
     * @since 20240917
     */
    public void addAPhotographySession() {
        Gson gson = new Gson();

        PhotographySession photographySession = new PhotographySession(isGUI);
        photographySession.getInformation();


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FOLDER_NAME + FILE_NAME_JSON, true))) {
            writer.write(gson.toJson(photographySession));
            writer.newLine();
        } catch (IOException ex) {
            cisUtility.display((ex.getMessage()));
        }
    }

    /**
     * The viewAllPhotographySessions() method will allow users to view all the photography sessions
     * which have been added previously in the addAPhotographySession() method to the java console
     * when users choose the option V
     *
     * @author Vy Phan
     * @since 20240917
     */
    public void viewAllPhotographySessions() {
//        CisUtility cisUtility = new CisUtility();
//        cisUtility.setIsGUI(isGUI);
        Gson gson = new Gson();
        //https://www.javaguides.net/2019/07/java-read-file-with-filesreadalllines-api.html#google_vignette
        Path filePath = Paths.get(FOLDER_NAME + FILE_NAME_JSON);
        try {
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                PhotographySession current = gson.fromJson(line, PhotographySession.class);
                cisUtility.display((current.toString()));
            }
        } catch (IOException e) {
            cisUtility.display("No json file exists");
        }
    }

}
