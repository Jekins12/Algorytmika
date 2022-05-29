package com.company;
import java.util.Random;

public class Wyszukiwanie_bin {

    static int[] lista =new int[20];

    static Random przypadkowe = new Random();


    public static void generuj(int[] lista){
        for(int i=0;i< lista.length-1;i++)
        lista[i] = przypadkowe.nextInt(100);
        }

    static int wyszukaj(int[] lista, int wartosc) {
        int srodek = 0;
        int odPoz = 0;
        int doPoz = lista.length - 1;
        while (!(odPoz > doPoz)) {
            srodek = odPoz + (doPoz - odPoz) / 2;
            if (wartosc < lista[srodek])
                doPoz = srodek - 1;
            else if (wartosc > lista[srodek])
                odPoz = srodek + 1;

            else return srodek;
        }
        return odPoz;
    }

    public static void main(String[] args) {
        int wartosc=2;
        generuj(lista);
        for (int i : lista) System.out.print(i + " ");
        System.out.println(wyszukaj(lista, wartosc));
    }
}