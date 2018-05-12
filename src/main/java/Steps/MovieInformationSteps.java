package Steps;

import Pages.MovieInformationPage;
import Utils.Stash;
import io.qameta.allure.Step;
import org.junit.Assert;

public class MovieInformationSteps {
    @Step("название фильма на странице равно сохраненному")
    public void checkMovieNameSaved() {
        String expectedName = (String) Stash.getInstance().get(Stash.movieName);

        checkMovieName(expectedName);
    }

    @Step("ожидаемое название фильма - \"{0}\"")
    public void checkMovieName(String expectedName) {
        String actualName = new MovieInformationPage().title.getText();

        Assert.assertTrue(String.format
                        ("Заголовок равен [%s]. Ожидалось - [%s]", actualName, expectedName),
                actualName.toLowerCase().contains(expectedName));
    }

    @Step("количество кинотеатров на странице равно сохраненному")
    public void checkTheatersAmountSaved() {
        String expectedAmount = (String) Stash.getInstance().get(Stash.theatersAmount);

        checkTheatersAmount(expectedAmount);
    }

    @Step("ожидаемое количество кинотеатров на странице - {0}")
    public void checkTheatersAmount(String expectedAmount) {
        String actualAmount = new MovieInformationPage().theatersAmount.getText();

        Assert.assertTrue(String.format("Количество кинотеатров равно [%s]. Ожидалось - [%s]", actualAmount, expectedAmount),
                actualAmount.toLowerCase().contains(expectedAmount));
    }
}
