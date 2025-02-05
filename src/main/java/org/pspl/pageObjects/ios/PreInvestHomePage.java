package org.pspl.pageObjects.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.pspl.utils.IOSActions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PreInvestHomePage extends IOSActions {

    IOSDriver driver;

    public PreInvestHomePage(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(xpath = "confidential")
    private WebElement clickOkAlert;

    @iOSXCUITFindBy(iOSNsPredicate = "confidential")
    private WebElement heading;

    //Change logic here
    @iOSXCUITFindBy(xpath = "confidential")
    private WebElement amount;

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement fundLogo;

    @iOSXCUITFindBy(iOSNsPredicate = "confidential")
    private WebElement fundLabel;

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement returnsSinceLaunchLabel;

    @iOSXCUITFindBy(xpath = "confidential")
    private WebElement returnsSinceLaunch;

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement fundRatingLabel;

    //Change logic here
    @iOSXCUITFindBy(xpath = "confidential")
    private WebElement fundRating;

    @iOSXCUITFindBy(iOSNsPredicate = "confidential")
    private WebElement fundMessage;

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement viewFundDetails;

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement changeFund;

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement readMore;

    @iOSXCUITFindBy(iOSNsPredicate = "confidential")
    private WebElement confirmationMessage;

    @iOSXCUITFindBy(iOSNsPredicate = "confidential")
    private WebElement footerLabel1;

    @iOSXCUITFindBy(iOSNsPredicate = "confidential")
    private WebElement footerLabel2;

    @iOSXCUITFindBy(iOSNsPredicate = "confidential")
    private WebElement footerLabel3;

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement startDailySIPCTA;

    public void agreeAlert() {
        clickOkAlert.click();
        clickOkAlert.click();
    }

    public String getHeading(){
        return heading.getText();
    }

    public void checkFundLogo(){
        fundLogo.isDisplayed();
    }

    public String getFundLabel(){
        return fundLabel.getText();
    }

    //Change logic here
    public List<String> getAmountList(){
        List<WebElement> amountList = amount.findElements(By.xpath("confidential"));
        List<String> amountLabel = new ArrayList<>();
        for(WebElement webElement : amountList) {
            amountLabel.add(webElement.getText());
        }
        return amountLabel;
    }

    public String getReturnsSinceLaunchLabel(){
        return returnsSinceLaunchLabel.getText();
    }

    public String getReturnsSinceLaunch(){
        return returnsSinceLaunch.getText();
    }

    public String getFundRatingLabel(){
        return fundRatingLabel.getText();
    }

    //Change logic here
    public int getFundRating(){
        List<WebElement> rating = fundRating.findElements(By.xpath("following-sibling::XCUIElementTypeStaticText"));
        System.out.println("Number of XCUIElementTypeStaticText elements with name '★': " + rating.size());
        return rating.size();
    }

    public String getFundMessage(){
        return fundMessage.getText();
    }

    public String getViewFundDetailsLabel(){
        return viewFundDetails.getText();
    }

    public void clickViewFundDetails() {
        viewFundDetails.click();
    }

    public String getChangeFundLabel(){
        return changeFund.getText();
    }

    public void clickChangeFund() {
        changeFund.click();
    }

    public String getReadMoreLabel(){
        return readMore.getText();
    }

    public void clickReadMore() {
         readMore.click();
    }

    public String getConfirmationMessage(){
        return confirmationMessage.getText();
    }

    public String getFooterLabel1(){
        return footerLabel1.getText();
    }

    public String getFooterLabel2(){
        return footerLabel2.getText();
    }

    public String getFooterLabel3(){
        return footerLabel3.getText();
    }

    public String getStartDailySIPCTALabel(){
        return startDailySIPCTA.getText();
    }

    public void clickStartDailySIPCTA() {
        startDailySIPCTA.click();
    }
}
