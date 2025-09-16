package ru.mesto;

import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;

/**
 * Тест для проверки функционала редактирования профиля.
 * Соответствует Задаче 3 из 4.
 * Содержит два теста: изменение имени и изменение описания профиля.
 */
public class EditProfileTest extends BaseTest {

    /**
     * Тест изменения имени профиля
     * 1. Открывает страницу приложения
     * 2. Выполняет авторизацию
     * 3. Открывает попап редактирования профиля
     * 4. Изменяет имя
     * 5. Сохраняет изменения
     */
    @Test
    public void editProfileName() {
        // Открытие страницы приложения
        open("https://qa-mesto.praktikum-services.ru/");

        // Создание экземпляра страницы авторизации и выполнение входа
        AuthorizationPage authPage = new AuthorizationPage();
        HomePage homePage = authPage.login("versaria.o@yandex.ru", "qaswef-ketped-3motKo");

        // Редактирование имени профиля
        homePage.clickEditProfile()
                .setName("Аристарх Сократович")
                .clickSave();
    }

    /**
     * Тест изменения описания профиля
     * 1. Открывает страницу приложения
     * 2. Выполняет авторизацию
     * 3. Открывает попап редактирования профиля
     * 4. Изменяет описание
     * 5. Сохраняет изменения
     */
    @Test
    public void editProfileDescription() {
        // Открытие страницы приложения
        open("https://qa-mesto.praktikum-services.ru/");

        // Создание экземпляра страницы авторизации и выполнение входа
        AuthorizationPage authPage = new AuthorizationPage();
        HomePage homePage = authPage.login("versaria.o@yandex.ru", "qaswef-ketped-3motKo");

        // Редактирование описания профиля
        homePage.clickEditProfile()
                .setDescription("Автор автотестов")
                .clickSave();
    }
}