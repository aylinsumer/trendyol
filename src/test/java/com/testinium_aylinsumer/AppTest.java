package com.testinium_aylinsumer;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTest extends TestBase {

    @Test
    public void a_loginTest() throws InterruptedException {
        webDriver.findElement(By.cssSelector("div.account-nav-item.user-login-container")).click();
        webDriver.findElement(By.id("login-email")).sendKeys("aylin.sumer@hotmail.com");
        webDriver.findElement(By.id("login-password-input")).sendKeys("aylinmorea1"+ Keys.ENTER);
        Thread.sleep(3000);
    }
    @Test
    public void b_womanSectionTest(){
        webDriver.findElement(By.cssSelector("a[href='/butik/liste/1/kadin']")).click();
    }

    @Test
    public void c_searchButtonTest() throws InterruptedException {
        webDriver.findElement(By.cssSelector("input[type=text]")).sendKeys("kazak"+Keys.ENTER);
        Thread.sleep(5000);
    }

    @Test
    public void d_productSelectTest() throws InterruptedException {
        Actions actions=new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(By.cssSelector("body"))).contextClick();
//        webDriver.findElement(By.xpath("//body")).click();
        Thread.sleep(3000);
        List<WebElement> products = webDriver.findElements(By.cssSelector("div>div.prdct-cntnr-wrppr>div"));
        products.get(9).click();
        Thread.sleep(3000);
    }

    @Test
    public void e_addFavoriteTest() throws InterruptedException {

        webDriver.findElement(By.cssSelector(".fv>.i-heart")).click();
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


}
