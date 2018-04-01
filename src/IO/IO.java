package IO;

import Models.Order;
import Models.Position;
import Map.Map;

import java.util.Scanner;

public class IO {
    public static void instructions(Position position1){
        System.out.println("Aby poruszac wybierz: w - polnoc, s - poludnie, a - zachod, d - wschod");
        System.out.println("Aby zobaczyc aktualny czas oczekiwan na skrzyzowaniach wybierz m");
        System.out.println("Aby wybrac nowego klienta wybierz o");
        System.out.println("Aby zakonczyc dzialanie programu wybierz q");
        System.out.println("Twoja pozycja to "+position1);
    }

    public static void start(){
        System.out.println("Start systemu");
    }

    public static void end(){
        System.out.println("Zakoncenie dzialania systemu");
    }

    public static void getDetails(Map map, Order order) {
        Scanner scanner = new Scanner(System.in);
        String line1;
        System.out.println("Imie: ");
        line1 = scanner.nextLine();
        order.person.setName(line1);
        System.out.println();


        String line2;
        System.out.println("Nazwisko: ");
        line2 = scanner.nextLine();
        order.person.setSurname(line2);
        System.out.println();


        System.out.println("Pozycja oczekujacego pasazera: ");

        int x = -1;
        System.out.println("X: ");
        boolean IsOk = false;
        while (!IsOk) {
            try {
                do {
                    String t = scanner.nextLine();
                    x = Integer.parseInt(t);
                }
                while (x < 0 || x >= map.getWidth());
                order.start.setX(x);
            } catch (NumberFormatException n1) {
                System.out.println("Niepoprawne dane");
            }
            IsOk = x <0 || x>=map.getWidth() ? false : true;

        }
        System.out.println();

        x = -1;
        System.out.println("Y: ");
        IsOk = false;
        while (!IsOk) {
            try {
                do {
                    String t = scanner.nextLine();
                    x = Integer.parseInt(t);
                }
                while (x < 0 || x >= map.getHeight());
                order.start.setY(x);
            } catch (NumberFormatException n1) {
                System.out.println("Niepoprawne dane");
            }
            IsOk = x <0 || x>=map.getHeight() ? false : true;

        }
        System.out.println();

        System.out.println("Pozycja, do ktorej pasazer chce sie udac: ");

        x = -1;
        System.out.println("X: ");
        IsOk = false;
        while (!IsOk) {
            try {
                do {
                    String t = scanner.nextLine();
                    x = Integer.parseInt(t);
                }
                while (x < 0 || x >= map.getWidth());
                order.finish.setX(x);
            } catch (NumberFormatException n1) {
                System.out.println("Niepoprawne dane");
            }
            IsOk = x <0 || x>=map.getWidth() ? false : true;

        }

        x = -1;
        System.out.println("Y: ");
        IsOk = false;
        while (!IsOk) {
            try {
                do {
                    String t = scanner.nextLine();
                    x = Integer.parseInt(t);
                }
                while (x < 0 || x >= map.getHeight());
                order.finish.setY(x);
            } catch (NumberFormatException n1) {
                System.out.println("Niepoprawne dane");
            }
            IsOk = x <0 || x>=map.getHeight() ? false : true;

        }
    }

    public static void showDetails(Order order){
        System.out.println(order.person + " Z: " + order.start + " Do:  " + order.finish);
    }


}
