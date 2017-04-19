package Tests;

import AppiumSupport.AppiumController;
import Pages.SignInPage;
import Pages.SignInPageAndroid;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

/**
 * Created by liana on 4/19/17.
 */
public class SignInPageTest {
    private AppiumController appiumController;
    private SignInPage signInPage;
    @BeforeTest
    private void start(){
        appiumController = AppiumController.getInstance();
        appiumController.start();
        switch (AppiumController.executionOS){
            case ANDROID:
                signInPage = new SignInPageAndroid(appiumController.getDriver());
                break;
            case IOS:
                break;
        }
    }
    @AfterTest
    private void finish(){
        appiumController.stop();
    }
    @Test(dataProvider = "PTData_signIn", dataProviderClass = SignInPageData.class)
    public void validateSignInWorks(String email, String password){
        signInPage.signIn(email,password);
        Assert.assertTrue(isElementPresent(signInPage));
    }
    private boolean isElementPresent(MobileElement mobileElement){
        WebDriverWait wait = new WebDriverWait(appiumController.getDriver(),30);
        wait.until(ExpectedConditions.visibilityOf(mobileElement));
    }
}
