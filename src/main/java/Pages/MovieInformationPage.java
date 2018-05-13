package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Описание страницы информации о фильмы
 */
public class MovieInformationPage extends BasePageObject {
    @FindBy(xpath = ".//h1[@class = 'event-heading__title']")
    public WebElement title; // Заголовок, содержащий название фильма

    @FindBy(xpath = ".//span[@class = 'event-heading__place']")
    public WebElement theatersAmount; // Количество кинотеатров
}
