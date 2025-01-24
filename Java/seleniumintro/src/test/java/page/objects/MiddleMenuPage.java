package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class MiddleMenuPage extends  BasePage{
    @FindBy(css = "#SidebarContent > a:nth-child(1)")
    private WebElement fishLink;

    public FishPage clickOnFishLink() {
        WaitForElement.waitUntiElementIsClickable(fishLink);
        fishLink.click();
        log().info("Clicked On Fish link");
        return new FishPage();
    }
}
