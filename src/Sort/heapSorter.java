/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

/**
 *
 * @author zachboburka
 */
public class heapSorter {

    public void sort(int[] sortList) {

        int n = sortList.length;

        //heap sort
        for (int i = n / 2 - 1; i >= 0; i--) {
            heap(sortList, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = sortList[0];
            sortList[0] = sortList[i];
            sortList[i] = temp;

            heap(sortList, i, 0);

        }//for

    }//sort

    //heap
    void heap(int[] sortList, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && sortList[l] > sortList[largest]) {
            largest = r;
        }

        if (largest != i) {
            int swap = sortList[i];
            sortList[i] = sortList[largest];
            sortList[largest] = swap;

            heap(sortList, n, largest);
        }//if
    }//heap

    //print array
    static void printArray(int[] sortList) {
        int n = sortList.length;
        for (int i = 0; i < n; ++i) {
            System.out.println(sortList[i] + " ");
        }
        System.out.println();
    }//printArray

    public static void main(String[] args) {
        int sortList[] = new int[20];

        sortList[0] = 27;
        sortList[1] = 4;
        sortList[2] = 34;
        sortList[3] = 89;
        sortList[4] = 65;
        sortList[5] = 28;
        sortList[6] = 5;
        sortList[7] = 35;
        sortList[8] = 90;
        sortList[9] = 66;
        sortList[10] = 29;
        sortList[11] = 6;
        sortList[12] = 36;
        sortList[13] = 91;
        sortList[14] = 68;
        sortList[15] = 30;
        sortList[16] = 7;
        sortList[17] = 37;
        sortList[18] = 91;
        sortList[19] = 70;

        int n = sortList.length;

        heapSorter hs = new heapSorter();
        hs.sort(sortList);

        System.out.println("Heap sort list");
        printArray(sortList);

    }//main

}//heapSorter
