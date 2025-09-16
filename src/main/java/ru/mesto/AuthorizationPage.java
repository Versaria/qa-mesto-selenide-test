package ru.mesto;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Класс страницы авторизации.
 * Отвечает за процесс входа пользователя в систему.
 * Содержит методы для заполнения полей email и password и выполнения входа.
 */
public class AuthorizationPage {

    /**
     * Выполняет авторизацию пользователя
     * @param email - электронная почта пользователя
     * @param password - пароль пользователя
     * @return объект домашней страницы после успешной авторизации
     */
    public HomePage login(String email, String password) {
        // Заполнение поля email с проверкой видимости элемента
        $("#email").shouldBe(Condition.visible).setValue(email);
        // Заполнение поля password с проверкой видимости элемента
        $("#password").shouldBe(Condition.visible).setValue(password);
        // Клик по кнопке авторизации с проверкой активности элемента
        $(".auth-form__button").shouldBe(Condition.enabled).click();
        // Возврат экземпляра домашней страницы
        return page(HomePage.class);
    }
}