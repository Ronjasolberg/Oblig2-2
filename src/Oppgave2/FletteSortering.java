package Oppgave2;

public class FletteSortering {

    // wrapper - klasse
    public static void mergeSort(Integer[] a) {
        fletteSortering(a);
    }

    private static void fletteSortering(Integer[] a){ {

        int lengde = a.length;
        if(lengde <= 1) return; // basetilfelle

        int midten = lengde / 2;
        Integer[] vTabell = new Integer[midten];
        Integer[] hTabell = new Integer[lengde - midten];

        int i = 0; // venstre tabell
        int j = 0; // høyre tabell

        for (; i < lengde; i++) {
            if( i < midten) {
                vTabell[i] = a[i];
            } else {
                hTabell[j] = a[i];
                j++;
            }
        }

        fletteSortering(vTabell);
        fletteSortering(hTabell);
        flett(vTabell, hTabell, a);
    }
}

    // hjelpemetode som sorterer og setter inn
    private static void flett(Integer[] vTabell, Integer[] hTabell, Integer[] tabell) {

        int venstreStr = tabell.length / 2;
        int hoyreStr = tabell.length - venstreStr;
        int i = 0, v = 0, h = 0; // indekser

        // sjekker fletteforholdene
        while(v < venstreStr && h < hoyreStr) {
            if(vTabell[v] < hTabell[h]) {
                tabell[i] = vTabell[v];
                i++;
                v++;
            } else {
                tabell[i] = hTabell[h];
                i++;
                h++;
            }
        }

        while (v < venstreStr) {
            tabell[i] = vTabell[v];
            i++;
            v++;
        }

        while (h < hoyreStr) {
            tabell[i] = hTabell[h];
            i++;
            h++;
        }
    }

    public static void main(String[] args) {

        Integer[] tabell = {5,1,3,8,7,9,2,4,6};
        for(int t : tabell) {
            System.out.print(t + " ");
        }

        fletteSortering(tabell);
        System.out.println();
        for(int t : tabell) {
            System.out.print(t + " ");
        }
    }
}
