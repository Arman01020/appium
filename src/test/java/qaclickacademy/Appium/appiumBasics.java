package qaclickacademy.Appium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class appiumBasics extends BaseTest {
    @Test
    public void WifiSettingsName() {
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
        driver.findElement(By.className("android.widget.CheckBox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alertText = driver.findElement(By.id("android:id/alertTitle")).getText();
        assertEquals(alertText,"WiFi settings", "Alert text not matching");
        driver.findElement(By.id("android:id/edit")).sendKeys("Tesvan");
        driver.findElements(By.className("android.widget.Button")).get(1).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

    }
}
