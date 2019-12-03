package com.mantovani.springjparest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Sql({"/schema.sql", "/data.sql"})
class CountryControllerIntegrationTest {

    @Autowired
    private CountryRepository countryRepo;

    @Test
    void whenPostCityIncrementsList() {
        CountryController controller = new CountryController(countryRepo);
        Country argentina = new Country("Argentina");
        controller.addCountry(argentina);

        Iterator iterAfterInsert = controller.getCountries().iterator();
        int finalCounter = 0;
        while (iterAfterInsert.hasNext()) {
            finalCounter++;
            iterAfterInsert.next();
        }

        assertEquals(4, finalCounter);
    }
}