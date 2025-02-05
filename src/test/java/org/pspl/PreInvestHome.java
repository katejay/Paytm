package org.pspl;

import com.google.common.collect.ImmutableMap;
import org.pspl.TestUtils.IOSBaseTest;
import org.pspl.pageObjects.ios.DSHeaderPage;
import org.pspl.pageObjects.ios.FundDetailsPage;
import org.pspl.pageObjects.ios.PreInvestHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PreInvestHome extends IOSBaseTest {

    PreInvestHomePage preInvestHomePage;
    DSHeaderPage dsHeaderPage;
    FundDetailsPage fundDetailsPage;

    @Test(priority = 1)
    public void redirectPreInvest() throws InterruptedException {

        String deepLinkUrl = prop.getProperty("preInvestDeepLinkUrl");
        String bundleId = prop.getProperty("bundleId");
        driver.executeScript("mobile: deepLink", ImmutableMap.of("url", deepLinkUrl, "bundleId", bundleId));

        preInvestHomePage = new PreInvestHomePage(driver);
        Thread.sleep(5000);
        preInvestHomePage.agreeAlert();
    }

    @Test(priority = 2)
    public void validatePreInvestHeader(){
        dsHeaderPage = new DSHeaderPage(driver);
        dsHeaderPage.checkLogo();
        Assert.assertEquals(dsHeaderPage.getHelpLabel(),"Help");
        dsHeaderPage.clickHelp();
        Assert.assertEquals(dsHeaderPage.getConnectWithUs(), "Connect with us!");
        dsHeaderPage.checkAvatar();
        Assert.assertEquals(dsHeaderPage.getRaiseATicketText(), "Raise a ticket");
        Assert.assertEquals(dsHeaderPage.getRaiseATicketSubText(), "Get prompt resolutions from our support team");

        /* Commenting below line as this won't work on stage environment. will handle this later
        dsHeaderPage.clickRaiseATicket();  */

        dsHeaderPage.clickCancelHelp();
    }

    @Test(priority = 3)
    public void validatePreInvestLabels(){
        Assert.assertEquals(preInvestHomePage.getHeading(), "Select your daily savings amount");
        Assert.assertEquals(preInvestHomePage.getReturnsSinceLaunchLabel(), "Returns since launch");
        Assert.assertEquals(preInvestHomePage.getFundRatingLabel(), "Fund Rating");
        Assert.assertEquals(preInvestHomePage.getFundMessage(), "Your Mutual Fund units would be protected by regulations set by SEBI and AMFI.");
        Assert.assertEquals(preInvestHomePage.getViewFundDetailsLabel(), "View fund details");
        Assert.assertEquals(preInvestHomePage.getChangeFundLabel(), "Change fund");
        Assert.assertEquals(preInvestHomePage.getReadMoreLabel(), "read more");
        preInvestHomePage.clickReadMore();
        Assert.assertEquals(preInvestHomePage.getConfirmationMessage(), "I authorise PSPL to prefill my PAN from data available in One 97 Communications Ltd");
        Assert.assertEquals(preInvestHomePage.getFooterLabel1(), "Paytm Services Pvt Ltd (PSPL) is an AMFI registered Mutual Fund Distributor (ARN No. 114595)");
        Assert.assertEquals(preInvestHomePage.getFooterLabel2(), "Mutual Fund investments are subject to market risks, read all scheme related documents carefully.");
        Assert.assertEquals(preInvestHomePage.getFooterLabel3(), "PSPL is a wholly owned subsidiary of One97 Communications Limited (OCL) that owns the brand Paytm. OCL has no role in the mutual fund distribution business carried out by PSPL");
        Assert.assertEquals(preInvestHomePage.getStartDailySIPCTALabel(), "Start Daily SIP of ₹21");
    }

    @Test(priority = 3)
    public void validateDefaultFundDetails(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(preInvestHomePage.getFundLabel(), prop.getProperty("defaultFundName"));
        Assert.assertEquals(preInvestHomePage.getReturnsSinceLaunch(), prop.getProperty("defaultFundReturns"));
        //Assert.assertEquals(preInvestHomePage.getFundRating(), Integer.parseInt(prop.getProperty("defaultFundRating")));
    }

    @Test(priority = 3)
    public void validateAmount(){
        System.out.println(preInvestHomePage.getAmountList());
        Assert.assertEquals(preInvestHomePage.getAmountList().size(), Integer.parseInt(prop.getProperty("amountSize")));
        //Add array compare logic here
    }

    @Test(priority = 4)
    public void validateViewFundDetailsRedirection() throws InterruptedException {
        preInvestHomePage.clickViewFundDetails();
        Thread.sleep(5000);
        dsHeaderPage.clickBackIcon();
    }

    @Test(priority = 5)
    public void validateChangeFundRedirection() throws InterruptedException {
        preInvestHomePage.clickChangeFund();
        Thread.sleep(5000);
        dsHeaderPage.clickBackIcon();
    }


    @Test(priority = 6)
    public void validateFundDetailsHeader() {
        preInvestHomePage.clickViewFundDetails();
        dsHeaderPage = new DSHeaderPage(driver);
        Assert.assertEquals(dsHeaderPage.getHelpLabel(),"Help");
        dsHeaderPage.clickHelp();
        Assert.assertEquals(dsHeaderPage.getConnectWithUs(), "Connect with us!");
        dsHeaderPage.checkAvatar();
        Assert.assertEquals(dsHeaderPage.getRaiseATicketText(), "Raise a ticket");
        Assert.assertEquals(dsHeaderPage.getRaiseATicketSubText(), "Get prompt resolutions from our support team");

        /* Commenting below line as this won't work on stage environment. will handle this later
        dsHeaderPage.clickRaiseATicket();  */

        dsHeaderPage.clickCancelHelp();

        Assert.assertEquals(dsHeaderPage.getFundDetailsTitle(),"Fund Details");
    }

    @Test(priority = 7)
    public void validateFundDetails(){
        fundDetailsPage = new FundDetailsPage(driver);
        fundDetailsPage.checkAMCLogo();
        Assert.assertEquals(fundDetailsPage.getFundLabel(), prop.getProperty("defaultFundName"));


        Assert.assertEquals(fundDetailsPage.getLockInLabel(),"Lock in");
        Assert.assertEquals(fundDetailsPage.getLockIn(),prop.getProperty("defaultFundLockIn"));
        Assert.assertEquals(fundDetailsPage.getSebiRiskometerLabel(),"SEBI Riskometer");
        Assert.assertEquals(fundDetailsPage.getSebiRiskometer(),prop.getProperty("defaultFundSEBIRiskometer"));
        Assert.assertEquals(fundDetailsPage.getDownloadFactSheetLabel(),"Download factsheet");
        Assert.assertEquals(fundDetailsPage.getDownloadFactSheetSubTextLabel(),"Detailed view of all the scheme related information");
        //fundDetailsPage.clickDownloadFactSheet();
        Assert.assertEquals(fundDetailsPage.getSelectYourDailySIPAmountCTALabel(),"Select Your Daily SIP Amount");
        fundDetailsPage.clickSelectYourDailySIPAmountCTA();
    }

    /*@Test
    public void validateChangeFund(){

    }*/

    @Test(priority = 8)
    public void redirectPANPage(){
        preInvestHomePage.clickStartDailySIPCTA();
    }
}
