package org.pspl.TestUtils;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.pspl.pageObjects.ios.LoginPage;
import org.pspl.utils.AppiumUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class IOSBaseTest extends AppiumUtils {

    public IOSDriver driver;
    public AppiumDriverLocalService service;
    public LoginPage loginPage;
    public Properties prop;
    public FileInputStream fis;

    @BeforeSuite
    public void ConfigureAppium() throws IOException, InterruptedException {

        prop = new Properties();
        fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//org//pspl//resources//data.properties");
        prop.load(fis);

        String paytmApp = System.getProperty("user.dir") + "/src/test/java/org/pspl/resources/Paytm.app";
        String ipAddress = prop.getProperty("ipAddress");
        String port = prop.getProperty("port");
        String platformName = prop.getProperty("platformName");
        String platformVersion = prop.getProperty("platformVersion");
        String deviceName = prop.getProperty("deviceName");
        String automationName = prop.getProperty("automationName");
        String bundleId = prop.getProperty("bundleId");

        String number = prop.getProperty("prNumber");
        String password = prop.getProperty("password");

        service = startAppiumServer(ipAddress, Integer.parseInt(port));

        // Set up Appium capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("appium:platformVersion", platformVersion);
        capabilities.setCapability("appium:deviceName", deviceName);
        capabilities.setCapability("appium:automationName", automationName);
        capabilities.setCapability("appium:app", paytmApp);
        capabilities.setCapability("appium:bundleId", bundleId);

        driver = new IOSDriver(service.getUrl(), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage(driver); //change to home page
        if (number != null && password != null) {
            loginPage.getLogin(number, password);
        } else {
            throw new IllegalArgumentException("Login credentials are missing");
        }

        System.out.println("iOSBase driver 1 : " + driver);
    }

    @AfterSuite
    public void terminate() {
        //Close the driver session
        //driver.quit();

        //Stop the Appium server
        //service.stop();
    }
}
