package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


/**
 * Описание страницы списка фильмов
 */
public class MoviesListPage extends BasePageObject {
    @FindBy(xpath = ".//div[contains(@class, 'content-rubric__header')]/h1")
    public WebElement title; // Заголовок страницы

    @FindBy(xpath = ".//div[@class='rubric-filters__date']//button")
    public WebElement chooseDateOptionButton; // Кнопка для выбора даты фильма

    @FindBy(xpath = ".//li[@class = 'list__item']//span[@class = 'presets-list__title']")
    public List<WebElement> dateOptions; // Опции выбора даты фильма

    @FindBy(xpath = ".//div[contains(@class, 'events-list__list')]/div[contains(@class, 'event')]")
    public List<WebElement> movies; // Список фильмов

    /**
     * Метод выбирает заданную дату показа фильма
     *
     * @param date Дата показа
     */
    public void selectDateOption(String date) {
        selectCollectionItem(date, dateOptions);
    }
}
