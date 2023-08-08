package com.automation;

import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WhenUser {
    @Managed
    WebDriver driver;

    @Test
    public void acceptAlert() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Text from alert: " + alert.getText());
        alert.accept();
    }

    @Test
    public void dismissAlert() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Text from alert: " + alert.getText());
        alert.accept();
    }

    @Test
    public void sendKeysToAlert() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Globant");
        alert.accept();
    }
}
