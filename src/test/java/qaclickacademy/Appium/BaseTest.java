package qaclickacademy.Appium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeMethod
    public void ConfigureAppium() throws MalformedURLException {
        service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//User//AppData//Roaming//npm//node_modules//appium//build//lib//main.js")).
                withIPAddress("0.0.0.0").usingPort(4723).build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
//        options.setDeviceName("Pixel 2 XL API 34");
        options.setDeviceName("Pixel_3a_API_34_extension_level_7_x86_64");
//        options.setApp("C://Users//User//seleniumTraining//Appium//src//test//java//resources//ApiDemos-debug.apk");
        options.setApp("C://Users//User//seleniumTraining//Appium//src//test//java//resources//General-Store.apk");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void longPressAction(WebElement ele, int duration) {
        //https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", duration));

    }
    public void scrollToEndAction(){
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0));
        }while (canScrollMore);
    }
    public void swipeAction(WebElement element, String diraction){
//Java https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)element).getId(),
                "direction", diraction,
                "percent", 0.75
        ));
    }
    public void drugAndDropAction(WebElement element, int endX, int endY){
//Java https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", endX,
                "endY", endY
        ));
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
        service.stop();
    }
}
