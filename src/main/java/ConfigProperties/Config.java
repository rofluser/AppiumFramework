package ConfigProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    public static String GetProperties(String value){
        String property;
        try{
            Properties p = new Properties();
            FileInputStream file = new FileInputStream("src/main/resources/Project.properties");
            p.load(file);
            property = p.getProperty(value);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return property;
    }
}
