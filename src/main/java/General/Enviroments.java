package General;

import ConfigProperties.Config;

public class Enviroments {

    public static Config config = new Config();
    public static String URL = config.GetProperties("URL");
    public static String dbUrl = config.GetProperties("dbUrl");
    public static String dbUsername = config.GetProperties("dbUsername");
    public static String dbPassword = config.GetProperties("dbPassword");
}
