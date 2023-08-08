package com.automation;

import com.automation.pages.LoginPage;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenUserLogin {

    LoginPage loginPage;

    @Test
    public void withValidCredentials() {
        loginPage.openLoginPage();
        loginPage.loginWithUsernameAndPassword("tomsmith", "SuperSecretPassword!");
        assertThat(loginPage.isLoginSuccessful()).isTrue();
    }

    @Test
    public void withInvalidCredentials() {
        loginPage.openLoginPage();
        loginPage.loginWithUsernameAndPassword("globant", "globant");
        assertThat(loginPage.isLoginUnsuccessful()).isTrue();
        System.out.println("Error message: " + loginPage.getLoginNotSuccessfulMessage());
        assertThat(loginPage.getLoginNotSuccessfulMessage()).contains("Your username is invalid!");
    }
}
