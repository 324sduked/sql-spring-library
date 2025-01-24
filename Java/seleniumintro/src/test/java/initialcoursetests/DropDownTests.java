package initialcoursetests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class DropDownTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://theinternet.przyklady.javastart.pl/dropdown");
    }

    @Test
    public void dropDownTest() {

        WebElement options = driver.findElement(By.id("dropdown"));
        Select dropDownOptions = new Select(options);
        assertEquals(dropDownOptions.getFirstSelectedOption().getText(), "Please select an option");
        sleep();
        dropDownOptions.selectByValue("1");
        assertEquals(dropDownOptions.getFirstSelectedOption().getText(), "Option 1");
        sleep();
        dropDownOptions.selectByValue("2");
        assertEquals(dropDownOptions.getFirstSelectedOption().getText(), "Option 2");
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



