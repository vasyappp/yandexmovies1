package Steps;

import Pages.MainPage;
import io.qameta.allure.Step;

public class MainPageSteps {

    @Step("выполнен переход на страницу Афиша")
    public void goToPlaybillPage() {
        new MainPage().playbillButton.click();
    }
}
