package Pages;

import Steps.BaseSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Описание главной страницы Яндекс
 */
public class MainPage extends BasePageObject {

    @FindBy(xpath = ".//div[@class = 'afisha']/h1/a")
    public WebElement playbillButton; // Кнопка перехода в раздел "Афиша"

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
}
