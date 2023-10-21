package POM;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Event_list extends BasePage{
    String Event;
    String NAVIGATION_BACK="//android.widget.ImageButton[@content-desc=\"Navigate up\"]";
    MobileElement event;
    MobileElement navigation_back;
    public Event_list(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public void init()  {

    }
public void click_on_event_in_event_list(String event_name){
    Event="new UiSelector().textContains(\""+event_name+"\")";
    wait_func(new MobileBy.ByAndroidUIAutomator(Event));
    event = driver.findElementByAndroidUIAutomator(Event);
    event.click();

    }
    public void click_navigation_back(){
        navigation_back = driver.findElementByXPath(NAVIGATION_BACK);
        navigation_back.click();

    }


}
