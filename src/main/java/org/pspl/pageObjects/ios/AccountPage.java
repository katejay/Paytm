package org.pspl.pageObjects.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.pspl.utils.IOSActions;

public class AccountPage extends IOSActions {

    IOSDriver driver;

    public AccountPage(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "confidential")
    private WebElement manageYourAccount;

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement help;

    @iOSXCUITFindBy(iOSClassChain = "confidential")
    private WebElement frequentlyAskedQuestions;

    @iOSXCUITFindBy(iOSClassChain = "confidential")
    private WebElement viewAndManageSIP;

    @iOSXCUITFindBy(iOSClassChain = "confidential")
    private WebElement redeem;

    @iOSXCUITFindBy(iOSClassChain = "confidential")
    private WebElement helpAndSupport;

    @iOSXCUITFindBy(iOSClassChain = "confidential")
    private WebElement monthlySIP;

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement referLogo;

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement connectWithUs;

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement raiseATicket;

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement cancel;

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement manageSIP;

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement viewSIPDetails;

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement cancelSIP;

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement closeReferLogo;

    @iOSXCUITFindBy(iOSNsPredicate = "confidential")
    private WebElement referMessage;

    public String getManageYourAccount() {
        return manageYourAccount.getText();
    }

    public void clickHelp() {
        help.click();
    }

    public String getConnectWithUs() {
        return connectWithUs.getText();
    }

    public void clickRaiseATicket() {
        raiseATicket.click();
    }

    public void clickCancelHelp() {
        cancel.click();
    }

    public void clickFrequentlyAskedQuestions() {
        frequentlyAskedQuestions.click();
    }

    public void clickViewAndManageSIP() {
        viewAndManageSIP.click();
    }

    public String getManageSIP() {
        return manageSIP.getText();
    }

    public void clickViewSIPDetails() {
        viewSIPDetails.click();
    }

    public void clickCancelSIP() {
        cancelSIP.click();
    }

    public void clickRedeem() {
        redeem.click();
    }

    public void clickHelpAndSupport() {
        helpAndSupport.click();
    }

    public void clickMonthlySIP() {
        monthlySIP.click();
    }

    public void clickReferLogo() {
        referLogo.click();
    }

    public void clickCloseReferLogo() {
        closeReferLogo.click();
    }

    public String getReferMessage() {
        return referMessage.getText();
    }









}
