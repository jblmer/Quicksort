public class Bubblesort {
    public int[] sort(int[] array) {
        for(int i = 0, x = array.length - 1; i < x; i++) {
            for(int j = 0; j < x - 1; j++) {
                if(array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }
}
