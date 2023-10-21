package infra;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class driverWrapper {
    public AndroidDriver<MobileElement> getDriver() {
        return driver;
    }

    public void setDriver(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    AndroidDriver<MobileElement> driver;
    public driverWrapper(String url, DesiredCapabilities caps) throws MalformedURLException {
        driver = new AndroidDriver<>(new URL(url), caps);


    }

}
