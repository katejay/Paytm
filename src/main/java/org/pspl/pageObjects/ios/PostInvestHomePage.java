package org.pspl.pageObjects.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.pspl.utils.IOSActions;

public class PostInvestHomePage extends IOSActions {

    IOSDriver driver;

    public PostInvestHomePage(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "confidential")
    private WebElement clickOkAlert;

    @iOSXCUITFindBy(iOSClassChain = "confidential")
    private WebElement account;

    @iOSXCUITFindBy(iOSClassChain = "confidential")
    private WebElement transactions;


    public void agreeAlert() {
        clickOkAlert.click();
        clickOkAlert.click();
        //return new AlertViews(driver);
    }

    public void clickAccount() {
        account.click();
        new AccountPage(driver);
    }

    public void clickTransactions() {
        transactions.click();
    }
}
