/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author zachboburka
 */
public class SortLand {
    
    //bubbleSort Method
    void bubbleSort(int[] sortList){
        int n = sortList.length;
        for  (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (sortList[j] > sortList[j+1])
                {
                    int temp = sortList[j];
                    sortList[j] = sortList[j+1];
                    sortList[j+1] = temp;
                }//if   
    }//bubbleSort
    
    
    //check if array is sorted
    public static boolean checkSort(int sortList[]){
        for(int i = 1; i < sortList.length; i++){
            if(sortList[i - 1] > sortList[i]){
                System.out.println("Not Sorted Correctly");
                return false;
            }//if
        }//for
        System.out.println("Sorted Correctly");
        return true;
    }//checkSort
    
    public void sort(int[] sortList) {
        int size = sortList.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(sortList, size, i);
        }//for
        for (int i = size - 1; i >= 0; i--) {
            int x = sortList[0];
            sortList[0] = sortList[i];
            sortList[i] = x;
            heapify(sortList, i, 0);
        }//for
    }//sort
    
    void heapify(int[] sortList, int heapSize, int i) {
        
        int largest = i; // Initialize largest as root
        int leftTree = 2 * i + 1; // left = 2*i + 1
        int rightTree = 2 * i + 2; // right = 2*i + 2
        
        
        // If left tree is larger than root
        if (leftTree < heapSize && sortList[leftTree] > sortList[largest]) {
            largest = leftTree;
        }//if
        
        
        // If right tree is larger than largest so far
        if (rightTree < heapSize && sortList[rightTree] > sortList[largest]) {
            largest = rightTree;
        }//if
        
        
        // If largest is not root
        if (largest != i) {
            int swap = sortList[i];
            sortList[i] = sortList[largest];
            sortList[largest] = swap;
        // Recursive call to  heapify the sub-tree
            heapify(sortList, heapSize, largest);
        }//if
    }//heapify
    
    public static void runBubbleSort(int sortList[]){
        
        //Measure execution time in milliseconds
        long startTime = System.currentTimeMillis();        
        Sorter bs = new Sorter();
        //Sort Array With Bubble Sort
        bs.bubbleSort(sortList);
        long endTime = System.currentTimeMillis();
        long timeElapsed = (endTime - startTime);
        
        //Print Bubble Sorted List
        System.out.println("Bubble Sorted List");
        System.out.println(Arrays.toString(sortList));
        System.out.println(" ");
        
        //print bubble sort execution time
        System.out.println("Bubble Sort Execution Time : " + timeElapsed + " milliseconds");
        System.out.println(" ");
        
        //check if sort is correct
        checkSort(sortList);
        System.out.println(" ");
        System.out.println(" ");
    }
    
    public static void runHeapSort(int sortList[]){
        
        //Measure execution time in milliseconds
        long startTime = System.currentTimeMillis();        
        
        //Sort Array With Heap Sort
        heapSorter hs = new heapSorter();
        hs.sort(sortList);
        long endTime = System.currentTimeMillis();
        long timeElapsed = (endTime - startTime);
        
        //Print Heap Sorted List
        System.out.println("Heap sort list");
        System.out.println(Arrays.toString(sortList));
        System.out.println(" ");
        
        
        //print heap execution time
        System.out.println("Heap Sort Execution Time : " + timeElapsed + " milliseconds");
        System.out.println(" ");
        
        
        //check if sort is correct
        checkSort(sortList);
        System.out.println(" ");
        System.out.println(" ");
    }
    
    
    public static void main(String[] args) {
        int sortList[] = new int[25];

        //create array
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
        sortList[18] = 95;
        sortList[19] = 70;
        sortList[20] = 99;
        sortList[21] = 1;
        sortList[22] = 9;
        sortList[23] = 8;
        sortList[24] = 39;
        
        runBubbleSort(sortList);
        runHeapSort(sortList);
        
    }
}
