/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

/**
 *
 * @author zachary.boburka
 */
public class Sorter {
    //return values
    int[] sortedValue;
    int[] sortedValue2;
   
    
    
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
        
    void printArray(int sortList[])
    {
        int n = sortList.length;
        for (int i = 0; i<n; ++i)
            System.out.println(sortList[i] + " ");
        System.out.println();
    }//printArray
    
    
    public static void main(String[] args) {
        Sorter bs = new Sorter();
        int sortList[]= new int[20];

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
        
        bs.bubbleSort(sortList);
        System.out.println("Bubble Sorted List");
        bs.printArray(sortList);
    }//main
    
}//sorter
