package Oblig1;


import java.util.NoSuchElementException;


//Elias Skoglund Idrupsen
//s344207
public class Oblig1 {

/*
Spørsmål 1:
Det blir flest ombyttinger i metoden om permutasjonen er  n ->1 i synkende rekkefoelge.
f.eks. (D,C,B,A) hvor D er n og A er 1.

Spørsmål 2:

Det blir faerrest ombyttinger naar permutasjonen er sortert paa den motsatte maaten av spoersmaal 1
altsaafra 1->n, eksempel: (A,B,C,D). dette fordi a[i] !> a[i+1],
 */
//Oppgave 1
    public static int maks(int[] a) {
        if (a.length == 0) {
            throw new NoSuchElementException("The array is empty");
        }

        int begin = 0;
        int end = a.length - 1;

        for (int i = begin; i < end; i++) {
            if (a[i] > a[i + 1]) {
                int Temporary = a[i];
                a[i] = a[i + 1];
                a[i + 1] = Temporary;
            }

        }
        return a[end];
    }

    public static int ombyttinger(int[] a) {
        int count = 0;

        int begin = 0;
        int end = a.length - 1;
        for (int i = begin; i < end; i++) {
            if (a[i] > a[i + 1]) {
                int temporary = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temporary;
                count++;
            }
        }
        return count;
    }

    //Oppgave 2: Antall ulike(sortert)
    public static int antallUlikeSortert(int[] a) {
        if (a.length == 0) {
            return 0;
        }

        boolean sorted = false;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    sorted = false;
                    throw new IllegalStateException("The arrray's numbers are not in ascending order");
                } else {
                    sorted = true;
                }

            }
        }
        int count = 1; //setter count = 1, siden første tallet alltid er "unikt"
        int j; // initialiserer j slik at jeg kan bruke den i "if'en" etter loekken og.

        for (int i = 1; i < a.length; i++) {
            for (j = 0; j < a.length; j++) { //setter j = 0 slik at a[0] ikke blir sammenlignet med a[0]
                if (a[i] == a[j]) {
                    break;
                }
            }
            if (i == j) {
                count++;
            }
        }
        return count;
    }

    //oppgave 3
    public static int antallUlikeUsortert(int[] a) {
        if (a.length == 0) {
            return 0;
        }

        int count = 1;
        int j;

        for (int i = 1; i < a.length; i++) {
            for (j = 0; j < a.length; j++) {
                if (a[i] == a[j]) {
                    break;
                }
            }
            if (i == j) {
                count++;
            }
        }
        return count;
    }

    //Oppgave 4: Delsortering
    public static void quicksort(int [] a, int begin, int end ){
        if (begin >= end) {
            return;
        }

        int index = begin + (end - begin) / 2;
        int pivot = a[index];

        int b = begin;
        int c = end;

        while (b <= c) {
            while (a[b] < pivot) {
                b++;
            }
            while (a[c] > pivot) {
                c--;
            }
            if (b <= c) {
                Oblig1Test.bytt(a,b,c);
                b++;
                c--;
            }
        }

        if (begin < c) {
            quicksort(a, begin, c);
        }
        if (end > b) {
            quicksort(a, b, end);
        }
    }
    public static void delsortering(int[] a) {
        int left = 0, right = (a.length - 1);
        boolean even = false,odd = false;
        while (left < right) {

            while (a[left] % 2 !=0 && left < right) {
                left++;
                odd = true;
            }
            while (a[right] % 2 == 0 && left < right) {
                right--;
                even = true;
            }
            if (left < right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }
        }
        if (!(even && odd)){
            quicksort(a,0,a.length-1);
        }
        else{
            quicksort(a,0,left-1);
            quicksort(a,left,a.length-1);
        }

            }


 //staar 12 relaterte problemer, men er paagrunn av oppgave 6.
    //oppgave 5 rotasjon
    public static void rotasjon(char[] a) {
        int i;
        if (a.length-1 >= 0) {
            char temporary = a[a.length - 1]; //lagrer verdien paa siste index i arrayet.
            for (i = (a.length - 1); i > 0; i--) { //starter paa siste index i arrayet og gaar bakover
                a[i] = a[i - 1];                     // saa lenge indexen er over 0 vil loekken gaa
            }
            a[i] = temporary;   // setter foerste plass i arrayet til det som var sist i arrayet foer loekken.
        }
    }

    //Oppgave 7 fletter
    public static String flett (String s, String t){

        int a =  Math.min(t.length(),s.length());
        StringBuilder b = new StringBuilder();

        for(int i = 0; i < a;i++){
            b.append(s.charAt(i)).append(t.charAt(i));
        }

        b.append(s.substring(a)).append(t.substring(a));


        return b.toString();
    }
    // 7b
    public static String flett (String... s){
        String ferdigFlette = ""; //initialiserer ferdigflette igjen slik at den kan brukes og returneres.
        int stringLengde = 0; //initialiserer stringLengde for aa finne lengste string, maa gjoere samme som i A.

        for(String string : s){
            if(string.length() > stringLengde){
                stringLengde = string.length();
            }
        }

        for(int i = 0; i < stringLengde; i++ ){ // contsrainter for-loekken til den lengste Stringen.
                for(String string : s){
                    if(string.length() > i){
                        char a = string.charAt(i);
                        ferdigFlette += String.valueOf(a);
                    }
                }
        }
        return ferdigFlette;
    }
}
