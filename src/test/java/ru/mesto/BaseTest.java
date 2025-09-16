package ru.mesto;

import com.codeborne.selenide.Configuration;
import org.junit.Before;

/**
 * Базовый класс для всех тестов.
 * Содержит общие настройки для тестового окружения.
 * Все тестовые классы наследуются от этого класса.
 */
public class BaseTest {

    /**
     * Метод настройки тестового окружения перед каждым тестом
     */
    @Before
    public void setUp() {
        // Установка таймаута для ожиданий элементов
        Configuration.timeout = 10000;
        // Указание браузера для тестов
        Configuration.browser = "chrome";
        // Установка размера окна браузера
        Configuration.browserSize = "1280x800";
        // Режим без графического интерфейса (false - с графическим интерфейсом)
        Configuration.headless = false;
    }
}