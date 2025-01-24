package initialcoursetests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

import static org.testng.AssertJUnit.assertEquals;

public class HoverTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://theinternet.przyklady.javastart.pl/hovers");
    }

    @Test
    public void hoverTest() {
        WebElement user1 = driver.findElement(By.cssSelector("#content > div > div:nth-child(3)"));
        WebElement user2 = driver.findElement(By.cssSelector("#content > div > div:nth-child(4)"));
        WebElement user3 = driver.findElement(By.cssSelector("#content > div > div:nth-child(5)"));
        WebElement user1Caption = driver.findElement(By.cssSelector("#content > div > div:nth-child(3) > div > h5"));
        WebElement user2Caption = driver.findElement(By.cssSelector("#content > div > div:nth-child(4) > div > h5"));
        WebElement user3Caption = driver.findElement(By.cssSelector("#content > div > div:nth-child(5) > div > h5"));

        Actions action = new Actions(driver);

        action.moveToElement(user1).perform();

        assertEquals(user1Caption.getText(), "name: user1");
        assertEquals(user2Caption.getText(), "");
        assertEquals(user3Caption.getText(), "");

        action.moveToElement(user2).perform();

        assertEquals(user1Caption.getText(), "");
        assertEquals(user2Caption.getText(), "name: user2");
        assertEquals(user3Caption.getText(), "");

        action.moveToElement(user3).perform();

        assertEquals(user1Caption.getText(), "");
        assertEquals(user2Caption.getText(), "");
        assertEquals(user3Caption.getText(), "name: user3");


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

