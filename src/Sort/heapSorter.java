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
public class heapSorter {

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
    
    public static void measureTime(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

        //Sort Array
        heapSorter hs = new heapSorter();
        hs.sort(sortList);
        
        //Measure execution time in milliseconds
        long startTime = System.currentTimeMillis();
        measureTime();
        long endTime = System.currentTimeMillis();
        long timeElapsed = (endTime - startTime);
        

        //Print Sorted List
        System.out.println("Heap sort list");
        System.out.println(Arrays.toString(sortList));
        
        //print execution time
        System.out.println("Execution Time : " + timeElapsed + " milliseconds");
        
        //check if sort is correct
        checkSort(sortList);
        

    }//main

}//heapSorter
