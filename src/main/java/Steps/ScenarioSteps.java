package Steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.Когда;

public class ScenarioSteps {
    MainPageSteps mainPageSteps = new MainPageSteps();
    PlaybillSteps playbillSteps = new PlaybillSteps();
    MoviesListSteps moviesListSteps = new MoviesListSteps();
    MovieInformationSteps movieInformationSteps = new MovieInformationSteps();

    @Когда("^выполнен переход на страницу Афиша$")
    public void goToPlaybillPage() {
        mainPageSteps.goToPlaybillPage();
    }

    @When("^выбран пункт меню \"(.+)\"$")
    public void selectPlaybillOption(String option) {
        playbillSteps.selectPlaybillOption(option);
    }

    @Then("^заголовок страницы фильмов равен \"(.+)\"$")
    public void checkListTitle(String title) {
        moviesListSteps.checkPageTitle(title);
    }

    @When("^выбрана дата \"(.+)\"$")
    public void chooseDate(String date) {
        moviesListSteps.chooseDate(date);
    }

    @When("^выбраны фильмы с рейтингом:$")
    public void chooseRating(DataTable parameters) {
        parameters.asMap(String.class, Double.class)
                .forEach((comparison, rating) -> moviesListSteps.findMoviesByRating(comparison, rating));
    }

    @When("^запомнено имя и количество кинотеатров фильма с порядковым номером \"(.+)\"$")
    public void saveInformation(int index) {
        moviesListSteps.saveInformation(index);
    }

    @When("^выбран фильм$")
    public void goToMovieInfo() {
        moviesListSteps.goToChoosenFilm();
    }

    @Then("^информация на странице соответствует сохраненной$")
    public void checkInfo() {
        movieInformationSteps.checkMovieNameSaved();
        movieInformationSteps.checkTheatersAmountSaved();
    }
}
