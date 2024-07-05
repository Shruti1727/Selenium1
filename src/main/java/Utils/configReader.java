package Utils;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader {
    private static Properties properties;

    static {
        try {
            FileInputStream input = new FileInputStream("C:\\Users\\shrutisachan\\OneDrive - Nagarro\\Documents\\Automation\\exit-test\\ExitAssignment\\config.properties");
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
