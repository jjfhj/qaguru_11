package com.github.jjfhj.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.github.jjfhj.tests.TestData.OZON_URL;

public class OzonTest extends TestBase {

    @ValueSource(strings = {"Всё о Муми-троллях. Книга 1", "Всё о Муми-троллях. Книга 2"})
    @DisplayName("Результаты поиска")
    @Tag("Blocker")
    @Tag("High")
    @Tag("Web")
    @ParameterizedTest(name = "Отображение товара {0} в результатах поиска")
    void checkingBookInSearchResults(String searchQuery) {
        open(OZON_URL);
        $("[name='text']").setValue("Всё о Муми-троллях").submit();
        $$("[class='b3a6 a3m3']").shouldHave(texts(searchQuery));
    }

    @CsvSource({
            "Мягкая обложка, Обложка: Мягкая обложка",
            "Твердый переплет, Обложка: Твердый переплет"
    })
    @DisplayName("Теги фильтра 'Обложка'")
    @Tag("Minor")
    @Tag("Low")
    @Tag("Web")
    @ParameterizedTest(name = "Отображение тега {0}")
    void checkingDisplayOfCoverFilterTag(String filterСheckbox, String tagName) {
        open(OZON_URL);
        $("[name='text']").setValue("Вторая жизнь Уве").submit();
        $$(".ui-D6").findBy(text(filterСheckbox)).click();
        $("[class='ui-l5 ui-l6']").shouldHave(text(tagName));
    }
}
