package com.company;
import java.text.Collator;
import java.util.Locale;


public class Coll {

    static void porzadkowanie(String[] nazwiska) {                                 //babelkowa metoda sortowania
        Collator porownywacz = Collator.getInstance(new Locale("pl"));
        String x;
        int l = 1;
        boolean posortowana;
        do {
            posortowana = true;
            for (int j = 0; j < nazwiska.length - l; j++) {

                if (porownywacz.compare(nazwiska[j], nazwiska[j + 1]) > 0) {
                    x = nazwiska[j];
                    nazwiska[j] = nazwiska[j + 1];
                    nazwiska[j + 1] = x;
                    posortowana = false;
                }
            }
            l += 1;
        }
        while (!posortowana);
    }

    public static void drukuj(String[] nazwiska, int type){
        if (type==1){
            System.out.print("Nieposortowane alfabetycznie nazwiska:   ");
            for (String s : nazwiska) System.out.print(" " + s);
        }
        else if (type==2){
            System.out.print("Posortowane alfabetycznie nazwiska:   ");
            for (String s : nazwiska) System.out.print(" " + s);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] nazwiska={"Zielinski","Nowak","Cebulski","Adamski","Isalov"};
        drukuj(nazwiska,1);
        porzadkowanie(nazwiska);
        drukuj(nazwiska,2);
    }
}