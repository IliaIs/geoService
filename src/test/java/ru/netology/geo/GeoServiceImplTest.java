package ru.netology.geo;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    @Test
    void byIpRus() {
        GeoService geoService = new GeoServiceImpl();
        Location actual = geoService.byIp("172.");
        Location expected = new Location("Moscow", Country.RUSSIA, null, 0);
        assertThat(expected.getCity(), equalTo(actual.getCity()));
        assertThat(expected.getCountry(), equalTo(actual.getCountry()));
        assertThat(expected.getStreet(), equalTo(actual.getStreet()));
        assertThat(expected.getBuiling(), equalTo(actual.getBuiling()));
    }

    @Test
    void byIpUSA() {
        GeoService geoService = new GeoServiceImpl();
        Location actual = geoService.byIp("96.");
        Location expected = new Location("New York", Country.USA, null, 0);
        assertThat(expected.getCity(), equalTo(actual.getCity()));
        assertThat(expected.getCountry(), equalTo(actual.getCountry()));
        assertThat(expected.getStreet(), equalTo(actual.getStreet()));
        assertThat(expected.getBuiling(), equalTo(actual.getBuiling()));
    }

    @Test
    void byCoordinates() {
        GeoService geoService = new GeoServiceImpl();
        assertThrows(RuntimeException.class, () -> geoService.byCoordinates(1.1, 2.1));
    }
}