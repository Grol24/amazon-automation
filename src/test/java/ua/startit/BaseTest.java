package ua.startit;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import ua.startit.support.Properties;

public class BaseTest {


    private Properties properties = Properties.getInstance();

    private static  final Logger LOG = LoggerFactory.getLogger(BaseTest.class);

    @BeforeSuite(alwaysRun = true)
    public void setEnv() {
        Configuration.browser = properties.getBrowser();
        Configuration.timeout = 10000;
        Configuration.baseUrl = properties.getEnv();
        Configuration.headless = Boolean.parseBoolean(properties.getHeadless());

        LOG.info("Browser: " + properties.getBrowser());
        LOG.info("Env: " + properties.getEnv());
        LOG.info("Headless is: " + properties.getHeadless());

    }

    @BeforeMethod(alwaysRun = true)
    public void openHomePage() {
        Selenide.open("/");
    }

//    @AfterMethod(alwaysRun = true)
//    public void closeBrowser() {
//        Selenide.close();
//    }
}
