package org.example;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.security.Key;
import java.sql.Driver;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation extends BaseTest {



    @Step("<time> saniye bekle")
    public void waitTime(int time) throws InterruptedException {
        Thread.sleep(1000* time);
    }

    @Step("<Key> İd'li elemente tıkla")
       public void clickElementById(String Key){
        appiumDriver.findElement(By.id(Key)).click();
        System.out.println(Key+"Elementine tıklandı");
    }
    @Step("<Key> xpathli elemente tıkla" )
    public void clickElementByXpath(String Key){
        appiumDriver.findElement(By.xpath(Key)).click();
        System.out.println(Key + "Elemente tıklandı");
    }

    @Step("<Key> id değeri ile Alışveriş Sayfasının Açıldığı Doğrulanır")
    public void isDisplayedId(String Key){
        String display = appiumDriver.findElement(By.xpath(Key)).getText().trim();
        Assert.assertEquals("yanlış değer",display,Key);

    }
    @Step("<Key> xpath değeri ile Alışveriş Sayfasının Açıldığı Doğrulanır")
        public void isDisplayedXpath(String Key){
        String display = appiumDriver.findElement(By.xpath(Key)).getText().trim();
        Assert.assertEquals("yanlış değer",display,Key);

    }
    @Step("<Key> id li elemente <keywordc> değerini yaz")
    public void SendkeyElementByxpath(String Key,String keywordc) {
        appiumDriver.findElement(By.id(Key)).sendKeys(keywordc);
        System.out.println(Key + "Elenitine tıklandı");
    }

    @Step("Sayfaya  Scroll yapılır")
    public void ScrollDown() {
        Dimension dimension = appiumDriver.manage().window().getSize();
        int start_x = (int) (dimension.width * 0.5);
        int start_y = (int) (dimension.height * 0.8);

        int end_x = (int) (dimension.width * 0.2);
        int end_y = (int) (dimension.height * 0.2);

        TouchAction touch = new TouchAction(appiumDriver);
        touch.press(PointOption.point(start_x,start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x,end_y)).release().perform();
    }
    @Step("Rastgele Ürün Seçilir")
    public MobileElement randomProduct(){
        List<MobileElement> elements = appiumDriver.findElements(By.id("com.ozdilek.ozdilekteyim:id/textView"));
        Random rnd = new Random();
        int rndInt = rnd.nextInt(elements.size());
        elements.get(rndInt).click();
        return elements.get(rndInt);
    }





    }
