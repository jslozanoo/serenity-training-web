package com.automation;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenUserInteractsWithIFrame {

    @Managed
    WebDriver driver;

    @Test
    public void andChangeImage() {
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        //driver.switchTo().frame("frame");
        driver.findElement(By.cssSelector("a.right")).click();
        driver.findElement(By.cssSelector("a.right")).click();
        driver.findElement(By.cssSelector("a.right")).click();
        //driver.switchTo().defaultContent();
    }
}
