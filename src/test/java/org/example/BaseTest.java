package org.example;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.openqa.selenium.devtools.v85.page.Page.captureScreenshot;

public class BaseTest extends BrowserManager {
    @BeforeMethod
    public void setUp() {
        openBrowser();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!(result.isSuccess())) {
            captureScreenshot(result.getName());
        }
        closeBrowser();
    }

}
