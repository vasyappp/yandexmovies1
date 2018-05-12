package Pages;

import Steps.BaseSteps;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


/**
 * Описание базовой страницы
 */
public class BasePageObject {

    public BasePageObject() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    /**
     * Метод заполняет поле указанными данными
     *
     * @param field Поле для заполнения
     * @param value Данные для ввода
     */
    public void fillField(WebElement field, String value) {
        field.clear();
        field.sendKeys(value);
    }

    /**
     * Выбирает элемент с указанным текстом из группы элементов
     *
     * @param itemName Текст, содержащийся в элементе
     * @param collection Группа элементов
     */
    public void selectCollectionItem(String itemName, List<WebElement> collection){
        for (WebElement item : collection ){
            if (item.getText().equalsIgnoreCase(itemName)){
                item.click();
                return;
            }
        }
        Assert.fail("Не найден элмент коллекции - " + itemName);
    }

    /**
     * Метод ожидает появления элемента на странице заданное время
     *
     * @param element Элемент для ожидания
     * @param time Время ожидания
     */
    public void waitVisibility(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), time);

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Метод ождилает появления элемента стандартное (для теста) времяэ
     *
     * @param element Элемент для ожидания
     */
    public void waitVisibility(WebElement element) {
        waitVisibility(element, 10);
    }
}
