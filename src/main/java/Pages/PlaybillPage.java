package Pages;

import Steps.BaseSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Описание страницы раздела Афиша
 */
public class PlaybillPage extends BasePageObject {

    @FindBy(xpath = ".//ul[@role = 'menu']/li/a")
    private List<WebElement> menuPlaybillOptions; // Меню выбора вида мероприятий

    public PlaybillPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    /**
     * Метод выбирает заданный вид мероприятия
     *
     * @param optionName Вид мероприятия
     */
    public void selectMenuPlaybillOption(String optionName) {
        selectCollectionItem(optionName, menuPlaybillOptions);
    }
}
