package Oppgave2;

public class InsertionSort {

    // wrapper - klasse
    public static void insertionSortWrapper(Integer[] a) {
        insertionSort(a);
    }

    public static void main(String[] args) {

        Integer[] tall = {5 ,9 ,2 ,46 ,1 ,10};

        for (int t : tall) {
            System.out.print(t + " ");
        }

        insertionSort(tall);
        System.out.println();

        for (int t : tall) {
            System.out.print(t + " ");
        }

    }

    public static void insertionSort(Integer[] a) {

        for(int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i-1; // verdien vi sammenligner med venstre for i

            while (j >= 0 && a[j] > temp) {
                a[j+1] = a[j]; // flytter elementet til høyre
                j--;
            } a[j+1] = temp; // setter inn verdien i temp inn i åpen plass
        }
    }
}
