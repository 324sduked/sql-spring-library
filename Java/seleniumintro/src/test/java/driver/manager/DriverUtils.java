package driver.manager;

import io.qameta.allure.Step;

import java.time.Duration;

public class DriverUtils {
    @Step("Maximizing browser window")

    public static void setInitialConfigurations() {
        DriverManager.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        DriverManager.getWebDriver().manage().window().maximize();
    }
    @Step("Navigating to URL: {pageUrl}")
    public static void navigateToPage(String pageUrl) {
        DriverManager.getWebDriver().navigate().to(pageUrl);
    }
}
