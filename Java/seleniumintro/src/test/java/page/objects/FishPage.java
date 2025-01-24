package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class FishPage extends BasePage {
    @FindBy(css = "#Catalog > table > tbody > tr:nth-child(2) > td:nth-child(1) > a")
    private WebElement angelFishId;

    public AngelFishPage clickOnAngelFishId(){
        WaitForElement.waitUntiElementIsClickable(angelFishId);
        angelFishId.click();
        return new AngelFishPage();
    }
}
