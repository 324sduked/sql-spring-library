package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class AngelFishPage {
    private Logger logger = LogManager.getLogger(AngelFishPage.class);
    public AngelFishPage() {

        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @FindBy(css = "#Catalog > table > tbody > tr:nth-child(3) > td:nth-child(5) > a")
    private WebElement smallAngelFishAddToCart;

    public ShoppingCartPage clickOnAddSmallAngelFishToCart() {
        WaitForElement.waitUntiElementIsClickable(smallAngelFishAddToCart);
        smallAngelFishAddToCart.click();
        logger.info("Clicked on small angel fish add to cart");
        return  new ShoppingCartPage();
    }
}
