package com.company;
import java.util.Random;
import java.util.Scanner;

public class TworzenieKopca {
    static Random przypadkowe = new Random();


    public static int[] generuj(int n) {
        int[] lista = new int[n];
        for( int i = 1; i < n; i++) {
            lista[i] = przypadkowe.nextInt(100);
        }
        return lista;
    }


    static boolean JestKopcem(int[] lista) {
        int dlugosc = lista.length;
        boolean jestKopcem = true;
        for(int k =1; k<lista.length; k++) {
            if(2*k>=dlugosc) return true;
            jestKopcem = lista[k] >= lista[2*k];
            if(2*k+1>= dlugosc) return jestKopcem;
            jestKopcem = jestKopcem && lista[k]>=lista[2*k+1];
            if (!jestKopcem) return false;
        }
        return true;
    }


    static int[] zanurzanie(int[] lista){
        for (int k= lista.length/2; k>=1; k--) {
            int j;
            int N = lista.length - 1;
            while(2*k<=N) {
                j = 2*k;
                if(j<N && lista[j] < lista[j+1]) j++;
                if(!(lista[k]<lista[j])) break;
                int pom = lista[k];
                lista[k] = lista[j];
                lista[j] = pom;
                k=j;
            }
        }
        return lista;
    }


    public static void drukuj(int[] liczby) {
        for(int i = 0; i < liczby.length; i++) {
            System.out.print(liczby[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        int[] lista = generuj(20);

        System.out.print("Wygenerowana lista: ");
        drukuj(lista);
        if (JestKopcem(lista)) System.out.println("Lista jest kopcem");

        else{
            System.out.println("Lista nie jest kopcem");
            System.out.println("Czy chcesz zrobić z tej listy kopiec? [1] Tak  [2] Nie");
            System.out.print(": ");
            int answer= input.nextInt();
            if(answer==1){
                zanurzanie(lista);
                System.out.print("Przekształcona lista, która jest kopcem: ");
                drukuj(lista);
            }
            else System.exit(420);
        }





    }
}