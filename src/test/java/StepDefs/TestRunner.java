package StepDefs;

import Helpers.GuerbetPropertyManager;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static com.codeborne.selenide.Configuration.*;
import static cucumber.api.SnippetType.*;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"pretty", "junit:target/TESTING.xml"},
        features = "src/test/java/Features",

        /* RUN some tests
            to run ALL tests : not use the tags option
            to run tests by SPRINT : use @Sprint tags
            to run just ONE test : use the TC tag
         */
        //tags ={"@Sprint0"},
        tags={"@TC_509"},
        glue = "StepDefs",
        snippets = UNDERSCORE)

public class TestRunner {
    @BeforeClass
    public static void setup()
    {
        Configuration.headless = true; // uncomment this line if you want to play test in background
        timeout = 4000;
        baseUrl = GuerbetPropertyManager.getInstance().getFrontURL();
        startMaximized = false;
        browser = "chrome";
        Configuration.reportsFolder = "target/surefire-reports";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }
}






