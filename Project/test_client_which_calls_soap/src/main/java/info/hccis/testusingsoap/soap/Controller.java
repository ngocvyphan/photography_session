package info.hccis.testusingsoap.soap;

import java.util.List;
import java.util.Scanner;

/**
 * Test soap
 *
 * @author bjmac
 * @since 20211115
 *
 */
public class Controller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        PhotographySessionServiceImplService pssis = new PhotographySessionServiceImplService();
        PhotographySessionService photographySessionService = pssis.getPhotographySessionServiceImplPort();

        System.out.println("There are " + photographySessionService.getCount() + " rows in the database");

        String option = "";
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter id of asssessment to view, 0 to view all, -1 to exit");

            option = input.nextLine();
            if (!option.equals("-1")) {
                try {
                    int optionNumeric = Integer.parseInt(option);
                    if (optionNumeric == 0) {
                        for (PhotographySession current : photographySessionService.getPhotographySessions()) {
                            System.out.println("id: " + current.getId() + "\n" + "name: "+ current.clientName + "\n" + "package number: " + current.getPackageNumber() + System.lineSeparator());
                        }
                    } else {
                        PhotographySession photographySession = photographySessionService.getPhotographySession(optionNumeric);
                        System.out.println("id: " + photographySession.getId() + "\n" + "name: "+photographySession.clientName + "\n" + "package number: " + photographySession.getPackageNumber());
                    }
                } catch (Exception e) {
                    //Exception caught because the user entered a name
                    System.out.println("Error");
                }
            }

        } while (!option.equalsIgnoreCase("-1"));

//        StudentServiceImplService ssis = new StudentServiceImplService();
//        StudentService ss = ssis.getStudentServiceImplPort();
//
//        int count = ss.getStudentCount();
//        
//        
//        String idEntered = JOptionPane.showInputDialog("There are "+count+" students.  Enter id to lookup");
//        Student student =  ss.getStudent(Integer.parseInt(idEntered));
//        System.out.println(student.getName());
//        JOptionPane.showMessageDialog(null, "The student's name is: "+student.getName()+" "+student.getProgram());
//
    }

}
