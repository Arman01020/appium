package qaclickacademy.Appium.ecomers;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import qaclickacademy.Appium.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;


public class eComerce_TC_01 extends BaseTest {
//    @Test
    public void fillForm() throws InterruptedException {
driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Arman");
    driver.hideKeyboard();
    driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Belgium\"));")).click();
        driver.findElement(By.className("android.widget.Button")).click();

    }
    @Test
    public void toast() throws InterruptedException {
        driver.findElement(By.className("android.widget.Button")).click();
        String toastMessage =driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
        System.out.println(toastMessage);
        assertEquals(toastMessage,"Please enter your name","Error message validation");
        Thread.sleep(5000);

    }
    @Test
    public void addProductToCart() throws InterruptedException {
        fillForm();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Jordan 6 Rings']/parent::android.widget.LinearLayout/(android.widget.LinearLayout)[4]"))
        Thread.sleep(5000);

    }
}