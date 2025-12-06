//Devin King

import java.util.Scanner;

public class SortSorter {
    
 //Class to hold each string and its SORT count
    static class SortString {
        String text;
        int sortCount;

        SortString(String text) {
            this.text = text;
            this.sortCount = countSorts(text);
        }
    }

  //Count number of times "sort" appears in a string
    public static int countSorts(String str) {
        str = str.toLowerCase();
        int count = 0;
        int index = 0;
        while ((index = str.indexOf("sort", index)) != -1) {
            count++;
            index += 4;
        }
        return count;
    }
// Merge sort to sort SortString array by sortCount
    public static void mergeSort(SortString[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(SortString[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        SortString[] L = new SortString[n1];
        SortString[] R = new SortString[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i].sortCount <= R[j].sortCount) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//Prompts user to enter strings
        while (true) {
            System.out.println("Enter any number of strings and I will sort by SORT's. Once you're done entering sentences enter \"quit\".\n");
            String[] inputStrings = new String[100];
            int count = 0;

            while (true) {
                String line = scanner.nextLine();
                if (line.equalsIgnoreCase("quit")) {
                    break;
                }
                inputStrings[count++] = line;
            }
//Create array of SortString objects
            SortString[] sortStrings = new SortString[count];
            for (int i = 0; i < count; i++) {
                sortStrings[i] = new SortString(inputStrings[i]);
            }

            mergeSort(sortStrings, 0, sortStrings.length - 1);

            System.out.println("sort SORTED!");
            for (SortString s : sortStrings) {
                System.out.println(s.text);
            }

            System.out.println("\nWould you like to sort more Strings?");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                System.out.println("Goodbye!");
                break;
            }
        }

        scanner.close();
    }
}
