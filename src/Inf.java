/**
 * Created by Admin on 7.3.2016.
 */
import java.util.Scanner;

public class Inf {

    public static void main(String[] args) throws Exception {

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

}
