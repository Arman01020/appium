package qaclickacademy.Appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class DrugDropDemo extends BaseTest {
    @Test
    public void drugDropTest() throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement firstCircle = driver.findElement(By.xpath("(//android.view.View)[1]"));
        drugAndDropAction(firstCircle,830,730);
        String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
        assertNotNull(result);
        assertEquals(result, "Dropped!");
    }
}