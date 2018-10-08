package hotel.util;

import hotel.entities.Feature;
import hotel.entities.Room;

import java.util.List;

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
