package Tests;

import org.testng.annotations.DataProvider;

/**
 * Created by liana on 4/19/17.
 */
public class SignInPageData {
    @DataProvider(name = "PTData_signIn")
    public static Object[][] PTData() {
        return new Object[][]{
                {"aaa","aaa"},
        };
    }
    @DataProvider(name = "NTData_signIn")
    public static Object[][] NTData() {
        return new Object[][]{

        };
    }
}
