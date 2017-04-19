package Pages;

import AppiumSupport.AppiumController;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by liana on 4/19/17.
 */
public class SignInPageAndroid implements SignInPage{
    @FindBy(id = SignInPageAndroidID.EMAIL_FIELD)
    MobileElement emailField;
    @FindBy(id = SignInPageAndroidID.PASSWORD_FIELD)
    MobileElement passwordField;
    @FindBy(id = SignInPageAndroidID.SIGN_IN_BUTTON)
    public MobileElement signInButton;

    public SignInPageAndroid(AppiumDriver androidDriver){
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver),this);
    }
    public void signIn(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
    }
}
