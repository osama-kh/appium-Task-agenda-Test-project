package POM;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.concurrent.TimeUnit;

public class New_event extends BasePage{
    private MobileElement Event_name;
    private MobileElement Date;
    private MobileElement Description;
    private MobileElement Save;

    private String EVENT_NAME="com.claudivan.taskagenda:id/etTitulo";
    private String DATE="com.claudivan.taskagenda:id/btData";
    private String DESCRIPTION="com.claudivan.taskagenda:id/etDescricao";
    private String SAVE="com.claudivan.taskagenda:id/item_salvar";
    public New_event(AndroidDriver<MobileElement> driver) {
        super(driver);
        init();
    }

    @Override
    public void init() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Event_name = driver.findElementById(EVENT_NAME);
        Date = driver.findElementById(DATE);
        Description = driver.findElementById(DESCRIPTION);
        Save = driver.findElementById(SAVE);
    }

    public void send_event_name(String Text){
        Event_name.sendKeys(Text);
    }
    public String get_date(){
        System.out.println(Date.getText());
        return Date.getText();
    }
    public void send_Description(String Text){
Description.sendKeys(Text);
    }
    public void click_on_save(){
        Save.click();
    }



}
