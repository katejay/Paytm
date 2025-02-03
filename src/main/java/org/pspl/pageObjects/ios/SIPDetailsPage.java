package org.pspl.pageObjects.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.pspl.utils.IOSActions;

public class SIPDetailsPage extends IOSActions {

    IOSDriver driver;

    public SIPDetailsPage(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
