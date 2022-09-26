package pages;

import org.junit.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.sleep;

public class Util {

    private static String environmentFilePath = "src/test/resources/";

    public String get_PropertyValue(String configFile, String property) {
        Properties props = new Properties();
        Path path = Paths.get(environmentFilePath + configFile);
        try {
            props.load(new FileInputStream(path.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String propertyValue = props.getProperty(property);
        return propertyValue;
    }

    public boolean verifyTheDocumentDownloaded(String fileName) {
        sleep(3000);
        String projectDirectory = System.getProperty("user.dir");
        System.out.println("home directory location is :" + projectDirectory);
        File dir = new File(projectDirectory);
        File[] dirContents = dir.listFiles();
        System.out.println(dirContents.length);
        for (int i = 0; i < dirContents.length; i++) {
            System.out.println(dirContents[i].getName());
            if (dirContents[i].getName().equals(fileName)) {
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                return true;
            }
        }
        Assert.fail("Unable to verify the presence of the document");
        return false;
    }

}