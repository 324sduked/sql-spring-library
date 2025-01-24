package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import page.objects.FooterPage;
import page.objects.LoginPage;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.AssertJUnit.assertTrue;

public class CorrectLoginTests extends TestBase {

    @TmsLink("ID-2")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Description("The goal of this test is to log in using proper username and password" +
            " and check if Dog Banner is displayed after")
    public void asUserLoginUsingValidLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);
        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUserNameField("j2ee")
                .typeIntoPasswordField("j2ee")
                .clickOnLogInButton()
                .assertThatDogBannerIsDisplayed();

    }

}

