package nl.hu.sie.bep.friendspammer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Configuration {
    private static final Logger logger = Logger.getLogger(Configuration.class.getName());
    private static Configuration configuration;
    private final Properties properties;
    private static File currentDirFile = new File(".");
    private static String helper = currentDirFile.getAbsolutePath();
    private static final String PROPERTIES_LOCATION = helper + "/mongo.properties";

    private Configuration() {
        properties = new Properties();
        loadProperties();
    }

    public static Configuration getInstance() {
        if (configuration == null) {
            configuration = new Configuration();
        }
        return configuration;
    }

    private void loadProperties() {
        try {
            InputStream input = getConfigStream();
            properties.load(input);
        } catch (IOException e) {
            logger.log(Level.WARNING, "Failed to load configuration properties: {0}", e.getMessage());
        }
    }

    private InputStream getConfigStream() throws IOException {
        return new FileInputStream(PROPERTIES_LOCATION);
    }


    public String getProperty(String property) {
        return properties.getProperty(property);
    }
}
