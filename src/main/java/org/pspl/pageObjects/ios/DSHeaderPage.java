package org.pspl.pageObjects.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.pspl.utils.IOSActions;

public class DSHeaderPage extends IOSActions {

    IOSDriver driver;

    public DSHeaderPage(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement logo;

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement backIcon;

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement help;


    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement connectWithUs;

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement avatar;

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement raiseATicket;

    @iOSXCUITFindBy(iOSNsPredicate = "confidential")
    private WebElement raiseATicketSubText;

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement cancel;



    public void checkLogo() {
        logo.isDisplayed();
    }

     public void clickBackIcon() {
         backIcon.click();
     }

     public String getHelpLabel(){
         return help.getText();
     }

     public void clickHelp() {
         help.click();
     }

    public String getConnectWithUs() {
        return connectWithUs.getText();
    }

    public void checkAvatar() {
        avatar.isDisplayed();
    }

    public String getRaiseATicketText() {
        return raiseATicket.getText();
    }

    public String getRaiseATicketSubText() {
        return raiseATicketSubText.getText();
    }

    public void clickRaiseATicket() {
        raiseATicket.click();
    }

    public void clickCancelHelp() {
        cancel.click();
    }
}
