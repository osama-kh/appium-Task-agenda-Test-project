package POM;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    AndroidDriver<MobileElement> driver;

public BasePage(AndroidDriver<MobileElement> driver){
    this.driver=driver;
}
public abstract void init() throws InterruptedException;
    public void wait_func(MobileBy locator){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (locator));

    }
}



//    DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("platformName", "Android");
//                caps.setCapability("platformVersion", "13");
//                caps.setCapability("deviceName", "RF8R51CN95V");
////        com.sec.android.app.popupcalculator.Calculator
//                caps.setCapability("appPackage",
//                "com.sec.android.app.popupcalculator");
//                caps.setCapability("appActivity", ".Calculator");
//
//                AndroidDriver<MobileElement> driver =
//        new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);