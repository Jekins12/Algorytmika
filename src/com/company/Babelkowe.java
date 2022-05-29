package com.company;
import java.util.Random;

public class Babelkowe {
    static Random przypadkowe = new Random();


    static int[] sortowanie(int[] tablica){
        int x=0;
        int l=1;
        boolean posortowana;
        do {
            posortowana=true;
            for(int j=0; j< tablica.length-l;j++){

                if(tablica[j]>tablica[j+1]){
                    x=tablica[j];
                    tablica[j]=tablica[j+1];
                    tablica[j+1]=x;
                    posortowana=false;
                }
            }
            l+=1;
        }
        while (!posortowana);
        return tablica;
    }

    public static void drukuj(int[] tablica){
        for(int i=0;i< tablica.length;i++) {
            System.out.print(" " + tablica[i]);
        }
    }

    public static void generuj(int[] tablica){
        for(int i=0; i< tablica.length;i++){
            tablica[i]=przypadkowe.nextInt(100);
            System.out.print(" "+ tablica[i]);
        }
    }

    public static void main(String[] args) {
        int[] tablica=new int[20];
        generuj(tablica);
        System.out.println();
        sortowanie(tablica);
        drukuj(tablica);
    }
}