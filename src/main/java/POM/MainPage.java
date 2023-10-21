package POM;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MainPage extends BasePage{
    //Locators
    private String SIDE_LIST="com.claudivan.taskagenda:id/hamburguer";



    private Calender calender;
    private week week;

    //Mobile elements
    private MobileElement Side_list;
    public MainPage(AndroidDriver<MobileElement> driver) {
        super(driver);
        init();
    }

    @Override
    public void init() {
        Side_list = driver.findElementById(SIDE_LIST);
        calender=new Calender(driver);
        week =new week(driver);
    }






    public Calender getCalender() {
        return calender;
    }

    public void setCalender(Calender calender) {
        this.calender = calender;
    }

    public POM.week getWeek() {
        return week;
    }

    public void setWeek(POM.week week) {
        this.week = week;
    }
}
