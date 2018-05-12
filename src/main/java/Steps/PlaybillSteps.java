package Steps;

import Pages.PlaybillPage;
import io.qameta.allure.Step;

public class PlaybillSteps {

    @Step("выбран пункт меню {0}")
    public void selectPlaybillOption(String optionName) {
        BaseSteps.closePopup();

        new PlaybillPage().selectMenuPlaybillOption(optionName);
    }
}
