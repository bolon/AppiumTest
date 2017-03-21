package scenarios;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

/**
 * Created by dyned on 3/10/17.
 */
public class AppiumTest extends AndroidSetup {
    String pkgName = "com.flipkart.android:id/";
    String pkgInstaller = "com.android.packageinstaller:id/";
    String permissionAllowButton = "permission_allow_button";
    String permissionDenyButton = "permission_deny_button";

    static WebDriverWait wait;

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        prepareAndroidForAppium();
        wait = new WebDriverWait(driver, 30);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void testClickNumberField() {
        WebElement permissionAllow;
        permissionAllow = wait.until(ExpectedConditions.elementToBeClickable(By.id(pkgInstaller + permissionAllowButton)));
        permissionAllow.click();

        WebElement numberFields;
        numberFields = wait.until(ExpectedConditions.elementToBeClickable(By.id(pkgName + "mobileNo")));
        numberFields.click();

        numberFields.sendKeys("8222922");
        Assert.assertEquals("8222922", numberFields.getText());
    }

    @Test
    public void testPermissionDenied() {
        WebElement permissionDenied;
        permissionDenied = wait.until(ExpectedConditions.elementToBeClickable(By.id(pkgInstaller + permissionDenyButton)));
        permissionDenied.click();
    }
}
