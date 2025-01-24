package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import page.objects.LoginPage;

import static navigation.ApplicationURLs.LOGIN_URL;

public class FailedLoginTests extends TestBase {
    @Issue("DEFECT-1")
    @TmsLink("ID-1")
    @Severity(SeverityLevel.NORMAL)
    @Test
    @Description("The goal of this test is to log in using not proper username and password" +
            " and check if warning message Invalid username or password is displayed")
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUserNameField("randomBullShit")
                .typeIntoPasswordField("RandomBullShit")
                .clickOnLogInButton();
        loginPage
                .assertThatWarningIsDisplayed("Invalid username or password. Signon failed.");
    }

}