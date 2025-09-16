package ru.mesto;

import com.codeborne.selenide.CollectionCondition;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.byClassName;
import static org.junit.Assert.assertFalse;

/**
 * Тест для проверки функционала получения текста карточки.
 * Соответствует Задаче 4 из 4.
 */
public class GetCardTextTest extends BaseTest {

    /**
     * Тест получения текста второй карточки
     * 1. Открывает страницу приложения
     * 2. Выполняет авторизацию
     * 3. Проверяет наличие минимум двух карточек
     * 4. Получает текст второй карточки
     * 5. Проверяет, что текст не пустой
     */
    @Test
    public void getSecondCardText() {
        // Открытие страницы приложения
        open("https://qa-mesto.praktikum-services.ru/");

        // Создание экземпляра страницы авторизации и выполнение входа
        AuthorizationPage authPage = new AuthorizationPage();
        HomePage homePage = authPage.login("versaria.o@yandex.ru", "qaswef-ketped-3motKo");

        // Ожидание загрузки минимум двух карточек
        homePage.getCards().shouldHave(CollectionCondition.sizeGreaterThanOrEqual(2));

        // Получение текста второй карточки
        String cardText = homePage.getCard(1).find(byClassName("card__title")).getText();
        // Проверка, что текст карточки не пустой
        assertFalse("Card text should not be empty", cardText.isEmpty());
    }
}