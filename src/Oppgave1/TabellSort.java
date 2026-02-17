package Oppgave1;

import java.util.Random;



public class TabellSort {

    public static void main(String [] args) {


        Random tilfeldig = new Random();
        int n = 120000;
        int antal = 10;
        Integer[][] a = new Integer[antal][n];

        for (int i = 0; i < antal; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = tilfeldig.nextInt();
            }
        }

        long totaltTid=0;

        for (int i = 0; i < antal; i++) {
            Integer [] kopi = a[i].clone();
            long start = System.nanoTime() ;

            SorterTabell.sorterVedInnsetting(kopi);
            long slutt = System.nanoTime() ;
            totaltTid+=(slutt-start);

        }

        double gjennomsnitt=totaltTid/(antal*1_000_000_000.0);

        System.out.println("Gjennomsnitt: " + gjennomsnitt + " sek");


    }



}