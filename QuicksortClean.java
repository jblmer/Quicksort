public class QuicksortClean {

    public int[] sort(int[] array) {
        quicksort(array, 0, array.length - 1);
        return array;
    }

    private static void quicksort(int[] array, int links, int right) {
        if (links >= right) return;
        int pivotPos = partition(array, links, right);
        quicksort(array, links, pivotPos - 1);
        quicksort(array, pivotPos + 1, right);
    }

    public static int partition(int[] array, int links, int rechts) {
        int pivot = array[rechts];
        int i = links;
        int j = rechts - 1;

        while (i < j) {
            while (array[i] < pivot) {
                i++;
            }

            while (j > links && array[j] >= pivot) {
                j--;
            }

            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (i == j && array[i] < pivot) {
            i++;
        }

        if (array[i] != pivot) {
            int temp = array[i];
            array[i] = array[rechts];
            array[rechts] = temp;
        }
        return i;
    }
}
