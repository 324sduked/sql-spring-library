package initialcoursetests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.*;

public class WebElementsTest {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl/test/hover_mouse.html");
    }
    @Test
    public void hoverOverAndClickAndHoldTest() {


        WebElement smileyIcon = driver.findElement(By.id("smiley"));

        Actions action = new Actions(driver);

        action.moveToElement(smileyIcon).click().build().perform();

        sleep();

        Actions secondAction = new Actions(driver);
        WebElement smileyIcon2 = driver.findElement(By.id("smiley2"));

        secondAction.clickAndHold(smileyIcon2).build().perform();

        sleep();
    }

    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void afterTest() {
        //driver.close();
        driver.quit();
    }
}

