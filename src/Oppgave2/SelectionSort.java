package Oppgave2;

public class SelectionSort {

    // wrapper - klasse
    public static void selectionSortWrapper(Integer[] tab) {
        sorterListe(tab);
    }


    private static void sorterListe(Integer[] tab) {

        for (int i = 0; i < tab.length - 1; i++) {

            int minsteIndex = i;

            for (int j = i + 1; j < tab.length; j++) {
                if (tab[j] < tab[minsteIndex]) {
                    minsteIndex = j;
                }
            }

            // Bytt plass
            int temp = tab[i];
            tab[i] = tab[minsteIndex];
            tab[minsteIndex] = temp;
        }
    }


    public static void main(String[] args) {
        Integer[] poeng = {45, 12, 78, 35, 10};
        System.out.println("Før sortering: ");
        for (int p : poeng) {
            System.out.print(p + " ");
        }

        System.out.println();
        System.out.println("Etter sortering: ");
        sorterListe(poeng);
        for (int p : poeng) {
            System.out.print(p + " ");
        }

    }
}

