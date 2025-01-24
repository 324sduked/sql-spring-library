package initialcoursetests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class FileUploadTest {
    private WebDriver driver;
    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://theinternet.przyklady.javastart.pl/upload");
    }
    @Test
    public void fileUploadTest() {
        WebElement testFile = driver.findElement(By.id("file-upload"));
        testFile.sendKeys("C:\\testfile/testfile.txt");
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
        WebElement uploadedTestFile = driver.findElement(By.id("uploaded-files"));
        assertEquals(uploadedTestFile.getText(), "testfile.txt");


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


