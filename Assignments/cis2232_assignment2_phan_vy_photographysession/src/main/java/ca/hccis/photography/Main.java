package ca.hccis.photography;

import ca.hccis.photography.entity.PhotographySession;
import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * The program allows users to add the photography session, which will write all the entity inputs
 * into files (text, csv, and json) and after adding, the users can also view the entity inputs in the
 * java console. The program also has the option to exit.
 *
 * @author Vy Phan
 * @since 20240917
 */
public class Main {
    public static final String MENU = "A) Add" + System.lineSeparator()
            + "V) View" + System.lineSeparator()
            + "E) Exit" + System.lineSeparator();
    public static final String MESSAGE_ERROR = "Error";
    public static final String MESSAGE_EXIT = "Goodbye";
    public static final String FOLDER_NAME = "C:\\CIS2232\\";
    public static final String FILE_NAME = "data_phan_vy.txt";
    public static final String FILE_NAME_CSV = "data_phan_vy.csv";
    public static final String FILE_NAME_JSON = "data_phan_vy.json";


    public static void main(String[] args) {
        String menuOption;

        System.out.printf("Photography Session Application\n\n");

        //https://stackoverflow.com/questions/3634853/how-to-create-a-directory-in-java
        //https://www.geeksforgeeks.org/how-to-create-a-directory-in-java/
        // Check if the folder CIS2232 exists in the C drive, if not create the folder CIS2232
        File directory = new File(FOLDER_NAME);
        if (!directory.exists()) {
            // if file.mkdir() is true, directory created successfully
            // can assign boolean directoryCreated = file.mkdir();
            if (directory.mkdir()) {
                System.out.println("Directory is created!");
                // if file.mkdir() is false, failed to create directory, it may already exist
            } else {
                System.out.println("Failed to create directory!");
            }
        }

        do {
            Scanner input = new Scanner(System.in);
            System.out.println("Menu option:\n" + MENU
                    + "Choose the above options");
            menuOption = input.nextLine().toUpperCase();

            switch (menuOption) {
                case "A":
                    addAPhotographySession();
                    break;
                case "V":
                    viewAllPhotographySessions();
                    break;
                case "E":
                    System.out.println(MESSAGE_EXIT);
                    break; //Break out of the loop as we're finished.
                default:
                    System.out.println(MESSAGE_ERROR);
                    break;
            }
        }while (!"E".equals(menuOption));
    }

    /**
     * The addAPhotographySession() method will allow users to add a photography session
     * by entering the entity inputs when users chooses option A and
     * all the entity inputs will be written into files (text, csv, and json)
     *
     * @author Vy Phan
     * @since 20240917
     */
    public static void addAPhotographySession(){
        Gson gson = new Gson();

        PhotographySession photographySession = new PhotographySession();
        photographySession.getInformation();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter( FOLDER_NAME + FILE_NAME, true))){
            writer.write(photographySession.toString());
            writer.newLine();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FOLDER_NAME  +FILE_NAME_CSV, true))){
            writer.write(photographySession.toCSV());
            writer.newLine();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FOLDER_NAME + FILE_NAME_JSON, true))){
            writer.write(gson.toJson(photographySession));
            writer.newLine();
        }
        catch(IOException ex){
            ex.printStackTrace();
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
    public static void viewAllPhotographySessions(){
        Gson gson = new Gson();
        //https://www.javaguides.net/2019/07/java-read-file-with-filesreadalllines-api.html#google_vignette
        Path filePath = Paths.get(FOLDER_NAME +FILE_NAME_JSON);
        try {
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                PhotographySession current = gson.fromJson(line, PhotographySession.class);
                System.out.println(current.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}