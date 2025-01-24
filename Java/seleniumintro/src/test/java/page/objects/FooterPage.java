package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import static generic.assertions.AssertWebElement.assertThat;

public class FooterPage extends BasePage {
    @FindBy(css = "#Banner")
    private WebElement bannerAfterLoggingIn;

    @Step("Assert that element dog banner is displayed")
    public FooterPage assertThatDogBannerIsDisplayed() {
        log().info("Checking if dog banner is displayed");
        WaitForElement.waitUntiElementIsVisible(bannerAfterLoggingIn);
        assertThat(bannerAfterLoggingIn).isDisplayed();
        return this;
    }
}
