package qaclickacademy.Appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class LongPress extends BaseTest {
    @Test
    public void longPressGesture() {
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        longPressAction(element,2000);
        String menutext = driver.findElement(By.id("android:id/title")).getText();
        assertEquals(menutext, "Sample menu","Menu text mismatch");
        assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed()

        );
    }
}