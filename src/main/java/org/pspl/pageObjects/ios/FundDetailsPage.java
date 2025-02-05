package org.pspl.pageObjects.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.pspl.utils.IOSActions;

public class FundDetailsPage extends IOSActions {

    IOSDriver driver;

    public FundDetailsPage(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement amcLogo;

    @iOSXCUITFindBy(iOSNsPredicate = "confidential")
    private WebElement fundLabel;

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement returnsSinceLaunchLabel;

    @iOSXCUITFindBy(xpath = "confidential")
    private WebElement returnsSinceLaunch;

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement fundSizeLabel;






    @iOSXCUITFindBy(accessibility = "Lock in")
    private WebElement lockInLabel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Paytm Regular MF']/XCUIElementTypeOther[11]/following-sibling::XCUIElementTypeStaticText")
    private WebElement lockIn;

    @iOSXCUITFindBy(accessibility = "SEBI Riskometer")
    private WebElement sebiRiskometerLabel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Paytm Regular MF']/XCUIElementTypeOther[13]/following-sibling::XCUIElementTypeStaticText")
    private WebElement sebiRiskometer;

    @iOSXCUITFindBy(iOSNsPredicate = "type =='XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Download'")
    private WebElement downloadFactSheet;

    @iOSXCUITFindBy(iOSNsPredicate = "type =='XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Detailed view'")
    private WebElement downloadFactSheetSubText;

    @iOSXCUITFindBy(iOSNsPredicate = "type =='XCUIElementTypeButton' AND name BEGINSWITH[c] 'Select Your Daily'")
    private WebElement selectYourDailySIPAmountCTA;

    public void checkAMCLogo() {
        amcLogo.isDisplayed();
    }

    public String getFundLabel(){
        return fundLabel.getText();
    }

    public String getReturnsSinceLaunchLabel(){
        return returnsSinceLaunchLabel.getText();
    }

    public String getReturnsSinceLaunch(){
        return returnsSinceLaunch.getText();
    }

    public String getFundSizeLabel(){
        return fundSizeLabel.getText();
    }






    public String getLockInLabel(){
        return lockInLabel.getText();
    }

    public String getLockIn(){
        return lockIn.getText();
    }

    public String getSebiRiskometerLabel(){
        return sebiRiskometerLabel.getText();
    }

    public String getSebiRiskometer(){
        return sebiRiskometer.getText();
    }

    public String getDownloadFactSheetLabel(){
        return downloadFactSheet.getText();
    }

    public void clickDownloadFactSheet(){
        downloadFactSheet.click();
    }

    public String getDownloadFactSheetSubTextLabel(){
        return downloadFactSheetSubText.getText();
    }

    public String getSelectYourDailySIPAmountCTALabel(){
        return selectYourDailySIPAmountCTA.getText();
    }

    public void clickSelectYourDailySIPAmountCTA(){
        selectYourDailySIPAmountCTA.click();
    }
}
