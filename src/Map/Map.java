package Map;

import Models.Position;

public class Map {
    private int width;
    private int height;
    public int [][] tab;

    public Map (int width, int height){
        this.width=width;
        this.height=height;
    }

    public  int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean sample(Position position, String s){
        if (s.equals("w")){
            if (position.getY()+1<0 || position.getY()+1>=height)
                return false;
        }
        else if (s.equals("s")){
            if (position.getY()-1<0 || position.getY()-1>=height)
                return false;
        }
        else if (s.equals("a")){
            if (position.getX()-1<0 || position.getX()-1>=width)
                return false;
        }
        else if (s.equals("d")){
            if (position.getX()+1<0 || position.getX()+1>=width)
                return false;
        }
        return true;

    }


    public void show(){
        System.out.println("Mapa oczekiwan na skrzyzowaniach");
        for(int i=height-1; i>=0; i--){
            for (int j=0; j<width; j++){
                System.out.print( tab[i][j] + "s ");
            }
            System.out.println();
            System.out.println();
        }
    }
}
