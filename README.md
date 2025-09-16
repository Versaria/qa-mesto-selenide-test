# QA Mesto Selenide Test Project 🏙

![License](https://img.shields.io/badge/License-MIT-yellow.svg)
![Java](https://img.shields.io/badge/Java-11-blue)
![Maven](https://img.shields.io/badge/Maven-3.9+-orange)
![Selenide](https://img.shields.io/badge/Selenide-6.12-green)
![JUnit](https://img.shields.io/badge/JUnit-4-red)
![Coverage](https://img.shields.io/badge/Coverage-100%25-brightgreen)

Проект автоматизированного тестирования для [Mesto](https://qa-mesto.praktikum-services.ru/) с использованием Selenide и Java. Проект включает комплексные тесты для проверки функциональности профиля пользователя и управления контентом с применением паттерна Page Object.

## 🚀 Быстрый старт

### Требования
- **Java JDK 11+** (рекомендуется Zulu 11.0.27+)
- **Apache Maven 3.9+**
- **Google Chrome** (версия 139+)
- **ChromeDriver** (версия 139.0.7258.68+)

### Установка и запуск
```bash
# Клонирование репозитория
git clone <repository-url>
cd qa-mesto-selenide-test
# Запуск тестов
mvn clean test
# Генерация отчета о покрытии
mvn jacoco:report
```

## 📂 Структура проекта
```
qa-mesto-selenide-test/
├── src/main/java/ru/mesto/
│   ├── AuthorizationPage.java      # Страница авторизации
│   ├── HomePage.java               # Главная страница
│   ├── EditProfilePopup.java       # Попап редактирования профиля
│   ├── EditAvatarPopup.java        # Попап редактирования аватара
│   └── AddCardPopup.java           # Попап добавления карточки
├── src/test/java/ru/mesto/
│   ├── BaseTest.java               # Базовый класс для тестов
│   ├── ChangeAvatarTest.java       # Тест изменения аватара
│   ├── AddDeleteCardTest.java      # Тест добавления/удаления карточек
│   ├── EditProfileTest.java        # Тест редактирования профиля
│   └── GetCardTextTest.java        # Тест получения текста карточки
├── target/site/jacoco/             # Отчет о покрытии тестами
├── pom.xml                         # Конфигурация Maven
├── LICENSE
├── README.md
└── .gitignore
```

## 📋 Функционал

### 1. Авторизация в системе
- Ввод email и пароля
- Нажатие кнопки входа
- Автоматический переход на главную страницу

### 2. Управление профилем
- Изменение аватара пользователя
- Редактирование имени и описания профиля
- Сохранение изменений

### 3. Управление контентом
- Добавление новых карточек с изображениями
- Удаление существующих карточек
- Получение информации о карточках

### 4. Поиск элементов
- Поиск по ID, классу, CSS-селекторам
- Поиск по XPath с использованием атрибутов
- Работа с коллекциями элементов

## 📊 Покрытие тестами
Проект включает комплексные тесты с 100% покрытием кода:

**Результаты тестирования:**
- ✅ Tests run: 5
- ✅ Failures: 0
- ✅ Errors: 0
- ✅ Skipped: 0
- ✅ Code Coverage: 100%

**Запуск тестов с проверкой покрытия:**
```bash
mvn clean test jacoco:report
```
Отчет о покрытии генерируется в директории `target/site/jacoco/index.html`

## 💻 Пример работы
```java
// Авторизация в системе
AuthorizationPage authPage = new AuthorizationPage();
HomePage homePage = authPage.login("email@example.com", "password");

// Изменение аватара профиля
homePage.clickEditAvatar()
        .setAvatarLink("https://example.com/avatar.png")
        .clickSave();

// Редактирование профиля
homePage.clickEditProfile()
        .setName("Аристарх Сократович")
        .setDescription("Автор автотестов")
        .clickSave();

// Добавление и удаление карточки
homePage.clickAddCard()
        .setName("Москва")
        .setLink("https://example.com/photo.jpg")
        .clickSave();

// Получение текста карточки
String cardText = homePage.getCard(1).find(byClassName("card__title")).getText();
```

## 📜 Лицензия
MIT License

## 🤝 Как внести вклад
1. Форкните репозиторий
2. Создайте ветку (`git checkout -b feature/improvement`)
3. Сделайте коммит (`git commit -am 'Add new feature'`)
4. Запушьте ветку (`git push origin feature/improvement`)
5. Откройте Pull Request

---

<details>
<summary>🔧 Дополнительные команды</summary>

```bash
# Запуск конкретного тестового класса
mvn test -Dtest=ChangeAvatarTest

# Запуск тестов с детальным логированием
mvn test -Dselenide.log.level=DEBUG

# Пропуск тестов при сборке
mvn clean package -DskipTests
```
</details>