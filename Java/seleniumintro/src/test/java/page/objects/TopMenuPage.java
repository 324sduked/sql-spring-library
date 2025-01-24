package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class TopMenuPage extends BasePage {
    @FindBy(css = "#MenuContent > a:nth-child(3)")
    private WebElement signInLink;

    @Step("Click on Sign In Link")
    public LoginPage clickOnSignInLink() {
        WaitForElement.waitUntiElementIsClickable(signInLink);
        signInLink.click();
        log().info("Clicked on Sign In link");
        return new LoginPage();
    }
}
