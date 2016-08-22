package org.fundacionjala.sfdc.framework.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class initialize the Chrome Selenium Web Driver
 *
 * @author Henrry Salinas.
 */
public class Chrome implements IDriver {

    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";

    private static final String DRIVER_PATH = "drivers/chromedriver.exe";

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver initDriver() {
        System.setProperty(WEBDRIVER_CHROME_DRIVER, DRIVER_PATH);
        return new ChromeDriver();
    }
}
