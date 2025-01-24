package page.objects;

import driver.manager.DriverManager;
import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import waits.WaitForElement;

public class LoginPage extends  BasePage {
    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "signon")
    private WebElement LogInButton;

    @FindBy(className = "messages")
    private WebElement messageLabel;
    @Step("Type into User Name Field {username}")
    public LoginPage typeIntoUserNameField(String username) {
        WaitForElement.waitUntiElementIsClickable(usernameField);
        usernameField.clear();
        usernameField.sendKeys(username);
        log().info("Typed into username field {}" + username);
        return  this;
    }
    @Step("Type into Password Field {password}")
    public LoginPage typeIntoPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        log().info("Typed into password field {}" + password);
        return  this;
    }
    @Step("Click on Login Button")
    public FooterPage clickOnLogInButton() {
        WaitForElement.waitUntiElementIsClickable(LogInButton);
        LogInButton.click();
        log().info("CLicked On Log In Button");
        return new FooterPage();
    }
    @Step("Assert that warning message {warningMessage} is displayed")
    public LoginPage assertThatWarningIsDisplayed(String warningMessage) {
        log().info("Checking if warning message {} is displayed", warningMessage);
        WaitForElement.waitUntiElementIsVisible(messageLabel);
        AssertWebElement.assertThat(messageLabel).isDisplayed().hasText(warningMessage);
        return this;
    }
}
