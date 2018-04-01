package Main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import IO.IO;
import Models.Car;
import Map.Map;

public class Main {
    public static void main(String[] args){
        IO.start();
        Car car= new Car();
        int m=5;
        int n=7;
        int carNumber = 5;
        int carFactor = 2;

        Map map= new Map(m, n);

        map.tab=new int[n][m];



        for(int i=0; i<n; i++){
            for(int j=0; j<m ; j++)
                map.tab[i][j]=30;
        }




        List<Car> list=new ArrayList<Car>();
        for (int i=0 ; i< n; i++){
            for (int j=0; j<m ; j++){
                for (int k=0; k<carNumber; k++){
                    Car carTmp = new Car();
                    carTmp.position.setY(i);
                    carTmp.position.setX(j);
                    list.add(carTmp);
                }
            }
        }

        for (Car carTmp : list)
            map.tab[carTmp.position.getY()][carTmp.position.getX()]+=carFactor;



        map.show();
        IO.instructions(car.position);
        Scanner scanner= new Scanner(System.in);
        String line;
        do {
            line = scanner.nextLine();
            MainController.run(line, car, list, car.position, map, carFactor);
        }
        while(!line.equals("q"));
        IO.end();

    }

}
