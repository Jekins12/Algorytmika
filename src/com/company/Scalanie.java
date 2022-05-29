package com.company;
import java.util.Scanner;
import java.util.Random;

public class Scalanie {
    static Random przypadkowe = new Random();
    static Trojka[] listaTrojek=new Trojka[100];
    static int[] lista = new int[16];
    static int[] pomocnicza=new int[lista.length];


    public static void generuj (int[] tablica){
        for(int i=0;i<15;i++)
            tablica[i]=przypadkowe.nextInt(100);
    }


    static void scal(int odPoz,int srodek, int doPoz){
        int i=odPoz;
        int j=srodek+1;
        for(int k=odPoz;k<=doPoz;k++){
            if(i>srodek) lista[k]=pomocnicza[j++];
            else if(j>doPoz) lista[k]=pomocnicza[i++];
            else if (pomocnicza[j]<pomocnicza[i]) lista[k]=pomocnicza[j++];
            else lista[k]=pomocnicza[i++];
        }
    }


    static int utworzTrojki(int n){
        int numer=0;
        int tr1,tr2,tr3;
        for (int zakres=2;zakres<2*n;zakres*=2) {
            for (int x = 0; x < n; x += zakres) {
                tr1 = x;
                tr2 = x + (zakres - 1) / 2;
                tr3 = x + zakres - 1;
                listaTrojek[numer++] = new Trojka(tr1, tr2, tr3);
            }
        }
        return numer;
    }

    public static void scalanie(){
        int ile=utworzTrojki(lista.length);
        for(int i=0;i<ile;i++){
            if(listaTrojek[i].x==0) {
                System.arraycopy(lista, 0, pomocnicza, 0, lista.length);
            }
            scal(listaTrojek[i].x,listaTrojek[i].y,listaTrojek[i].z);
        }
    }

    public static void znajdz(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Podaj liczbe: ");
        int liczba=sc.nextInt();
        System.out.println("Liczba " + liczba + " powinna się znaleść pod ineksem="+wyszukaj(lista,liczba));
    }

    static public void drukuj(int[] lista,int type){
        if (type==1){
            System.out.print("Wygenerowana tablica:    ");
            for (int i : lista) System.out.print(i + " ");
        }
        if (type==2){
            System.out.print("Posortowana tablica:    ");
            for (int i : lista) System.out.print(i + " ");
        }
        System.out.println();
    }

    static int wyszukaj(int[] lista, int wartosc) {
        int srodek;
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
        generuj(lista);
        drukuj(lista,1);
        scalanie();
        drukuj(lista,2);
        znajdz();
    }
}


class Trojka{
    int x,y,z;
    public Trojka(int x,int y, int z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
}