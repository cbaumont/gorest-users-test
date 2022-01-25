package utils

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class PropertiesReader {

    private static final Properties prop
    private static final Logger logger = LoggerFactory.getLogger(PropertiesReader.class)

    static {
        prop = new Properties()
        try {
            prop.load(PropertiesReader.class.getClassLoader().getResourceAsStream("application.properties"))
        } catch (IOException e) {
            logger.info(Arrays.toString(e.getStackTrace()))
        }
    }

    static String get(String property) {
        return prop.getProperty(property)
    }
}
