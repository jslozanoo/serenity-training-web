package com.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageObject {

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    @FindBy(id = "flash")
    private WebElement successfulSignInMessage;

    @FindBy(css = "div[class='flash error']")
    private WebElement notSuccessfulSignIMessage;

    public void openLoginPage() {
        getDriver().get("http://the-internet.herokuapp.com/login");
    }

    public void loginWithUsernameAndPassword(String username, String password) {
        typeInto(usernameInput, username);
        typeInto(passwordInput, password);
        clickOn(loginButton);
    }

    public boolean isLoginSuccessful() {
        return successfulSignInMessage.isDisplayed();
    }

    public boolean isLoginUnsuccessful() {
        return notSuccessfulSignIMessage.isDisplayed();
    }

    public String getLoginNotSuccessfulMessage() {
        return notSuccessfulSignIMessage.getText();
    }
}
