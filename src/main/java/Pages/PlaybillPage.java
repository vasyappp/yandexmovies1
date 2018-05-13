package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Описание страницы раздела Афиша
 */
public class PlaybillPage extends BasePageObject {

    @FindBy(xpath = ".//ul[@role = 'menu']/li/a")
    private List<WebElement> menuPlaybillOptions; // Меню выбора вида мероприятий

    /**
     * Метод выбирает заданный вид мероприятия
     *
     * @param optionName Вид мероприятия
     */
    public void selectMenuPlaybillOption(String optionName) {
        selectCollectionItem(optionName, menuPlaybillOptions);
    }
}
