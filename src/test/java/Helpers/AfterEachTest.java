package Helpers;

import StepDefs.Background.BackgroundUtil;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

import static com.codeborne.selenide.Selenide.open;

public class AfterEachTest {
    @After
    public void closeWebDriver() {
        WebDriverRunner.getWebDriver().close();
    }

    }

