import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests extends TestBase {

    @Test
    void successfulDragAndDropTest() {

        // Открыть https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");

        // Проверить, что прямоугольник A на своём месте
        $("#column-a").shouldHave(text("A"));

        // Перенести прямоугольник А на место В
        actions().dragAndDrop($("#column-a"), $("#column-b")).perform();

        sleep(3000);

        // Проверить, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B"));

        // В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест, если использовать её вместо actions()
        $("#column-a").dragAndDrop(to($("#column-b")));

        // Проверить, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("A"));
    }
}
