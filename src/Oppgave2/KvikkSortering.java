package Oppgave2;

import static Oppgave2.FletteSortering.mergeSort;

public class KvikkSortering {

    // wrapper-klasse
    public static void quickSort(Integer[] a) {
        kvikkSortering(a, 0, a.length -1);
    }

    private static void kvikkSortering(Integer[] a, int start, int slutt) {

        if(slutt <= start) return; // Basetilfelle

        int pivot = partering(a, start, slutt);
        kvikkSortering(a, start, pivot-1);
        kvikkSortering(a, pivot + 1, slutt);
    }

    public static int partering(Integer[] a, int start, int slutt) {

        int pivot = a[slutt];
        int i = start - 1;

        for(int j = start; j <= slutt - 1; j++) {
            if(a[j] < pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        i++;
        int temp = a[i];
        a[i] = a[slutt];
        a[slutt] = temp;

        return i;
    }

    public static void main(String[] args) {

        Integer[] tabell = {8,2,4,7,1,3,9,6,5};

        for (int t : tabell) {
            System.out.print(t + " ");
        }

        kvikkSortering(tabell,0,tabell.length-1);

        System.out.println();
        for (int t : tabell) {
            System.out.print(t + " ");
        }

        // 2 b)
        int n = 10000;
        Integer[] likeTall = new Integer[n];
        for (int i = 0; i < n; i++) {
            likeTall[i] = 1;
        }

            long start = System.nanoTime();
            quickSort(likeTall);
            long slutt = System.nanoTime();
            long tid = slutt - start;

            double sekunder = tid / 1_000_000_000.0;
        System.out.println();
        System.out.println(sekunder + " sek");

        }

    }




