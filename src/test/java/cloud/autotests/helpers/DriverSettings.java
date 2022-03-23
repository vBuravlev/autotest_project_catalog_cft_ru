package cloud.autotests.helpers;

import cloud.autotests.config.Project;
import com.codeborne.selenide.Configuration;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class DriverSettings {

    public static void configure() {
        Configuration.browser = Project.config.browser();
        Configuration.browserVersion = Project.config.browserVersion();
        Configuration.browserSize = Project.config.browserSize();
        Configuration.timeout = Project.config.timeout();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        if ((Project.config.browser()).equals("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-infobars");
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--lang=en-en");
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            if (Project.isWebMobile()) { // for chrome only
                Map<String, Object> mobileDevice = new HashMap<>();
                mobileDevice.put("deviceName", Project.config.browserMobileView());
                chromeOptions.setExperimentalOption("mobileEmulation", mobileDevice);
            }
        } else if ((Project.config.browser()).equals("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--fast-start");
            firefoxOptions.addArguments("--enable-logging");
            firefoxOptions.addArguments("--ignore-certificate-errors");
            firefoxOptions.addArguments("--disable-gpu");
            capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
        } else if ((Project.config.browser()).equals("opera")) {
            OperaOptions operaOptions = new OperaOptions();
            operaOptions.addArguments("--disable-gpu");
            capabilities.setCapability(OperaOptions.CAPABILITY, operaOptions);
        }

        if (Project.isRemoteWebDriver()) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = Project.config.remoteDriverUrl();
        }
        Configuration.browserCapabilities = capabilities;

    }
}
