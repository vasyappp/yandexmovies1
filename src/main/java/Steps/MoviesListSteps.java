package Steps;

import Pages.MoviesListPage;
import Utils.Stash;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MoviesListSteps {
    private List<WebElement> filteredMovies;

    @Step("заголовок страницы фильмов равен {0}")
    public void checkPageTitle(String expectedTitle) {
        String actualTitle = new MoviesListPage().title.getText();

        Assert.assertTrue(String.format
                ("Заголовок равен [%s]. Ожидалось - [%s]", actualTitle, expectedTitle),
                actualTitle.contains(expectedTitle));
    }

    @Step("выбрана дата {0}")
    public void chooseDate(String date) {
        MoviesListPage moviesListPage = new MoviesListPage();

        moviesListPage.chooseDateOptionButton.click();
        moviesListPage.selectDateOption(date);
    }

    private Double getRating(WebElement element) {
        WebElement ratingField = element.findElement(By.xpath
                (".//div[@class = 'event-rating__value']"));

        return Double.parseDouble(ratingField.getText());
    }

    @Step("найдены фильмы с рейтингом {0} {1}")
    public void findMoviesByRating(String comparison, Double rating) {
        comparison = comparison.toLowerCase();
        List<WebElement> movies = new MoviesListPage().movies;

        BaseSteps.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        switch (comparison) {
            case "больше или равно":
                filteredMovies = movies.stream()
                        .filter(f ->
                        { try {
                            return getRating(f) >= rating;
                        } catch (Exception e) {return false;} })
                        .collect(Collectors.toList());
                break;
            case "больше":
                filteredMovies = movies.stream()
                        .filter(f ->
                        { try {
                            return getRating(f) > rating;
                        } catch (Exception e) {return false;} })
                        .collect(Collectors.toList());
                break;
            case "равно":
                filteredMovies = movies.stream()
                        .filter(f ->
                        { try {
                            return getRating(f).equals(rating);
                        } catch (Exception e) {return false;} })
                        .collect(Collectors.toList());
                break;
            case "меньше или равно":
                filteredMovies = movies.stream()
                        .filter(f ->
                        { try {
                            return getRating(f) <= rating;
                        } catch (Exception e) {return false;} })
                        .collect(Collectors.toList());
                break;
            case "меньше":
                filteredMovies = movies.stream()
                        .filter(f ->
                        { try {
                            return getRating(f) < rating;
                        } catch (Exception e) {return false;} })
                        .collect(Collectors.toList());
                break;
            default:
                Assert.fail("Неправильный оператор сравнения рейтинга");
        }

        BaseSteps.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        if (filteredMovies.isEmpty())
            Assert.fail("Не найдены фильмы с рейтингом " + comparison + " " + rating);
    }

    @Step("запомнены название и количество кинотеатров фильма с заданными параметрами и порядковым номером {0}")
    public void saveInformation(int index) {

        if (filteredMovies == null) {
            Assert.fail("Не найдены фильмы с заданными параметрами");
        } else if (index > filteredMovies.size()) {
            Assert.fail("Фильмов найдено меньше, чем " + index);
        } else {
            WebElement movie = filteredMovies.get(index - 1);

            String movieName = movie.findElement(By.xpath
                    (".//h2[@class = 'event__name']")).getText();

            String theatersAmount = movie.findElement(By.xpath
                    (".//span[@class = 'event__place-name']")).getText();

            Stash.getInstance().put(Stash.choosenFilteredMovie, movie);
            Stash.getInstance().put(Stash.movieName, movieName.toLowerCase());
            Stash.getInstance().put(Stash.theatersAmount, theatersAmount.toLowerCase());
        }
    }

    @Step("нажат выбранный фильм")
    public void goToChoosenFilm() {
        ((WebElement) Stash.getInstance().get(Stash.choosenFilteredMovie)).click();
    }
}
