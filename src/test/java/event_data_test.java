import POM.Event_list;
import POM.Event_page_in_event_list;
import POM.MainPage;
import infra.driverWrapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class event_data_test {
    private driverWrapper driver;

    @Before
    public void before() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "5.1.1");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("appPackage",
                "com.claudivan.taskagenda");
        caps.setCapability("appActivity", "com.claudivan.taskagenda.Activities.MainActivity");
        driver = new driverWrapper("http://localhost:4723/wd/hub", caps);
    }
    @Test
    public void today_test_date(){

            MainPage mainPage = new MainPage(driver.getDriver());
            mainPage.getWeek().click_on_add_event();
            mainPage.getWeek().click_on_Today();
            ;
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, d MMM yyyy", Locale.US);
        String formattedDateTime = currentDateTime.format(formatter);

        Assert.assertEquals(mainPage.getWeek().getNew_event().get_date(),formattedDateTime);

    }
    @Test
    public void tomorrow_test_date(){

        MainPage mainPage = new MainPage(driver.getDriver());
        mainPage.getWeek().click_on_add_event();
        mainPage.getWeek().click_on_Tomorrow();

        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime Tomorrow = currentDateTime.plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, d MMM yyyy", Locale.US);
        String formattedDateTime = Tomorrow.format(formatter);
        System.out.println(formattedDateTime);
        Assert.assertEquals(mainPage.getWeek().getNew_event().get_date(),formattedDateTime);

    }

    @Test
    public void an_event_was_added_test(){

        MainPage mainPage = new MainPage(driver.getDriver());
        mainPage.getWeek().click_on_add_event();
        mainPage.getWeek().click_on_Today();
        mainPage.getWeek().getNew_event().send_event_name("appointment");
        mainPage.getWeek().getNew_event().send_Description("appointment with doctor");
        mainPage.getWeek().getNew_event().click_on_save();

    Assert.assertEquals(mainPage.getWeek().get_event_pending().getText(),"1 pending event");

    }
    @Test
    public void event_data_test(){
        String event_name="appointment";
        String Description="appointment with doctor";
        MainPage mainPage = new MainPage(driver.getDriver());
        mainPage.getWeek().click_on_add_event();
        mainPage.getWeek().click_on_Today();
        mainPage.getWeek().getNew_event().send_event_name(event_name);
        mainPage.getWeek().getNew_event().send_Description(Description);
        mainPage.getWeek().getNew_event().click_on_save();
        mainPage.getWeek().get_event_pending().click();
        Event_list eventList= new Event_list(driver.getDriver());
        eventList.click_on_event_in_event_list(event_name);
        Event_page_in_event_list page = new Event_page_in_event_list(driver.getDriver());

        Assert.assertEquals(page.getEvent_name().getText(),event_name);
        Assert.assertEquals(page.getEvent_description().getText(),Description);

    }
    @Test
    public void delete_event_test(){
        String event_name="appointment";
        String Description="appointment with doctor";
        MainPage mainPage = new MainPage(driver.getDriver());
        mainPage.getWeek().click_on_add_event();
        mainPage.getWeek().click_on_Today();
        mainPage.getWeek().getNew_event().send_event_name(event_name);
        mainPage.getWeek().getNew_event().send_Description(Description);
        mainPage.getWeek().getNew_event().click_on_save();
        mainPage.getWeek().get_event_pending().click();
        Event_list eventList= new Event_list(driver.getDriver());
        eventList.click_on_event_in_event_list(event_name);
        Event_page_in_event_list page = new Event_page_in_event_list(driver.getDriver());
        page.getDelete_event().click();
        page.click_yes_to_delete();
        eventList.click_navigation_back();
        Assert.assertEquals(mainPage.getWeek().get_event_pending().getText(),"No pending event");
//        Assert.assertEquals(page.getEvent_name().getText(),event_name);
//        Assert.assertEquals(page.getEvent_description().getText(),Description);


    }







}

