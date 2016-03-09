/**
 * Created by Admin on 8.3.2016.
 */
public class ProhledavaniGrafu {
    public static void main(String[] args) {
        prohledavani();
    }
    public static int[][] graf(){
        int [][]graf = {{1, 7, 15, 13, 25},
                        {3, 5, 9, 27, 29},
                        {15, 47, 2, 15, 9},
                        {3, 27, 9, 7, 14},
                        {5, 19, 15, 3, 7}};
        return graf;
    }
    public static int[][] prohledavani(){
        int [][] d = graf();
        int [][] p = new int[0][];
        for(int i = 1; i < 5; i++){
            for(int k = 1; k < 5; k++){
                for(int l = 0; l < 5; l++){
                    if(d[k][l] > d[i][k] + d[k][l]){
                        d[k][l] = d[i][k] + d[k][l];
                        p[k][l] = p[i][l];
                    }
                }
            }
        }
        System.out.println(p.toString());
        return p;
    }
}
