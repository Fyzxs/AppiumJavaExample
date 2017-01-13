package util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumTest  {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        /* configure to your situation */
        capabilities.setCapability("automationName", AutomationName.IOS_XCUI_TEST);
        capabilities.setCapability("platformVersion", "10.2");
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 7");
        capabilities.setCapability("sdk", "iphonesimulator10.2");
        capabilities.setCapability("app", "/path/to/your/app");

        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void sampleTest(){
        WebElement txt =  driver.findElement(By.id("UserIDTextField"));
        txt.sendKeys("new user");
    }

    @After
    public void tearDown() throws Exception {
        if (driver != null) driver.quit();
    }

}