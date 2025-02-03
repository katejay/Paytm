package org.pspl;

import com.google.common.collect.ImmutableMap;
import org.pspl.TestUtils.IOSBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Account extends IOSBaseTest {

    public AccountPage accountPage;

    @Test()
        public void landAccount() {
        driver.executeScript("mobile: deepLink", ImmutableMap.of("url", "paytmmp://mini-app?aId=6823bf94c6aa48f08fcc890469fea71a&data=eyJwYXJhbXMiOiIiLCJwYXRoIjoiIiwic3BhcmFtcyI6eyJwdWxsUmVmcmVzaCI6ZmFsc2UsImNhblB1bGxEb3duIjpmYWxzZSwic2hvd1RpdGxlQmFyIjpmYWxzZX19&url=https://wealth-stg.paytm.com/account", "bundleId", "com.one97.paytm"));
    }

    /*@Test(dependsOnMethods = {"landAccount"})
    public void validateText() throws InterruptedException {
        Thread.sleep(5000);
        accountPage = new AccountPage(driver);
        Assert.assertEquals(accountPage.getManageYourAccount(), "Manage Your Account");
        //Assert.assertEquals(accountPage.getHelp(), "Help");
        accountPage.clickHelp();
        Assert.assertEquals(accountPage.getConnectWithUs(), "Connect with us!");
        accountPage.clickCancelHelp();
        accountPage.clickViewAndManageSIP();
        Assert.assertEquals(accountPage.getManageSIP(), "Manage SIP");
        Thread.sleep(5000);
        //driver.navigate().back();
        driver.switchTo().alert().dismiss();
    }

    @Test(enabled = false)
    public void redirectHelp() {
        accountPage.clickRaiseATicket();
    }

    @Test(enabled = false)
    public void redirectFAQ() {
        accountPage.clickFrequentlyAskedQuestions();
    }

    @Test(enabled = false)
    public void redirectHelpAndSupport() {
        accountPage.clickHelpAndSupport();
    }

    @Test(enabled = false)
    public void redirectMonthlySIP() {
        accountPage.clickMonthlySIP();
    }

    @Test(dependsOnMethods = {"validateText"})
    public void redirectRedeem() {
        accountPage.clickRedeem();
        driver.navigate().back();
    }

    @Test(dependsOnMethods = {"validateText"})
    public void validateInvite() {
        accountPage.clickReferLogo();
        Assert.assertEquals(accountPage.getReferMessage(), "Hey! Discover Daily SIP—invest small amounts daily to grow your wealth over time. Check it out here: https://m.paytm.me/paytm-se-daily-sip");
        accountPage.clickCloseReferLogo();
    }*/

}
