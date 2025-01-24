package initialcoursetests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class ExplicitWaitTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://theinternet.przyklady.javastart.pl/dynamic_controls");
    }

    @Test
    public void waitForDisappearingElement() {
        WebElement checkBox = driver.findElement(By.cssSelector("#checkbox > input[type=checkbox]"));
        assertFalse(checkBox.isSelected());
        assertTrue(checkBox.isDisplayed());
        WebElement removeButton = driver.findElement(By.cssSelector("#checkbox-example > button"));
        removeButton.click();
//        WebElement massage = driver.findElement(By.id("message"));
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("message")));
        WebElement addButton = driver.findElement(By.cssSelector("#checkbox-example > button"));
        addButton.click();

        WebDriverWait webDriverWait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#checkbox")));
        assertFalse(driver.findElement(By.cssSelector("#checkbox")).isSelected());
        assertTrue(driver.findElement(By.cssSelector("#checkbox")).isDisplayed());

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


