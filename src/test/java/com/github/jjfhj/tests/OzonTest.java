package com.github.jjfhj.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.github.jjfhj.TestData.OZON_URL;
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

    @EnumSource(ProfileMenu.class)
    @DisplayName("Пункты меню неавторизованного пользователя")
    @Tag("Blocker")
    @Tag("High")
    @Tag("Web")
    @ParameterizedTest(name = "Отображение пункта меню {0}")
    void checkingDisplayOfAnonymousMenuItem(ProfileMenu profileMenu) {
        open(OZON_URL);
        $(".g5j6").shouldHave(text(profileMenu.getProfileMenu()));
    }

    @MethodSource("com.github.jjfhj.CatalogItems#productCategories")
    @DisplayName("Подкатегории на страницах товарных категорий")
    @Tag("Minor")
    @Tag("Low")
    @Tag("Web")
    @ParameterizedTest(name = "Отображение подкатегорий на странице товарной категории {0}")
    void checkingProductCategoriesInCatalog(String catalogItems, List<String> goodsCategories) {
        open(OZON_URL);
        refresh(); // Для закрытия модального окна "Выбирайте лучшее!", альтернативными методами не получилось решить
        $$(".ui-e6").findBy(text("Каталог")).click();
        $$(".g5r1").findBy(text(catalogItems)).$(".g5s7").click();
        $$(".cw2").shouldHave(texts(goodsCategories));
    }
}
