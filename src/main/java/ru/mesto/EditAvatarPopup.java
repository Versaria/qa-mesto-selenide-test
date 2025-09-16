package ru.mesto;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Класс попапа редактирования аватара профиля.
 * Содержит методы для изменения ссылки на аватар пользователя.
 */
public class EditAvatarPopup {

    // Локаторы элементов попапа
    private final SelenideElement avatarLinkInput = $("#owner-avatar");
    private final SelenideElement saveButton = $x(".//form[@name='edit-avatar']/button[text()='Сохранить']");

    /**
     * Установка значения в поле ссылки на аватар
     * @param link - новая ссылка на изображение аватара
     * @return текущий объект попапа (для цепочки вызовов)
     */
    public EditAvatarPopup setAvatarLink(String link) {
        avatarLinkInput.shouldBe(Condition.visible).setValue(link);
        return this;
    }

    /**
     * Клик по кнопке сохранения изменений
     */
    public void clickSave() {
        saveButton.shouldBe(Condition.enabled).click();
    }
}