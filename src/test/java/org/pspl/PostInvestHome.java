package org.pspl;

import com.google.common.collect.ImmutableMap;
import org.pspl.TestUtils.IOSBaseTest;
import org.pspl.pageObjects.ios.AccountPage;
import org.pspl.pageObjects.ios.PostInvestHomePage;
import org.testng.annotations.Test;
import java.io.IOException;

public class PostInvestHome extends IOSBaseTest {

    PostInvestHomePage postInvestHomePage;
    AccountPage accountPage;

    @Test
    public void redirectPostInvest() throws IOException {
        String deepLinkUrl = prop.getProperty("postInvestDeepLinkUrl");
        String bundleId = prop.getProperty("bundleId");
        driver.executeScript("mobile: deepLink", ImmutableMap.of("url", deepLinkUrl, "bundleId", bundleId));

        postInvestHomePage = new PostInvestHomePage(driver);
        accountPage = new AccountPage(driver);
        postInvestHomePage.agreeAlert();
        System.out.println("Post invest home driver 1 : " + driver);
    }

    @Test(dependsOnMethods = {"redirectPostInvest"})
    public void redirectAccount() throws InterruptedException {
        Thread.sleep(5000);
        postInvestHomePage.clickAccount();
        System.out.println("Post invest home driver 2 : " + driver);
    }
}