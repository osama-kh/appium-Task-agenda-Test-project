package POM;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class week extends BasePage{


    private String ADD_EVENT="com.claudivan.taskagenda:id/btNovoEvento";
    private String TODAY="new UiSelector().textContains(\"Today\")";
    private String TOMORROW="new UiSelector().textContains(\"Tomorrow\")";
    private String OTHER="new UiSelector().textContains(\"Other\")";
    private String EVENT_PENDING="com.claudivan.taskagenda:id/btEventosSemana";
    private MobileElement add_event;
    private MobileElement Today;
    private MobileElement Tomorrow;
    private MobileElement Other;
    private MobileElement event_pending;


    private New_event new_event;
    public week(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public void init() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated
//                (By.id(ADD_EVENT)));

        Other = driver.findElementByAndroidUIAutomator(OTHER);
    }

    public void click_on_add_event(){
        add_event = driver.findElementById(ADD_EVENT);
        add_event.click();
    }

    public void click_on_Today(){
    wait_func(new MobileBy.ByAndroidUIAutomator(TODAY));
        Today = driver.findElementByAndroidUIAutomator(TODAY);
        Today.click();
        new_event = new New_event(driver);

    }
    public void click_on_Tomorrow(){
        wait_func(new MobileBy.ByAndroidUIAutomator(TOMORROW));
        Tomorrow = driver.findElementByAndroidUIAutomator(TOMORROW);
        Tomorrow.click();
        new_event = new New_event(driver);

    }
    public void click_on_Other(){
        Other.click();

    }

    public MobileElement get_event_pending(){
//        wait_func(new );
        event_pending = driver.findElementById(EVENT_PENDING);
        return event_pending;

    }


    public New_event getNew_event() {
        return new_event;
    }

    public void setNew_event(New_event new_event) {
        this.new_event = new_event;
    }



}
