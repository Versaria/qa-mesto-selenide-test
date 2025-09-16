package ru.mesto;

import com.codeborne.selenide.Condition;
import org.junit.Test;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

/**
 * Тест для проверки функционала добавления и удаления карточки.
 * Соответствует Задаче 2 из 4.
 */
public class AddDeleteCardTest extends BaseTest {

    /**
     * Тест добавления и удаления карточки
     * 1. Открывает страницу приложения
     * 2. Выполняет авторизацию
     * 3. Добавляет новую карточку
     * 4. Удаляет добавленную карточку
     */
    @Test
    public void addAndDeleteCard() {
        // Открытие страницы приложения
        open("https://qa-mesto.praktikum-services.ru/");

        // Создание экземпляра страницы авторизации и выполнение входа
        AuthorizationPage authPage = new AuthorizationPage();
        HomePage homePage = authPage.login("versaria.o@yandex.ru", "qaswef-ketped-3motKo");

        // Генерация уникального имени для карточки
        String cardName = "Москва " + System.currentTimeMillis();

        // Добавление новой карточки
        homePage.clickAddCard()
                .setName(cardName)
                .setLink("https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/photoSelenide.jpg")
                .clickSave();

        // Ожидание появления карточки с нашим именем
        $x("//li[contains(@class, 'card')][.//h2[contains(text(), '" + cardName + "')]]")
                .shouldBe(Condition.visible, Duration.ofSeconds(10));

        // Наведение на карточку для отображения кнопки удаления
        $x("//li[contains(@class, 'card')][.//h2[contains(text(), '" + cardName + "')]]").hover();

        // Удаление карточки с помощью XPath из задания
        $(byXpath(".//button[@class='card__delete-button card__delete-button_visible']")).click();

        // Ожидание исчезновения карточки
        $x("//li[contains(@class, 'card')][.//h2[contains(text(), '" + cardName + "')]]")
                .shouldNot(Condition.exist, Duration.ofSeconds(10));
    }
}