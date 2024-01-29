package ru.netology.i18n;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    @Test
    void localeRus() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        String actual = localizationService.locale(Country.RUSSIA);
        String expected = "Добро пожаловать";
        assertEquals(expected, actual);
    }

    @Test
    void localeEng() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        String actual = localizationService.locale(Country.USA);
        String expected = "Welcome";
        assertEquals(expected, actual);
    }
}