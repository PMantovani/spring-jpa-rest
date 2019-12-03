package com.mantovani.springjparest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class CityControllerTest {

    @Mock
    CityRepository cityRepo;

    @BeforeEach
    void initialize() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void whenGetCitiesNoParam_thenCallFindAll() {
        CityController controller = new CityController(cityRepo);
        controller.getCities("");
        verify(cityRepo, times(1)).findAll();
    }

    @Test
    void whenGetCitiesWithParam_thenCallFindAll() {
        CityController controller = new CityController(cityRepo);
        controller.getCities("test");
        verify(cityRepo, times(1)).findCityByCountryNameContaining("test");
    }
}