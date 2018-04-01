package Actions;

import Models.Position;

public class ChangePosition {

    public static void move(Position position1, String s){
        if (s.equals("w"))
            position1.setY(position1.getY()+1);
        else if (s.equals("s"))
            position1.setY(position1.getY()-1);
        else if (s.equals("a"))
            position1.setX(position1.getX()-1);
        else if (s.equals("d"))
            position1.setX(position1.getX()+1);
    }

}
