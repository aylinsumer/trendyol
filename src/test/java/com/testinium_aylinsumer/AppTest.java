package com.testinium_aylinsumer;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTest {
    public static WebDriver webDriver;
    @BeforeClass
    public static void setUp() {
        try {
            DesiredCapabilities capabilities =new DesiredCapabilities("chrome","95.0.4638.54", Platform.WIN10);
            if (System.getProperty("key") != null) {
                capabilities.setCapability("key", System.getProperty("key"));
                webDriver = new RemoteWebDriver(new URL("http://hub.testinium.io/wd/hub"), capabilities);
            }
            else {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                webDriver = new ChromeDriver();
                webDriver.get("https://www.trendyol.com/");
                webDriver.manage().window().maximize();
            }
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        webDriver.findElement(By.id("Group-38")).click();
    }
    @Before
    public void before(){
        String currentWindow = webDriver.getWindowHandle();
        Set<String> windowHandles = webDriver.getWindowHandles();
        for (String window : windowHandles) {
            if (!currentWindow.equals(window)) {
                webDriver.switchTo().window(window);
            }
        }
    }

    @Test
    public void a_loginTest() throws InterruptedException {
        webDriver.findElement(By.cssSelector("div.account-nav-item.user-login-container")).click();
        webDriver.findElement(By.id("login-email")).sendKeys("Useremail");
        webDriver.findElement(By.id("login-password-input")).sendKeys("Password"+ Keys.ENTER);
        Thread.sleep(5000);
    }
    @Test
    public void b_womanSectionTest(){
        webDriver.findElement(By.cssSelector("a[href='/butik/liste/1/kadin']")).click();
    }

    @Test
    public void c_searchButtonTest() throws InterruptedException {
        webDriver.findElement(By.cssSelector("input[type=text]")).sendKeys("kazak"+Keys.ENTER);
        Thread.sleep(3000);
    }

    @Test
    public void d_productSelectTest() throws InterruptedException {
        webDriver.findElement(By.xpath("//body")).click();
        Thread.sleep(3000);

        List<WebElement> products = webDriver.findElements(By.cssSelector("div>div.prdct-cntnr-wrppr>div"));
        products.get(9).click();
        Thread.sleep(3000);


    }

    @Test
    public void e_addFavoriteTest() throws InterruptedException {
        webDriver.findElement(By.cssSelector(".fv>i.i-heart")).click();
        Thread.sleep(3000);
    }

    @Test
    public void f_addBasketTest() throws InterruptedException {
         webDriver.findElement(By.cssSelector("button.add-to-basket")).click();
         Thread.sleep(3000);
         webDriver.findElement(By.cssSelector("a[href='/sepet']")).click();

    }

    /*
    @Test
    public void g_dropBasketTest(){
        webDriver.findElement(By.cssSelector(productSelected.getAccessibleName()));
    }



    @Test
    public void dropFavoriteTest(){

    }


     */

    @AfterClass
    public static void afterClass(){
        //webDriver.quit();
        System.out.println("Test page is closed.");
    }

}
