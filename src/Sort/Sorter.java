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
 * @author zachary.boburka
 */
public class Sorter{
    
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
        
    //print array
    void printArray(int sortList[])
    {
        int n = sortList.length;
        for (int i = 0; i<n; ++i)
            System.out.println(sortList[i] + " ");
        System.out.println();
    }//printArray
    
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
    
    //measure execution time
    public static void measureTime(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) {
        Sorter bs = new Sorter();
        int sortList[]= new int[25];

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
        
        bs.bubbleSort(sortList);
        
        //print sorted arry
        System.out.println("Bubble Sorted List");
        System.out.println(Arrays.toString(sortList));
        
        //Measure execution time in milliseconds
        long startTime = System.currentTimeMillis();
        measureTime();
        long endTime = System.currentTimeMillis();
        long timeElapsed = (endTime - startTime);
        
        //print execution time
        System.out.println("Execution Time : " + timeElapsed + " milliseconds");
        
        //check if array is sorted correctly
        checkSort(sortList);
        
    }//main
    
}//sorter
