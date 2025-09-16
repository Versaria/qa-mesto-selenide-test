package ru.mesto;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Класс попапа редактирования профиля.
 * Содержит методы для изменения имени и описания профиля пользователя.
 */
public class EditProfilePopup {

    // Локаторы элементов попапа
    private final SelenideElement nameInput = $("#owner-name");
    private final SelenideElement descriptionInput = $("#owner-description");
    private final SelenideElement saveButton = $x(".//form[@name='edit']/button[text()='Сохранить']");

    /**
     * Установка значения в поле имени
     * @param name - новое имя пользователя
     * @return текущий объект попапа (для цепочки вызовов)
     */
    public EditProfilePopup setName(String name) {
        nameInput.shouldBe(Condition.visible).setValue(name);
        return this;
    }

    /**
     * Установка значения в поле описания
     * @param description - новое описание пользователя
     * @return текущий объект попапа (для цепочки вызовов)
     */
    public EditProfilePopup setDescription(String description) {
        descriptionInput.shouldBe(Condition.visible).setValue(description);
        return this;
    }

    /**
     * Клик по кнопке сохранения изменений
     */
    public void clickSave() {
        saveButton.shouldBe(Condition.enabled).click();
    }
}