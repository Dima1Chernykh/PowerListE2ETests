package appium_java;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SignUpTest {
    public AndroidDriver driver;
    LoginPage loginPage = new LoginPage(driver);

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("appPackage", "com.sevenmedia.powerList");
        capabilities.setCapability("appActivity", "com.sevenmedia.powerList.MainActivity");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testSignUp() {
        if (!loginPage.buttonSignUpDisplayed()) {
            return;
        }
        loginPage.clickSignUp();
        loginPage.firstName.sendKeys(loginPage.generateRandomHexString(8));
        loginPage.lastName.sendKeys(loginPage.generateRandomHexString(8));
        loginPage.email.sendKeys(loginPage.generateRandomHexString(5) + "@gmail.com");
        loginPage.password.sendKeys(loginPage.generateRandomHexString(10));
        loginPage.buttonCreateAccount.click();
        MobileElement tourFirstWindow = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]");

        Assert.assertEquals("DOMINATE YOUR LIFE.", tourFirstWindow.getText(), "Sign in is not completed.");
    }
}
