package org.pspl.pageObjects.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.pspl.utils.IOSActions;

public class LoginPage extends IOSActions {

    IOSDriver driver;

    public LoginPage(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement staging;

    @iOSXCUITFindBy(iOSClassChain = "confidential")
    private WebElement mobileNumber;

    @iOSXCUITFindBy(iOSClassChain = "confidential")
    private WebElement loginButton;

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement simpleLogin;

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement password;

    @iOSXCUITFindBy(accessibility = "confidential")
    private WebElement leftBarButton;

    public void selectStaging() {
        staging.click();
        //return new AlertViews(driver);
    }

    public void enterMobileNumber(String number) {
        mobileNumber.sendKeys(number);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickSimpleLogin() {
        simpleLogin.click();
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clickLeftBarButton() {
        leftBarButton.click();
    }

    public void getLogin(String number, String pass) throws InterruptedException {
        staging.click();
        mobileNumber.sendKeys(number);
        loginButton.click();
        driver.switchTo().alert().dismiss();
        simpleLogin.click();
        password.sendKeys(pass);
        loginButton.click();
        Thread.sleep(5000);
        driver.switchTo().alert().dismiss();
        try{
        leftBarButton.click();
        }catch(Exception e){
            System.out.println("No left bar button");
        }
    }
}
