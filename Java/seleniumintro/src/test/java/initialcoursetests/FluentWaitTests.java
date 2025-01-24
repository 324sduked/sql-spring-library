package initialcoursetests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class FluentWaitTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://theinternet.przyklady.javastart.pl/dynamic_loading/1");
    }

    @Test
    public void fluentWaitTest() {
        WebElement helloWorld = driver.findElement(By.cssSelector("#finish"));
        assertFalse(helloWorld.isDisplayed());
        WebElement startButton = driver.findElement(By.cssSelector("#start > button"));
        startButton.click();
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        fluentWait.withTimeout(Duration.ofSeconds(7));
        fluentWait.pollingEvery(Duration.ofMillis(250));
        fluentWait.ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOf(helloWorld));
        assertTrue(helloWorld.isDisplayed());


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


