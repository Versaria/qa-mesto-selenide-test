package ru.mesto;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

/**
 * Класс домашней страницы приложения.
 * Содержит элементы управления и методы для взаимодействия с основными компонентами:
 * - кнопка редактирования профиля
 * - кнопка добавления карточки
 * - аватар профиля
 * - коллекция карточек
 */
public class HomePage {

    // Локаторы элементов страницы
    private final SelenideElement profileEditButton = $(".profile__edit-button");
    private final SelenideElement profileAddButton = $(".profile__add-button");
    private final SelenideElement profileImage = $(".profile__image");

    /**
     * Клик по кнопке редактирования профиля
     * @return объект попапа редактирования профиля
     */
    public EditProfilePopup clickEditProfile() {
        profileEditButton.shouldBe(Condition.enabled).click();
        return page(EditProfilePopup.class);
    }

    /**
     * Клик по кнопке добавления новой карточки
     * @return объект попапа добавления карточки
     */
    public AddCardPopup clickAddCard() {
        profileAddButton.shouldBe(Condition.enabled).click();
        return page(AddCardPopup.class);
    }

    /**
     * Клик по аватару профиля
     * @return объект попапа редактирования аватара
     */
    public EditAvatarPopup clickEditAvatar() {
        profileImage.shouldBe(Condition.enabled).click();
        return page(EditAvatarPopup.class);
    }

    /**
     * Получение коллекции всех карточек на странице
     * @return коллекция элементов карточек
     */
    public ElementsCollection getCards() {
        return $$(".places__item.card");
    }

    /**
     * Получение конкретной карточки по индексу
     * @param index - индекс карточки в коллекции (начинается с 0)
     * @return элемент карточки
     */
    public SelenideElement getCard(int index) {
        return getCards().get(index);
    }
}