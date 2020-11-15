package hotel.tests.util;

import hotel.entities.Feature;
import hotel.entities.Room;
import hotel.util.PriceCalculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

class PriceCalculatorTests {

    private static Room room;
    private static List<Feature> features;

    @BeforeAll
    static void setup(){
        room = new Room();

        features = new ArrayList<>();
        Feature feature = new Feature("HUI", 50);

        features.add(feature);
    }

    @Test
    void priceCalculationCorrect(){
        room.setPrice(50);

        double actual = PriceCalculator.getPrice(room, features);
        double expected = 100;

        assertEquals(expected, actual);
    }

    @Test
    void priceCalculationFailedWithNegativePrice(){
        room.setPrice(-1999);

        double actual = PriceCalculator.getPrice(room, features);
        double expected = -1;

        assertEquals(expected, actual);
    }
}
