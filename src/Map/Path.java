package Map;


public class Path {
    static public void searchingFastest (Map map, int s1, int s2, int f1, int f2){
        int[][] tab1=new int[map.getHeight()][map.getWidth()];
        char[][] tab2=new char[map.getHeight()][map.getWidth()];
        int inf = 1000000;

        if(f1>= s1 && f2>=s2) {

            for (int i = s1; i <= f1; i++) {
                for (int j = s2; j <= f2; j++) {
                    if (i == s1 && j == s2)
                        tab1[i][j] = map.tab[s1][s2];
                     else
                        tab1[i][j] = -1;
                    tab2[i][j] = 's';
                }
            }

            for (int i = s1; i <= f1; i++) {
                for (int j = s2; j <= f2; j++) {
                    if (i != s1 || j != s2) {
                        int x, y;
                        if (i - 1 >= s1)
                            x = map.tab[i][j] + tab1[i - 1][j];
                        else
                            x = inf;

                        if (j - 1 >= s2)
                            y = map.tab[i][j] + tab1[i][j - 1];
                        else
                            y = inf;
                        if (x < y) {
                            tab1[i][j] = x;
                            tab2[i][j] = 'd';
                        } else {
                            tab1[i][j] = y;
                            tab2[i][j] = 'l';
                        }
                    }
                }
            }

        }

        if(s1>= f1 && s2>=f2){
            for (int i = s1; i >= f1; i--) {
                for (int j = s2; j >= f2; j--) {
                    if (i == s1 && j == s2)
                        tab1[i][j] = map.tab[s1][s2];
                     else
                        tab1[i][j] = -1;
                    tab2[i][j] = 's';
                }
            }

            for (int i = s1; i >= f1; i--) {
                for (int j = s2; j >= f2; j--) {
                    if (i != s1 || j != s2) {
                        int x, y;
                        if (i + 1 <= s1)
                            x = map.tab[i][j] + tab1[i + 1][j];
                        else
                            x = inf;

                        if (j + 1 <= s2)
                            y = map.tab[i][j] + tab1[i][j + 1];
                        else
                            y = inf;
                        if (x < y) {
                            tab1[i][j] = x;
                            tab2[i][j] = 'u';
                        } else {
                            tab1[i][j] = y;
                            tab2[i][j] = 'r';
                        }
                    }
                }
            }
        }

        if(s1<=f1 && s2>=f2){
            for (int i = s1; i <= f1; i++) {
                for (int j = s2; j >= f2; j--) {
                    if (i == s1 && j == s2)
                        tab1[i][j] = map.tab[s1][s2];
                    else
                        tab1[i][j] = -1;
                    tab2[i][j] = 's';
                }
            }

            for (int i = s1; i <= f1; i++) {
                for (int j = s2; j >= f2; j--) {
                    if (i != s1 || j != s2) {
                        int x, y;
                        if (i - 1 >= s1)
                            x = map.tab[i][j] + tab1[i - 1][j];
                        else
                            x = inf;

                        if (j + 1 <= s2)
                            y = map.tab[i][j] + tab1[i][j + 1];
                        else
                            y = inf;
                        if (x < y) {
                            tab1[i][j] = x;
                            tab2[i][j] = 'd';
                        } else {
                            tab1[i][j] = y;
                            tab2[i][j] = 'r';
                        }
                    }
                }
            }
        }

        if(s1>=f1 && s2<=f2){
            for (int i = s1; i >= f1; i--) {
                for (int j = s2; j <= f2; j++) {
                    if (i == s1 && j == s2)
                        tab1[i][j] = map.tab[s1][s2];
                    else
                        tab1[i][j] = -1;
                    tab2[i][j] = 's';
                }
            }

            for (int i = s1; i >= f1; i--) {
                for (int j = s2; j <= f2; j++) {
                    if (i != s1 || j != s2) {
                        int x, y;
                        if (i + 1 <= s1)
                            x = map.tab[i][j] + tab1[i + 1][j];
                        else
                            x = inf;

                        if (j - 1 >= s2)
                            y = map.tab[i][j] + tab1[i][j - 1];
                        else
                            y = inf;
                        if (x < y) {
                            tab1[i][j] = x;
                            tab2[i][j] = 'u';
                        } else {
                            tab1[i][j] = y;
                            tab2[i][j] = 'l';
                        }
                    }
                }
            }
        }

        /*for(int i=n-1; i>=0; i--){
            for(int j=0; j<m; j++)
                System.out.print(tab1[i][j] + " ");
            System.out.println();
            System.out.println();
        }
        */

        /*
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<m; j++) {
                System.out.print(tab2[i][j] + " ");
            }
            System.out.println();
            System.out.println();
        }
        */

        int a=Math.abs(f1-s1) + Math.abs(f2-s2);
        String[] tabS= new String[a];
        int i=f1, j=f2, k=0;
        while (tab2[i][j]!='s'){
            if(tab2[i][j]=='l') {
                j =j- 1;
                tabS[k]="wschod";
                k++;


            }
            if(tab2[i][j]=='r') {
                j = j+ 1;
                tabS[k]="zachod";
                k++;


            }
            if(tab2[i][j]=='d') {
                i =i- 1;
                tabS[k]="polnoc";
                k++;


            }
            if(tab2[i][j]=='u') {
                i =i+ 1;
                tabS[k]="poludnie";
                k++;


            }

        }
        for(int z=a-1; z>=0; z--)
            System.out.println("Jedz na " + tabS[z]);


    }

}
