package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
//    Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";  /* падала ошибка в тесте, так как страница долго загружалась */
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void  shouldFindSelenideRepositoryAtTheTop() {

        // открыть главную страницу
        open("https://github.com/");
        // ввести в поле поиска selenide и нажать enter
        $(".header-search-button").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        // кликнуть на первый репозиторий из списка найденых
        $("a[href^=\"/selenide/selenide\"]").click();
        // проверка: заголовок selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));

        // ARRANGE
        // ACT
        // ACT
        // (ASSERT)
        // ACT
        // ASSERT

    }

}
