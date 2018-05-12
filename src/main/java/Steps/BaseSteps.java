package Steps;

import Utils.TestProperties;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Описание базовых шагов теста
 */
public class BaseSteps {
    protected static WebDriver driver;
    protected static String baseUrl;
    public static Properties properties = TestProperties.getInstance().getProperties();

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public static void setUp() {
        switch (properties.getProperty("browser")) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
        }

        baseUrl = properties.getProperty("app.url");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @After
    public static void tearDown() {
        driver.quit();
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * Метод закрывает всплывающие элементы
     */
    public static void closePopup() {
        // Закрытие окна с подпиской по email-у
        try {
            WebElement popUpCloseButton = driver.findElement(By.xpath
                    (".//button[contains(@class, 'subscribe-form-email__button_type_close')]"));

            if ((popUpCloseButton != null) && (popUpCloseButton.isDisplayed()))
                popUpCloseButton.click();
        } catch (Exception e) {
            System.out.println("No popup here");
        }

        // Закрытие окна с еще какой-то рекламой
        try {
            WebElement infoCloseButton = driver.findElement(By.xpath
                    (".//div[@class = 'tutorial-modal__close']"));
            if ((infoCloseButton != null) && (infoCloseButton.isDisplayed()))
                infoCloseButton.click();
        } catch (Exception e) {
            System.out.println("No popup here");
        }
    }
}
