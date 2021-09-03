//package appium_java;
//
//import io.appium.java_client.android.AndroidDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.concurrent.TimeUnit;
//
//public class SetUp {
//    public AndroidDriver driver;
//    public LoginPage loginPage;
//    @BeforeMethod
//    public void setUp() throws MalformedURLException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("platformVersion", "9.0");
//        capabilities.setCapability("udid", "emulator-5554");
//        capabilities.setCapability("appPackage", "com.sevenmedia.powerList");
//        capabilities.setCapability("appActivity", "com.sevenmedia.powerList.MainActivity");
//
//        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    }
//
//    @AfterMethod
//    public void teardown() {
//        driver.quit();
//    }
//}
