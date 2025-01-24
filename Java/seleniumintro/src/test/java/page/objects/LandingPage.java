package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class LandingPage extends BasePage  {

    @FindBy(css = "#Content > p:nth-child(2) > a")
    private WebElement enterTheStoreButton;
    @Step("Click on Enter Store link")
    public TopMenuPage clickOnEnterStoreLink() {
        WaitForElement.waitUntiElementIsClickable(enterTheStoreButton);
        enterTheStoreButton.click();
        log().info("Clicked on Enter Store link");
        return new TopMenuPage();
    }
}
