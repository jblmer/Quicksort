import java.util.Random;

public class Quicksort {

    public static void main(String[] args) {
        //elements ist das Array, welches sortiert werden soll / es hat 10 items
        int[] elements = new int[10];

        //elements bekommt zufällige Zahlen an alle Stellen des Arrays eingetragen
        Random rn = new Random();
        for (int i = 0; i < elements.length; i++) {
            elements[i] = rn.nextInt(20);
        }

        //Durch eine for-Schleife wird das Array einmal vor dem sortieren ausgegeben
        for (int i = 0; i < elements.length; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();

        //der Quicksort sortieralgorythmus wird aufgerufen und das unsortierte Array "elements" wird übergeben
        sort(elements);

        //nachdem die Liste sortiert wurde, wird das sortierte Array ausgegeben
        for (int i = 0; i < elements.length; i++) {
            System.out.print(elements[i] + " ");
        }
    }

    public static void sort(int[] elements) {
        //
        quicksort(elements, 0, elements.length - 1);
    }

    private static void quicksort(int[] elements, int left, int right) {
        // End of recursion reached?
        if (left >= right) return;

        int pivotPos = partition(elements, left, right);
        quicksort(elements, left, pivotPos - 1);
        quicksort(elements, pivotPos + 1, right);
    }

    public static int partition(int[] elements, int left, int right) {
        int pivot = elements[right];

        int i = left;
        int j = right - 1;
        while (i < j) {
            // Find the first element >= pivot
            while (elements[i] < pivot) {
                i++;
            }

            // Find the last element < pivot
            while (j > left && elements[j] >= pivot) {
                j--;
            }

            // If the greater element is left of the lesser element, switch them
            if (i < j) {
                //ArrayUtils.swap(elements, i, j);
                int temp = elements[i];
                elements[i] = elements[j];
                elements[j] = temp;
                i++;
                j--;
            }
        }

        // i == j means we haven't checked this index yet.
        // Move i right if necessary so that i marks the start of the right array.
        if (i == j && elements[i] < pivot) {
            i++;
        }

        // Move pivot element to its final position
        if (elements[i] != pivot) {
            //ArrayUtils.swap(elements, i, right);
            int temp = elements[i];
            elements[i] = elements[right];
            elements[right] = temp;
        }
        return i;
    }

}
