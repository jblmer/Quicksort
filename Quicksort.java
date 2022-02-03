import java.util.Random;

public class Quicksort {

    public static void main(String[] args) {
        //array ist das Array, welches sortiert werden soll / es hat 10 items
        int[] array = new int[10];

        //array bekommt zufällige Zahlen an alle Stellen des Arrays eingetragen
        Random zufallszahl = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = zufallszahl.nextInt(20);
        }

        //Durch eine for-Schleife wird das Array einmal vor dem sortieren ausgegeben
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        //der Quicksort sortieralgorythmus wird aufgerufen und das unsortierte Array "array" wird übergeben
        sort(array);

        //nachdem das Array sortiert wurde, wird es sortiert ausgegeben
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void sort(int[] array) {
        //das Array wird dem "quicksort" übergeben / beim 1. Aufruf ist das Array noch nicht geteilt, deswegen wird von 0 - letztes Element übergeben
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(int[] array, int links, int right) {
        // End of recursion reached?
        if (links >= right) return;

        int pivotPos = partition(array, links, right);
        quicksort(array, links, pivotPos - 1);
        quicksort(array, pivotPos + 1, right);
    }

    public static int partition(int[] array, int links, int right) {
        int pivot = array[right];

        int i = links;
        int j = right - 1;
        while (i < j) {
            // Find the first element >= pivot
            while (array[i] < pivot) {
                i++;
            }

            // Find the last element < pivot
            while (j > links && array[j] >= pivot) {
                j--;
            }

            // If the greater element is left of the lesser element, switch them
            if (i < j) {
                //ArrayUtils.swap(array, i, j);
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // i == j means we haven't checked this index yet.
        // Move i rechts if necessary so that i marks the start of the rechts array.
        if (i == j && array[i] < pivot) {
            i++;
        }

        // Move pivot element to its final position
        if (array[i] != pivot) {
            //ArrayUtils.swap(array, i, right);
            int temp = array[i];
            array[i] = array[rechts];
            array[rechts] = temp;
        }
        return i;
    }

}
