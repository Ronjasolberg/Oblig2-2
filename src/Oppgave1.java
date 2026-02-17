import java.util.Random;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Oppgave1 {

    public static void insertionSort(Integer[] a) {

        int n = a.length;

        // finner minste element og flytter til posisjon 0
        int pos0 = 0;
        for (int t = 1; t < n; t++) {
            if(a[t] < a[pos0]) {
                pos0 = t;
            }
        }
        // Bytter minste element med posisjon 0
        Integer temp = a[0];
        a[0] = a[pos0];
        a[pos0] = temp;

        // Setter inn to elementer om gangen
        for(int i = 1; i < n-1; i+=2) {

            // Henter ut to elementer
            Integer forste = a[i];
            Integer andre = a[i+1];

            // Bestemmer minste og største element
            Integer minste;
            Integer storste;

            if(forste <= andre) {
                minste = forste;
                storste = andre;
            } else {
                minste = andre;
                storste = forste;
            }

            // Setter inn største først
            int j = i -1;
            while (j >= 0 && a[j] > storste) {
                a[j+2] = a[j]; // Flytter elementet to plasser til høyre
                j--;
            }
            a[j+1] = storste;

            // Setter inn minste
            int k = j;
            while (k >= 0 && a[k] > minste) {
                a[k+1] = a[k];
                k--;
            } a[k+1] = minste;
        }

        // Hvis tabellen er oddetall
        if (n % 2 != 0) {
            Integer siste = a[n - 1];
            int l = n - 2;
            while (l >= 0 && a[l] > siste) {
                a[l + 1] = a[l];
                l--;
            }
            a[l + 1] = siste;
        }

    }

    public static void main(String[] args) {

        Random tilfeldig = new Random();
        int n = 100000;
        int antall = 10;
        Integer[][] a = new Integer[antall][n];


        // set inn tilfeldige heiltal i alle rekker
        for (int i = 0; i < antall; i++){
            for (int j = 0; j < n; j++){
                a[i][j] = tilfeldig.nextInt();
            } }

        // start tidsmåling

        long tidSum = 0;
        for (int i = 0; i < antall; i++){
            long start = System.nanoTime();
            insertionSort(a[i]); // a[i] blir ein eindimensjonal tabell
            long slutt = System.nanoTime();
            long tid = slutt - start;
            tidSum += tid;

            double sekunder = tid / 1_000_000_000.0;
            System.out.println("Tid " + i + ": " + sekunder + " sek");

        }

        // Gjennomsnitt
        double gjennomsnitt = (tidSum / 1_000_000_000.0) / antall;
        System.out.println("Gjennomsnitt: " + gjennomsnitt + " sek");

        // Svar på c: ser at denne metoden gir raskere kjøretid enn i a), fra gjennomsnitt på rundt 6 sek til under 1 sek.

    }
}


