import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] array = new int[10000];

        Random zufallszahl = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = zufallszahl.nextInt(10000);
        }

        int start = (int) System.currentTimeMillis();

        QuicksortClean qs = new QuicksortClean();
        int [] arrayQS = qs.sort(array);

        int end = (int) System.currentTimeMillis();
        System.out.println("Quicksort: " + (end - start) + "ms");

        start = (int) System.currentTimeMillis();

        Bubblesort bs = new Bubblesort();
        int [] arrayBS = bs.sort(array);

        end = (int) System.currentTimeMillis();
        System.out.println("Bubblesort: " + (end - start) + "ms");

        for (int i = 0; i < arrayQS.length; i++) {
            System.out.print(arrayQS[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arrayBS.length; i++) {
            System.out.print(arrayBS[i] + " ");
        }
    }
}
