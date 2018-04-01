package Main;

import java.util.List;
import Models.*;
import Map.*;
import Actions.*;
import IO.*;

public class MainController {

    public static void run(String l, Car car, List<Car> list, Position position1, Map map, int carFactor){

        if (l.equals("w")|| l.equals("s") || l.equals("a") || l.equals("d")) {
            if (map.sample(position1, l)) {
                ChangePosition.move(position1, l);
                System.out.println("Samochod porusza sie, aktualna pozycja to " + position1);
                if(car.os== OrderStatus.ToClient && car.position.getX()==car.order.start.getX() && car.position.getX()==car.order.finish.getX()
                        && car.position.getY()==car.order.start.getY() && car.position.getY()==car.order.finish.getY()){
                    System.out.println("Odebrano pasazera");
                    System.out.println("Pasazer dostarczony na miejsce");
                    car.os= OrderStatus.NoClient;
                    for (Car carTmp : list)
                        CarsSimulation.simulation(map, carTmp, carFactor);
                    map.show();

                }
                else if(car.os== OrderStatus.ToClient && car.position.getX()==car.order.start.getX() && car.position.getY()==car.order.start.getY()){
                    System.out.println("Odebrano pasazera");
                    car.os= OrderStatus.ToDestination;
                    for (Car carTmp : list)
                        CarsSimulation.simulation(map, carTmp, carFactor);
                    map.show();
                    Path.searchingFastest(map, car.position.getY(), car.position.getX(), car.order.finish.getY(), car.order.finish.getX());
                }

                else if (car.os== OrderStatus.ToDestination && car.position.getX()==car.order.finish.getX() && car.position.getY()==car.order.finish.getY() ){
                    System.out.println("Pasazer dostarczony na miejsce");
                    car.os= OrderStatus.NoClient;
                    for (Car carTmp : list)
                        CarsSimulation.simulation(map, carTmp, carFactor);
                    map.show();
                }
            }
            else
                System.out.println("Samochod nie moze jechac w ta strone, aktualna pozycja to " + position1);
        }
        else if(l.equals("m"))
            map.show();
        else if(l.equals("o")){
            if(car.os== OrderStatus.NoClient){
                car.order=new Order();
                IO.getDetails(map, car.order);
                IO.showDetails(car.order);
                if(car.position.getX()==car.order.start.getX() && car.position.getX()==car.order.finish.getX()
                        && car.position.getY()==car.order.start.getY() && car.position.getY()==car.order.finish.getY()){
                    System.out.println("Odebrano pasazera");
                    System.out.println("Pasazer dostarczony na miejsce");
                    for (Car carTmp : list)
                        CarsSimulation.simulation(map, carTmp, carFactor);
                    map.show();
                }
                else if(car.position.getX()==car.order.start.getX() && car.position.getY()== car.order.start.getY()) {
                    System.out.println("Odebrano pasazera");
                    car.os= OrderStatus.ToDestination;
                    for (Car carTmp : list)
                        CarsSimulation.simulation(map, carTmp, carFactor);
                    map.show();
                    Path.searchingFastest(map, car.position.getY(), car.position.getX(), car.order.finish.getY(), car.order.finish.getX());
                }
                else {
                    Path.searchingFastest(map, position1.getY(), position1.getX(), car.order.start.getY(), car.order.start.getX());
                    car.os= OrderStatus.ToClient;
                }
            }
            else
                System.out.println("Samochod ma juz pasazera");


        }

        else if(!l.equals("q"))
            IO.instructions(position1);
    }
}
