import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GithubPagesTests extends TestBase {
    @Test
    void successfulEnterprisePageOpen() {

        // открыть главную страницу
        open("https://github.com/");

        // выбрать меню Solutions с помощью команды hover для Solutions
        $$(".HeaderMenu-link").filterBy(text("Solutions")).first().hover();

        // перейти на старницу Enterprize
        $("a[href='/enterprise']").click();

        // убедиться, что загрузилась нужная страница
        $("#hero-section-brand-heading")
                .shouldHave(text("The AI-powered\n" +
                                                "developer platform."))
                .shouldBe(visible);
    }
}
