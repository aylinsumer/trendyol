package com.testinium_aylinsumer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

public class TestBase {
    public static WebDriver webDriver;

    @BeforeClass
    public static void beforeClass(){
        System.out.println("\nTest has started!");
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("start-maximized");
        webDriver =new ChromeDriver(options);
        webDriver.get("https://www.trendyol.com");
        webDriver.findElement(By.id("Group-38")).click();

    }
    @Before
    public void before() {
        String currentWindow = webDriver.getWindowHandle();
        Set<String> windowHandles = webDriver.getWindowHandles();
        for (String window : windowHandles) {
            if (!currentWindow.equals(window)) {
                webDriver.switchTo().window(window);
                //switch sayesinde açılan yeni window okunabilir oluyor.
            }
        }
    }

    @AfterClass
    public static void afterClass(){
        //webDriver.quit();
        System.out.println("Test page is closed.");
    }

}
