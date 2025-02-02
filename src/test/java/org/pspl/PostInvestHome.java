package org.pspl;

import com.google.common.collect.ImmutableMap;
import org.pspl.TestUtils.IOSBaseTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PostInvestHome extends IOSBaseTest {

    @Test
    public void redirectPostInvest() throws InterruptedException, IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//org//pspl//resources//data.properties");
        prop.load(fis);

        String deepLinkUrl = prop.getProperty("postInvestDeepLinkUrl");
        String bundleId = prop.getProperty("bundleId");
        driver.executeScript("mobile: deepLink", ImmutableMap.of("url", deepLinkUrl, "bundleId", bundleId));

        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
    }
}