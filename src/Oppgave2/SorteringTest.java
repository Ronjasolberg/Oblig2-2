package Oppgave2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static Oppgave1.SorterTabell.kombinertSortering;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SorteringTest {

    private Integer[] tab;

    @BeforeEach
    void testTabell() {
        tab = new Integer[]{5,9,2,0,1,6,8,25,12,23};
    }

    @Test
    void kvikkSorteringTest() {

        // tar en kopi av tabellen
        Integer[] forventet = tab.clone();
        // metode fra Arrays som sorterer tabellen
        Arrays.sort(forventet);

        KvikkSortering.quickSort(tab);
        assertArrayEquals(forventet, tab);
    }

    @Test
    void fletteSorteringTest() {

        Integer[] forventet = tab.clone();
        Arrays.sort(forventet);

        FletteSortering.mergeSort(tab);
        assertArrayEquals(forventet, tab);
    }

    @Test
    void insertionSortTest() {
        Integer[] forventet = tab.clone();
        Arrays.sort(forventet);

        InsertionSort.insertionSortWrapper(tab);
        assertArrayEquals(forventet, tab);
    }

    @Test
    void selectionSortTest() {
        Integer[] forventet = tab.clone();
        Arrays.sort(forventet);

        SelectionSort.selectionSortWrapper(tab);
        assertArrayEquals(forventet, tab);
    }





}
