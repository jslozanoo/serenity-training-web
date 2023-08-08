package com.automation;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenUserLogin {

    @Managed
    WebDriver driver;

    @Test
    public void withValidCredentials() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElements(By.cssSelector("ul li")).get(0).click();
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        assertThat(driver.findElement(By.id("flash")).isDisplayed()).isTrue();
    }

    @Test
    public void withInvalidCredentials() {
        driver.get("http://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("globant");
        driver.findElement(By.id("password")).sendKeys("globant");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        assertThat(driver.findElement(By.cssSelector("div[class='flash error']")).isDisplayed()).isTrue();
        System.out.println("Error message: " + driver.findElement(By.cssSelector("div[class='flash error']")).getText());
        assertThat(driver.findElement(By.cssSelector("div[class='flash error']")).getText()).isEqualTo("Your username is invalid!");
    }
}
