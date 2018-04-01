package Actions;

import Models.Car;
import Map.Map;

import java.util.Random;

public class CarsSimulation {
    public static void simulation(Map map, Car carTest, int carFactor){

        String l;
        int x;
        Random generate = new Random();
        do {
            x = generate.nextInt(4);
            if (x == 0)
                l = "w";
            else if (x == 1)
                l = "a";
            else if (x == 2)
                l = "s";
            else
                l = "d";
        }
        while (!map.sample(carTest.position, l));

        map.tab[carTest.position.getY()][carTest.position.getX()] -= carFactor;
        ChangePosition.move(carTest.position, l);
        map.tab[carTest.position.getY()][carTest.position.getX()] += carFactor;



    }
}
