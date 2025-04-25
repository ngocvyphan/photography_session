package ca.hccis.photography.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class ConnectionUtils {

    private final static Logger LOGGER = Logger.getLogger(ConnectionUtils.class.getName());

//	private static MessageResources messages 
//	 = MessageResources.getMessageResources("spring/data-access.properties");
    private static String USER_NAME_DB = "root";
    private static String USER_PASSWORD_DB = "";
    private static String DB_NAME = "cis2232_photography_session";
    private static String HOST_NAME = "127.0.0.1";

    public static Connection getConnection() throws Exception {
        return getDBConnection();
    }

    private static Connection getDBConnection() throws Exception {
// LOGGER.log(Level.INFO, "in getDBConnection");
        if (USER_NAME_DB.equals("")) {
            InputStreamReader reader = null;
            FileInputStream fis = null;
            ResourceBundle rb = null;
            try {
                File file = new File("src/main/resources/data-access.properties");
                if (file.isFile()) { // Also checks for existance
                    fis = new FileInputStream(file);
                    //System.out.println(fis);
                    reader = new InputStreamReader(fis, Charset.forName("UTF-8"));
                    rb = new PropertyResourceBundle(reader);
                }
            } finally {
                reader.close();
                fis.close();
            }

            // Enumeration<String> keys = rb.getKeys();
            // while (keys.hasMoreElements()) {
            // String key = keys.nextElement();
            // String value = rb.getString(key);
            // //System.out.println(key + ": " + value);
            // }
            USER_NAME_DB = rb.getString("jdbc.username");
            USER_PASSWORD_DB = rb.getString("jdbc.password");
            DB_NAME = rb.getString("jdbc.dbname");
            HOST_NAME = rb.getString("jdbc.host");
        }
        // Properties props = new Properties();
        //
        // InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        // if (inputStream != null) {
        // props.load(inputStream);
        // } else {
        // throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        // }
        Connection conn = null;
        String URL = "jdbc:mysql://" + HOST_NAME + ":3306/" + DB_NAME;
        //System.out.println(URL);
        // System.out.println("URL=" + URL);
        // System.out.println("User=" + USER_NAME_DB);
        // System.out.println("Pw=" + USER_PASSWORD_DB);
        try {
            conn = DriverManager.getConnection(URL, USER_NAME_DB, USER_PASSWORD_DB);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // try {
        // conn = DriverManager.getConnection(URL, "root", "");
        // } catch (Exception e) {
        // System.out.println("Error");
        // }
        return conn;
    }
}
