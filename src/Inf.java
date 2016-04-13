/**
 * Created by Admin on 7.3.2016.
 */
import java.util.Scanner;
public class Inf {
    public static void main(String[] args) throws Exception {
        //System.out.println(preved(16, 16));
        int [] pole = {1, 0, 1, 0};
        System.out.println(prepocetZ2do10(pole));
        int[] pole2 = {0, 1, 1};
        pocitani(pole2, pole);
        //System.out.println(Character.getDirectionality(1+'a'));
        /*
        double celkem = 2;
        double chybnych = 2;
        double pstChyby = 0.03;
        double vysledekRadku;

        System.out.println("Vypocet od 2 do 1024\n");
        System.out.println(" pocet\t| vysledek");

        while (celkem <= 1024){

            vysledekRadku = bernouli(celkem, chybnych, pstChyby);
//            System.out.println(celkem+"\t|"+vysledekRadku);
            System.out.format("%.0f \t| %.20f\n", celkem, vysledekRadku);
            celkem++;
        }


        vypocetIneraktivni();
        preved(15);
        */
    }

    public static void vypocetIneraktivni() throws Exception {

        Scanner sc;
        double n, k, pstK, vysledek;

        sc = new Scanner(System.in);
        System.out.println("Zadej celkovy pocet bitu");
        n = sc.nextDouble();
        System.out.println("Zadej pocet chybnych");
        k = sc.nextDouble();
        System.out.println("Zadej pravdepodobnost chybnych");
        pstK = sc.nextDouble();

        vysledek = bernouli(n, k, pstK);
        System.out.println("Pravdepodobnost celkem: "+vysledek);

    }
    public static double faktorial(double n){
        double vysledek = 1;

        while (n >= 1){
            vysledek = vysledek * n;
            n--;
        }
        return vysledek;
    }

    public static double kombinacniCislo(double n, double k){
        double vysledek = 1;
        double stop = n-k;

        while (n > stop){
            vysledek = vysledek * n;
            n--;
        }

        vysledek = vysledek / faktorial(k);
        return vysledek;

    }

    public static double bernouli(double n, double k, double pstK) throws Exception {
        if (n < k){
            throw new Exception("N nemuze byt mensi nez K");
        }

        return kombinacniCislo(n, k) * Math.pow(pstK, k) * Math.pow(1 - pstK, n-k);
    }
    public static String preved(int v, int vyslednaSoustava){
        char c;
        int zbytek = v % vyslednaSoustava;
        c = (char)(zbytek <= 9 ? zbytek + '0' : (zbytek - 10) + 'a');
        if(v == 0){
            return "";
        }
        String s = preved(v / vyslednaSoustava, vyslednaSoustava);
        return s + c;
    }
    public static double prepocetZ2do10(int[] pole){
        double vysledek = 0;
            for (int i = pole.length; i > 0; i--) {
                if (pole[i] == 1){
                    vysledek = vysledek + Math.pow(2, i);
                }
            }
        return vysledek;
    }
    public static void pocitani(int[] vstup1, int[] vstup2){
        double cislo = prepocetZ2do10(vstup1);
        System.out.println(cislo);
        double  cislo2 = prepocetZ2do10(vstup2);
        System.out.println(cislo2);
        //System.out.println(preved((int)(cislo + cislo2), 2));
        System.out.println(preved((int)(cislo * cislo2), 2));
        //System.out.println(preved((int)(cislo / cislo2), 2));
        //System.out.println(preved((int)(cislo - cislo2), 2));
    }


}
