package Oppgave2;

import java.util.Random;

import static Oppgave2.FletteSortering.mergeSort;
import static Oppgave2.InsertionSort.insertionSort;
import static Oppgave2.KvikkSortering.quickSort;

public class KjoretidTest {
    public static void main(String[] args) {

        Random tilfeldig = new Random();
        int n = 128000;
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
            mergeSort(a[i]); // a[i] blir ein eindimensjonal tabell
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
