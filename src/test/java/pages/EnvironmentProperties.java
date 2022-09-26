package pages;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class EnvironmentProperties {

    private static EnvironmentProperties instance = new EnvironmentProperties();

    public static EnvironmentProperties getInstance() {
        return instance;
    }

    private static Map<String, String> props;

    public EnvironmentProperties() {
        loadProperties();
    }

    private static void loadProperties() {
        try {
            String env = System.getProperty("env");
            if (env == null) {
                env = "local";
                System.out.println("properties loaded from local properties file");
            }
            Properties properties = new Properties();
            InputStream inputStream = EnvironmentProperties.class.getClassLoader()
                    .getResourceAsStream("environment." + env + ".properties");
            properties.load(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            props = properties.entrySet().stream().collect(
                    Collectors.toMap(
                            e -> e.getKey().toString(),
                            e -> e.getValue().toString()
                    )
            );
        } catch (IOException ex) {

        }
    }

    public String getEnvUrl() {
        return props.get("club.url");
    }

}