package qaclickacademy.Appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class MisciallanousAppiumActions extends BaseTest {
    @Test
    public void miscellaneous() throws InterruptedException {
        // adb shell dumpsys window | find "mCurrentFocus"  for windows
        // adb shell dumpsys window | grep -E  "mCurrentFocus"  for Mac

        driver.startActivity(new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies"));  // Start the desired activity

//        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
        driver.findElement(By.className("android.widget.CheckBox")).click();
        DeviceRotation landScape;
//        landScape = new DeviceRotation(0,0,90);
//        driver.rotate(landScape);
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String alertText = driver.findElement(By.id("android:id/alertTitle")).getText();
        assertEquals(alertText,"WiFi settings", "Alert text not matching");
        driver.setClipboardText("Tesvan");
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        Thread.sleep(3000);
        driver.pressKey(new KeyEvent((AndroidKey.ENTER)));
        driver.findElements(By.className("android.widget.Button")).get(1).click();
        driver.pressKey(new KeyEvent((AndroidKey.BACK)));
        Thread.sleep(3000);

        driver.pressKey(new KeyEvent((AndroidKey.HOME)));
        Thread.sleep(3000);

//        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
    }
}