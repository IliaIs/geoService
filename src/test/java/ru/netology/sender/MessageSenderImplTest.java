package ru.netology.sender;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MessageSenderImplTest {

    @Test
    void sendRus() {
        GeoService geoService = mock(GeoServiceImpl.class);
        when(geoService.byIp(matches("172.")))
                .thenReturn(new Location(
                        "Moscow", Country.RUSSIA, "Lenina", 15));
        LocalizationService localizationService = mock(LocalizationServiceImpl.class);
        when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
        messageSender.send(headers);
        String expected = "Добро пожаловать";
        String actual = messageSender.send(headers);
        assertEquals(expected, actual);
    }

    @Test
    void sendEng() {
        GeoService geoService = mock(GeoServiceImpl.class);
        when(geoService.byIp(matches("96.")))
                .thenReturn(new Location(
                        "New York", Country.USA, null, 0));
        LocalizationService localizationService = mock(LocalizationServiceImpl.class);
        when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");
        messageSender.send(headers);
        String expected = "Welcome";
        String actual = messageSender.send(headers);
        assertEquals(expected, actual);
    }
}