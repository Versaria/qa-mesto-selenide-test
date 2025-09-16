package ru.mesto;

import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;

/**
 * Тест для проверки функционала изменения аватара профиля.
 * Соответствует Задаче 1 из 4.
 */
public class ChangeAvatarTest extends BaseTest {

    /**
     * Тест изменения аватара профиля
     * 1. Открывает страницу приложения
     * 2. Выполняет авторизацию
     * 3. Кликает по аватару
     * 4. Вводит новую ссылку на аватар
     * 5. Сохраняет изменения
     */
    @Test
    public void changeAvatar() {
        // Открытие страницы приложения
        open("https://qa-mesto.praktikum-services.ru/");

        // Создание экземпляра страницы авторизации и выполнение входа
        AuthorizationPage authPage = new AuthorizationPage();
        HomePage homePage = authPage.login("versaria.o@yandex.ru", "qaswef-ketped-3motKo");

        // Клик по аватару и изменение ссылки на изображение
        homePage.clickEditAvatar()
                .setAvatarLink("https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/avatarSelenide.png")
                .clickSave();
    }
}