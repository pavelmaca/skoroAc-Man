import java.math.BigInteger;

/**
 * Trida Scitacka predstavuje model scitacky, ktera pouze umi secist dve cela
 * cisla typu BigInteger. Kazda instance teto tridy uchovava dve cela cisla typu
 * BigInteger, ktera se daji menit a je mozne kdykoliv urcit jejich soucet
 * pomoci metody soucet().
 *
 * @author Jaroslav Icha, Štěpán Mudra
 * @version 25.2.2016
 */
public class Scitacka {

    // instancni promenne, ktere uchovavaji dve cisla, ktera se budou scitat
    private BigInteger cislo1;
    private BigInteger cislo2;

    /**
     * Konstruktor pro objekty tridy Scitacka, ktery nastavi hodnoty obou
     * scitanych cisel na hodnoty dane parametry cislo1 a cislo2.
     *
     * @param cislo1 levy scitanec
     * @param cislo2 pravy scitanec
     */
    public Scitacka(BigInteger cislo1, BigInteger cislo2) {
        this.cislo1 = cislo1;
        this.cislo2 = cislo2;
    }

    /**
     * Konstruktor pro objekty tridy Scitacka, ktery nastavi hodnoty obou
     * scitanych cisel na nulu.
     */
    public Scitacka() {
        cislo1 = BigInteger.ZERO;
        cislo2 = BigInteger.ZERO;
        //this(BigInteger.ZERO, BigInteger.ZERO);
    }

    /**
     * Konstruktor pro objekty tridy Scitacka, ktery nastavi hodnoty obou
     * scitanych cisel na hodnotu danou parametrem cislo.
     *
     * @param cislo spolecna hodnota obou scitancu
     */
    public Scitacka(BigInteger cislo) {
        this.cislo1 = cislo;
        this.cislo2 = cislo;
        //this(cislo, cislo);
    }

    /**
     * Metoda, ktera vytvori instanci tridy Scitacka. Potom nastavi hodnotu cisla2 na 1 (v Big Integer) pomoci metody setCoslo2().
     * Dale vytvori promenou soucet a nastavi jeji hodnotu na 0 (v BigInteger).
     * Ve for cyklu nastavi promenou i (int), pocetJednicek pomoci metody compateTo porovna s i + 0 (diky new Big integer dojde k pretypovani i) a k i pricte jedna, pokud rozcil je vetsi nebo roven 0.
     * Pomoci for cyklu prepisuje hodnotu souctu metodou soucet(). Metoda soucet se vola pres instanci tridy Scitacka.
     * Potee se pomoci instance tridy Scitacka vola metoda setCislo1, ktera nastavi hodnotu cisla1 na aktualni hodnotu souctu.
     * Vraci soucet vypocitany.
     *
     * @param pocetJednicek parametr pro for cyklus. Kolikrat je potreba pricist jednicku.
     * @return
     */
    public static BigInteger soucetCisel(BigInteger pocetJednicek) {
        Scitacka instance = new Scitacka();

        instance.setCislo2(BigInteger.ONE);
        BigInteger soucet = BigInteger.ZERO;
        for (int i = 1; pocetJednicek.compareTo(new BigInteger("" + i)) >= 0; i++) {
            soucet = instance.soucet();
            instance.setCislo1(soucet);


        }
        //System.out.println(soucet);
        return soucet;

//        int k = 0;
//        for (int i=O;i<) {
//            return 2;
//        }
    }

    /**
     * Funkce volana metodou main pro otestovani metody soucet cisel.
     * Vypise soucet jednicek.
     */

    public static void testSoucetCisel() {
        System.out.println(Scitacka.soucetCisel(new BigInteger("9")));
    }

    /**
     * Vraci hodnotu leveho scitance.
     *
     * @return Metoda vraci hodnotu scitance cislo1 z vyrazu cislo1 + cislo2,
     * ktery se da vyhodnotit pomoci metody soucet().
     */
    public BigInteger getCislo1() {
        return cislo1;
    }

    /**
     * Vraci hodnotu praveho scitance.
     *
     * @return Metoda vraci hodnotu scitance cislo2 z vyrazu cislo1 + cislo2,
     * ktery se da vyhodnotit pomoci metody soucet().
     */
    public BigInteger getCislo2() {
        return cislo2;
    }

    /**
     * Metoda nastavi hodnotu leveho scitance pomoci parametru cislo1.
     *
     * @param cislo1 hodnota typu BigInteger, ktera se pouzije k nastaveni
     * leveho scitance
     */
    public void setCislo1(BigInteger cislo1) {
        this.cislo1 = cislo1;
    }

    /**
     * Metoda nastavi hodnotu leveho scitance pomoci parametru cislo1.
     *
     * @param cislo1 hodnota typu BigInteger, ktera se pouzije k nastaveni
     * leveho scitance
     * @param cislo2 hodnota typu BigInteger, ktera se pouzije k nastaveni
     * praveho scitance
     */
    public void setCislo1ACislo2(BigInteger cislo1, BigInteger cislo2) {
        this.cislo1 = cislo1;
        this.cislo2 = cislo2;
//        setCislo1(cislo1);
//        setCislo2(cislo2);
    }

    /**
     * Metoda nastavi hodnotu praveho scitance pomoci parametru cislo2.
     *
     * @param cislo2 hodnota typu BigInteger, ktera se pouzije k nastaveni
     * praveho scitance
     */
    public void setCislo2(BigInteger cislo2) {
        this.cislo2 = cislo2;
    }

    /**
     * Vraci soucet dvou cisel typu BigInteger, ktera jsou ulozena v instanci.
     *
     * @return Vraci hodnotu typu BigInteger, ktera predstavuje soucet obou
     * cisel ulozenych v instanci.
     */
    public BigInteger soucet() {
        return cislo1.add(cislo2);
    }

    /**
     * Vraci znakovou reprezentaci instance, ktera popisuje jeji stav.
     *
     * @return Vraci objekt typu String, ktery obsahuje hodnoty obou scitanych
     * cisel. Priklad: "Scitacka{cislo1 = 23, cislo2 = 123}".
     */
    @Override
    public String toString() {
        return "Scitacka{" + "cislo1=" + cislo1 + ", cislo2=" + cislo2 + '}';
    }

    /**
     * Testovaci metoda, ktera vytvori novou scitacku, kterou inicializuje
     * pomoci parametru levyScitanec a pravyScitenec. Potom vytiskne oba
     * scitance a jejich soucet.
     *
     * @param levyScitanec levy scitanec
     * @param pravyScitanec pravy scitanec
     */
    public static void testScitacka(BigInteger levyScitanec, BigInteger pravyScitanec) {
        Scitacka scitacka = new Scitacka(levyScitanec, pravyScitanec);
        System.out.println(scitacka);
        BigInteger cislo1 = scitacka.getCislo1();
        BigInteger cislo2 = scitacka.getCislo2();
        BigInteger soucet = scitacka.soucet();
        System.out.println("součet čísel " + cislo1 + " a " + cislo2 + " = " + soucet);
        System.out.println();
    }

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testSoucetCisel();
        //testScitacka(BigInteger.ONE, BigInteger.ONE);
        //soucetCisel(new BigInteger ("2"));
        /*
        testScitacka(BigInteger.ZERO, BigInteger.ZERO);

        testScitacka(new BigInteger("5"), new BigInteger("5"));

        testScitacka(new BigInteger("5"), new BigInteger("10"));

        testScitacka(new BigInteger("111111111111111111"), new BigInteger("222222222222222222222222"));

        testScitacka(new BigInteger("" + Integer.MAX_VALUE), BigInteger.ONE);

        testScitacka(new BigInteger("" + Integer.MAX_VALUE), new BigInteger("" + Integer.MAX_VALUE));

        testScitacka(new BigInteger("" + Integer.MIN_VALUE), new BigInteger("" + Integer.MIN_VALUE));
         */
    }

}
