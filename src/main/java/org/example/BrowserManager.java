package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BrowserManager extends Utils {

    public static LoadProp loadProp = new LoadProp();
    URL url = null;
    public static final String browserName = loadProp.getProperty("browser");
   // public static final String browserName = System.getProperty("browser");
    //String browserName = "Chrome";
    boolean sauce = true;
    //boolean sauce = Boolean.parseBoolean(System.getProperty("sauce"));

    public void openBrowser() {
        if (sauce) {
            System.out.println("Running in sauce");
            if (browserName.equalsIgnoreCase("Chrome")) {
                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setPlatformName("Windows 11");
                browserOptions.setBrowserVersion("latest");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("username", "oauth-niyatisharma1510-5ca2a");
                sauceOptions.put("accessKey", "123793be-205f-4007-9f8f-9dbe50265ecb");
                sauceOptions.put("build", "<your build id>");
                sauceOptions.put("name", "<your test name>");
                browserOptions.setCapability("sauce:options", sauceOptions);

                try {
                    url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                driver = new RemoteWebDriver(url, browserOptions);

            } else if (browserName.equalsIgnoreCase("Edge")) {
                EdgeOptions browserOptions = new EdgeOptions();
                browserOptions.setPlatformName("Windows 11");
                browserOptions.setBrowserVersion("latest");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("username", "oauth-niyatisharma1510-5ca2a");
                sauceOptions.put("accessKey", "123793be-205f-4007-9f8f-9dbe50265ecb");
                sauceOptions.put("build", "<your build id>");
                sauceOptions.put("name", "<your test name>");
                browserOptions.setCapability("sauce:options", sauceOptions);

                try {
                    url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                driver = new RemoteWebDriver(url, browserOptions);

            } else if ((browserName.equalsIgnoreCase("gecko"))) {
                FirefoxOptions browserOptions = new FirefoxOptions();
                browserOptions.setPlatformName("Windows 11");
                browserOptions.setBrowserVersion("latest");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("username", "oauth-niyatisharma1510-5ca2a");
                sauceOptions.put("accessKey", "123793be-205f-4007-9f8f-9dbe50265ecb");
                sauceOptions.put("build", "<your build id>");
                sauceOptions.put("name", "<your test name>");
                browserOptions.setCapability("sauce:options", sauceOptions);

                try {
                    url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                driver = new RemoteWebDriver(url, browserOptions);
            } else {
                System.out.println("Your browser name is wrong or does not match" + browserName);
            }
        }
        else {
                System.out.println("Running in local");
                if (browserName.equalsIgnoreCase("Chrome")) {
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                    driver = new ChromeDriver();
                    System.out.println("This is chrome browser");
                } else if (browserName.equalsIgnoreCase("Edge")) {
                    System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
                    driver = new EdgeDriver();
                } else if (browserName.equalsIgnoreCase("gecko")) {
                    System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
                    driver = new FirefoxDriver();
                }

            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().window().maximize();
            driver.get("https://demo.nopcommerce.com/");
        }


    public void closeBrowser()
    {
        driver.quit();
    }
}

//    public void openBrowser() {
////        if (browserName.equalsIgnoreCase("Chrome")) {
////            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
////            driver = new ChromeDriver();
////            System.out.println("This is chrome browser");
////        } else if (browserName.equalsIgnoreCase("Edge")) {
////            System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
////            driver = new EdgeDriver();
////        } else if (browserName.equalsIgnoreCase("gecko")) {
////            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
////            driver = new FirefoxDriver();
////        }
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
////        driver.manage().window().maximize();
////        driver.get("https://www.rahulshettyacademy.com/");
////    }