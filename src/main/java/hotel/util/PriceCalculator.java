package hotel.util;

import hotel.entities.Feature;
import hotel.entities.Room;

import java.util.List;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

public class PriceCalculator {
    public static double getPrice(Room room, List<Feature> features) {

        double price = room.getPrice();

        if (price < 0) {
            return -1;
        }

        for (Feature feature : features) {
            price += feature.getPrice();
        }

        return price;
    }
}
