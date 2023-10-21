package POM;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Event_page_in_event_list extends BasePage{

    private String EVENT_NAME ="com.claudivan.taskagenda:id/tvTitulo";
    private String EVENT_DESCRIPTION ="com.claudivan.taskagenda:id/tvDescricao";
    private String DELETE_EVENT="com.claudivan.taskagenda:id/item_excluir";
    private String YES_TO_DELETE="new UiSelector().textContains(\"YES\")";

    private MobileElement event_name;
    private MobileElement event_description;
    private MobileElement yes_to_delete;


    private MobileElement delete_event;
    public Event_page_in_event_list(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public void init() throws InterruptedException {

    }

    public MobileElement getEvent_name() {
//        wait_func(new MobileBy.ByAndroidUIAutomator(EVENT_NAME));
        event_name = driver.findElementById(EVENT_NAME);
        return event_name;
    }

    public MobileElement getEvent_description() {
//        wait_func(new MobileBy.ByAndroidUIAutomator(EVENT_DESCRIPTION));
        event_description = driver.findElementById(EVENT_DESCRIPTION);
        return event_description;
    }
    public MobileElement getDelete_event() {
        delete_event = driver.findElementById(DELETE_EVENT);
        return delete_event;
    }
    public void click_yes_to_delete(){
        wait_func(new MobileBy.ByAndroidUIAutomator(YES_TO_DELETE));
        yes_to_delete= driver.findElementByAndroidUIAutomator(YES_TO_DELETE);
        yes_to_delete.click();
    }



}
