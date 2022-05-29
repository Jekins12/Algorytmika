package com.company;

import java.util.Scanner;

public class Test {


    private static void printArray(int[] tab) {
        System.out.println();
        for(int i = 0; i < tab.length; i++)
        {
            System.out.print(tab[i] + " | ");
        }
        System.out.println();
    }
    //Funkcja służąca do binarnego wyszukiwania pozycji
    private static int binaryPositionSearch(int[] tab, int selectedElement, int l, int r) {

        System.out.println("Podtablica o indeksach l=" + l + " i r=" + r);

        //W przypadku gdy natrafimy na jeden z warunków
        //zakonczenia algorytmu, zwracamy pozycje

        if (l >= r) {
            if (selectedElement >= tab[l]) {
                System.out.println("ZNALEZIENIE NOWEJ POZYCJI = " + (l + 1));
                System.out.println();
                return l + 1;
            }
            else {
                System.out.println("ZNALEZIENIE NOWEJ POZYCJI = " + l);
                return l;
            }
        }

        int sr = (l + r) / 2;

        //Warunek zakończenia wyszukiwania, dla elemetów o takiej samej wartości
        if (tab[sr] == selectedElement) {
            System.out.println("ZNALEZIENIE NOWEJ POZYCJI = " + ( l + 1) );
            System.out.println();
            return l + 1;
        }

        //W przypadku gdy nie natrafiliśmy na warunek końcowy
        //wywołujemy rekurencyjnie funkcje wyszukiwania binarnego,
        //podając w argumentach indeks odpowiedniej połowy tablicy
        if (selectedElement > tab[sr]) {
            return binaryPositionSearch(tab, selectedElement, sr + 1, r);
        }
        else {
            return binaryPositionSearch(tab, selectedElement, l, sr - 1);
        }


    }

    private static void binarySort(int[] tab) {

        for (int x = 1; x < tab.length; x++) {
            //Wybieramy element który chcemy porównywać
            int selectedElement = tab[x];
            int y = x - 1;

            //Rozpoczynamy przesuwanie elementów szukając miesjca docelowego
            //dla wybranego przez nas elementu
            System.out.println("Rozpoczecie wyszukiwania binarnego nowej pozycji ");
            System.out.println("dla elementu o wartosci = " + selectedElement);
            int pozycja = binaryPositionSearch(tab, selectedElement, 0, y);


            for (y = x - 1; y >= pozycja; y--) {
                tab[y + 1] = tab[y];
            }

            if (x != y + 1) {
                System.out.println("Krok " + (x - 1) + ": Przenoszenie elementu o wartosci " + selectedElement + " z pozycji " + x + " na pozycje " + pozycja);
            }
            else
            {
                System.out.println("Krok " + (x - 1) + ": Element o wartosci " + selectedElement + "pozostaje na pozycji " + x);
            }
            tab[pozycja] = selectedElement;
            printArray(tab);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); //inicjalizujemy Scanner - obiekt pozwalajacy na wczytywanie zmiennych od uzytkownika
        System.out.println("Wprowadz liczbe elementow tablicy: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            System.out.println("Podaj element nr." + i + ": ");
            arr[i]= sc.nextInt(); //wczytujemy kolejne elementy tablicy

        }
        System.out.println("Oto wprowadzona tablica:");
        printArray(arr);
        binarySort(arr);
        System.out.println("Oto wprowadzona tablica po przesortowaniu:");
        printArray(arr);
        sc.close(); //zwalniamy zasoby
    }
}