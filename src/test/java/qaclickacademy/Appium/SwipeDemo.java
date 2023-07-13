package qaclickacademy.Appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class SwipeDemo extends BaseTest {
    @Test
    public void swipeDemoTest() {
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Photos']")).click();
        WebElement firstPhoto = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
        System.out.println(firstPhoto.getAttribute("focusable"));
        assertEquals(firstPhoto.getAttribute("focusable"), "true");
        swipeAction(firstPhoto, "left");
        assertEquals(firstPhoto.getAttribute("focusable"), "false");

    }
}