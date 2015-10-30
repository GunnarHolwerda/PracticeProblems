/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practiceproblems;

/**
 *
 * @author Gunnar
 */
public class MergeSort {
    int[] array, tempMergeArray;
    int length;
    
    public void sort(int[] list) {
        this.array = list;
        this.length = list.length;
        this.tempMergeArray = new int[this.length];
        mergeSort(0, this.length - 1);
        
    }
    
    private void mergeSort(int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex)/2;
            // Break out front of list
            mergeSort(lowerIndex, middle);
            // Break out end of list
            mergeSort(middle + 1, higherIndex);
            //Merge the two current lists together
            mergeLists(lowerIndex, middle, higherIndex);
        }
    }
    
    public void mergeLists(int start, int middle, int last) {
        for (int i = start; i <= last; i++) {
            this.tempMergeArray[i] = this.array[i];
        }
        
        int curMergePosition = start;
        int j = middle + 1;
        int k = start;
        while (curMergePosition <= middle && j <= last) {
            if (this.tempMergeArray[curMergePosition] <= this.tempMergeArray[j]) {
                this.array[k] = this.tempMergeArray[curMergePosition];
                curMergePosition++;
            }
            else {
                this.array[k] = this.tempMergeArray[j];
                j++;
            }
            k++;
        }
        while (curMergePosition <= middle) {
            array[k] = tempMergeArray[curMergePosition];
            k++;
            curMergePosition++;
        }
        
    }
    
}
