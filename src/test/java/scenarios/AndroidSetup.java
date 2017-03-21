package scenarios;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dyned on 3/10/17.
 */
public class AndroidSetup {

    static AndroidDriver driver;
    AppiumDriverLocalService service;

    protected static void prepareAndroidForAppium() throws MalformedURLException {
        String path = "/Users/dyned/Documents/NND/Test/tutorial/projects/testAppium/apps/";
        File appDir = new File(path);
        File app = new File(appDir, "flipkart.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "Android");

        //mandatory capabilities
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "5.1");

        //set dangerous permission (find dynamic ways)
        //capabilities.setCapability("autoGrantPermission", "true");

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    protected void startAppium() {
         //service = new AppiumDriverLocalService()
    }
}
