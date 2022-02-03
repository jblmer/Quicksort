import java.util.Random;

public class Quicksort {

    public static void main(String[] args) {
        //ist das Array, welches sortiert werden soll / es hat 10 items
        int[] array = new int[10000];

        //bekommt zufällige Zahlen an alle Stellen des Arrays eingetragen
        Random zufallszahl = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = zufallszahl.nextInt(1000);
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
        //das Array wird der Methode "quicksort" übergeben / beim 1. Aufruf ist das Array noch nicht geteilt, deswegen wird "0 - letztes Element" übergeben / später wird die "quicksort" Methode mit anderen Grenzen aufgerufen
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(int[] array, int links, int right) {
        // End of recursion reached?
        if (links >= right) return;

        //das Array wird in mit der Methode "partition" geteilt / der Bereich wird mit "links" und "rechts" angegeben (je nach Durchlauf unterschiedliche Arraygrenzen)
        //der Index des Pivot wird zurückgegeben und zwischengespeichert, dieser Index wird gebraucht, um zu wissen in welchem Bereich die "neuen" Arrays sortiert werden müssen
        int pivotPos = partition(array, links, right);

        //die Methode ruft sich selbst zwei weitere Male auf
        //einmal um unterhalb des Pivots das Array zu sortieren
        quicksort(array, links, pivotPos - 1);
        //und einmal um oberhalb des Pivots das Array zu sortieren
        quicksort(array, pivotPos + 1, right);
    }

    //die Methode "partition" legt ein Pivot fest und sortiert alle Items, die kleiner sind unterhalb des Pivots und die größeren darüber
    //zusätzlich gibt es den Index des Pivots zurück
    public static int partition(int[] array, int links, int rechts) {
        //das Pivot wird festgelegt (zur Einfachheit nehmen wir das letzte Element)
        int pivot = array[rechts];

        //i gibt die linke Grenze an
        int i = links;
        //j gibt die rechte Grenze an
        //da das letzte Item von Rechts das Pivot ist, müssen wir die rechte Seite um 1 nach links verschieben
        int j = rechts - 1;

        //die while-Schleife läuft so lange, bis die rechte Grenze und die linke Grenze sich in der Mitte treffen
        while (i < j) {
            //es wird ein Element gesucht, dass größer ist als das Pivot (der Index des Elements ist im Index "i" zwischengespeichert)
            while (array[i] < pivot) {
                i++;
            }

            //es wird wieder ein Element gesucht, welches kleiner ist als das Pivot (wird auch durch den Index "j" zwischengespeichert)
            while (j > links && array[j] >= pivot) {
                j--;
            }

            //"i" muss kleiner "j" sein, damit sie getauscht werden können
            if (i < j) {
                //die Elemente mit Index "i" und "j" werden getauscht (temp ist eine Hilfsvariable)
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                //die Grenzen werden weiter nach innen verschoben für den nächsten Durchlauf
                i++;
                j--;
            }
        }

        //"i" == "j" heißt, dass dieser Index noch nicht geprüft wurde
        //Wenn das Item an Index "i" > Pivot ist, muss nichts passieren, sonst muss das Pivot um 1 nach rechts verschoben werden (array[i] < pivot)
        if (i == j && array[i] < pivot) {
            i++;
        }

        //das Pivot ist das letzte Item / es muss final noch einmal zwischen die aufgeteilten Bereiche getauscht werden
        //
        if (array[i] != pivot) {
            //das Pivot bekommt den finalen Platz (temp ist eine Hilfsvariable)
            //array[rechts] gibt das Pivot an / "i" ist die finale Position
            int temp = array[i];
            array[i] = array[rechts];
            array[rechts] = temp;
        }
        //der Index des Pivots wird zurückgegeben
        return i;
    }
}
