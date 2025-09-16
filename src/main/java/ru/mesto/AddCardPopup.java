package ru.mesto;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Класс попапа добавления новой карточки.
 * Содержит методы для заполнения данных новой карточки и её сохранения.
 */
public class AddCardPopup {

    // Локаторы элементов попапа
    private final SelenideElement nameInput = $("[name='name']");
    private final SelenideElement linkInput = $("[name='link']");
    private final SelenideElement saveButton = $x(".//form[@name='new-card']/button[text()='Сохранить']");

    /**
     * Установка значения в поле названия карточки
     * @param name - название карточки
     * @return текущий объект попапа (для цепочки вызовов)
     */
    public AddCardPopup setName(String name) {
        nameInput.shouldBe(Condition.visible).setValue(name);
        return this;
    }

    /**
     * Установка значения в поле ссылки на изображение
     * @param link - ссылка на изображение для карточки
     * @return текущий объект попапа (для цепочки вызовов)
     */
    public AddCardPopup setLink(String link) {
        linkInput.shouldBe(Condition.visible).setValue(link);
        return this;
    }

    /**
     * Клик по кнопке сохранения карточки
     */
    public void clickSave() {
        saveButton.shouldBe(Condition.enabled).click();
    }
}