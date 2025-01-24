package tests;

import driver.manager.DriverUtils;
import org.testng.annotations.Test;
import page.objects.*;

import static navigation.ApplicationURLs.MENU_URL;
import static org.testng.AssertJUnit.assertEquals;

public class SignOnFirstMessageTests extends TestBase {
    @Test
    public void signOnFirstBeforeAttemptingToCheckout() {
        DriverUtils.navigateToPage(MENU_URL);
        MiddleMenuPage middleMenuPage = new MiddleMenuPage();
        LoginPage loginPage = middleMenuPage
                .clickOnFishLink()
                .clickOnAngelFishId()
                .clickOnAddSmallAngelFishToCart()
                .clickOnProceedToCheckoutButton()
                .assertThatWarningIsDisplayed("You must sign on before attempting to check out. Please sign on and try checking out again.");
    }
}
