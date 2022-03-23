package Utils;

import Pages.LoginPage;

public class Login extends BeforeAfterTests {

    private static String configFile = "config.properties";

    public static void validLoginUser() {

            LoginPage.getUsername().sendKeys(ReadFileData.readFile(configFile, "USER"));
            LoginPage.getPassword().sendKeys(ReadFileData.readFile(configFile, "PASSWORD"));
            LoginPage.getLoginButton().click();
        }
}

