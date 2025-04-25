package ca.hccis.photography.settings;
/**
 * Interface to hold file location information
 * @since 20240929
 * @author Vy Phan
 */
public interface Config {
    public static final String MENU = "A) Add a photography session" + System.lineSeparator()
            + "V) View all photography sessions" + System.lineSeparator()
            + "E) Exit" + System.lineSeparator();
    public static final String EXIT = "E";
    public static final String MESSAGE_ERROR = "Error";
    public static final String MESSAGE_EXIT = "Goodbye";
    public static final String FOLDER_NAME = "C:\\CIS2232\\";
    public static final String FILE_NAME_JSON = "data_phan_vy.json";
}

