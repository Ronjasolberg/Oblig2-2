package Oppgave1;

public class SorterTabell {

    public static <T extends Comparable<? super T>> void utvalgssortering(T[] a, int n) {
        // Kunne brukt n i ytterste løkka, men når det er berre eit element
        // att vil dette vere det minste.
        for (int i = 0; i < n - 1; i++) {
            // finn indeks for minste element i usortert del
            T min = a[i];
            int minsteIndeks = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j].compareTo(min) < 0) {
                    minsteIndeks = j;
                    min = a[j];
                }
            }
            swap(a, i, minsteIndeks);
        }
    }

    public static <T extends Comparable<? super T>> void sorterVedInnsetting(T[] a) {
        sorterVedInnsetting(a, 0, a.length - 1);
    }

    public static <T extends Comparable<? super T>> void sorterVedInnsetting(T[] a, int forste, int siste) {

        for (int i = forste + 1; i <= siste; i++) {

            T temp = a[i];
            int j = i - 1;

            // finn rett plass. Viktig med rekkefølge på operandeane i
            // betingelsen for whileløkka. Om vi byter, risiserer vi å
            // kome utanfor tabellen
            while (j >= forste && a[j].compareTo(temp) < 0) {
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = temp;
        }
    }




    public static <T extends Comparable<? super T>> void utvalgssortering(T[] a) {
        utvalgssortering(a, a.length);
    }

    public static void swap(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }

    // b)
    public static <T extends Comparable<? super T>> void sorteringToElement(T[] a, int forste, int siste) {

        while(forste < siste) {
            int min = forste; // antar at første er minst
            int max = forste; // antar at første er størst

            // finner minste og største i intervallet[forste, siste]
            for(int i = forste + 1; i <= siste; i++) {
                if(a[i].compareTo(a[min]) < 0) {
                    min = i;
                }

                if(a[i].compareTo(a[max]) > 0) {
                    max = i;
                }

                swap(a, forste, min);
                if(max == forste) {
                    max = min;
                }

                swap(a, siste, max);

                forste++;
                siste--;
            }
        }
    }

    // c)
    public static <T extends Comparable<? super T>> void kombinertSortering(T[] a, int forste, int siste) {

        // flytt minste element
        int minIndex = forste;
        for(int i = forste + 1; i <= siste; i++) {
            if(a[i].compareTo(a[minIndex]) < 0) {
                minIndex = i;
            }
        }
        swap(a, forste, minIndex);

        sorteringToElement(a, forste + 1, siste);
    }

}

