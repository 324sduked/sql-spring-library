package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ShoppingCartPage {
    private Logger logger = LogManager.getLogManager().getLogger("");

    public ShoppingCartPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @FindBy(css = "#Cart > a")
    private WebElement proceedToCheckoutButton;

    public LoginPage clickOnProceedToCheckoutButton() {
        WaitForElement.waitUntiElementIsClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        logger.info("Clicked on check out button");
        return new LoginPage();
    }
}
